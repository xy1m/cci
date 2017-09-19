package com.zzp.funny.kv;

import java.util.*;

interface Database {
    // Data commands
    String get(String name);

    int numEqualTo(String value);

    void set(String name, String value);

    void unset(String name);

    boolean isInTransaction();

    // Transaction commands
    void begin();

    String rollback();

    String commit();

    void clear();
}

interface Undo {
    void apply();
}

class Set implements Undo {
    private Storage db;
    private String name;
    private String value;

    public Set(Storage db, String name, String value) {
        this.db = db;
        this.name = name;
        this.value = value;
    }

    @Override
    public void apply() {
        db.set(name, value);
    }
}

class Unset implements Undo {
    private Storage db;
    private String name;

    public Unset(Storage db, String name) {
        this.db = db;
        this.name = name;
    }

    @Override
    public void apply() {
        db.unset(name);
    }
}

final class Console {
    public static final String PREFIX = "> ";

    public static void logInput(String content) {
        System.out.println(content);
    }

    public static void logOutputIfPresent(String content) {
        if (content != null) {
            System.out.println(PREFIX + content);
        }
    }
}

final class Transaction {
    private final Storage db;
    private final Stack<Undo> log = new Stack<>();

    public Transaction(Storage db) {
        this.db = db;
    }

    void logSet(String name, String old) {
        Undo undo = old == null ? new Unset(db, name) : new Set(db, name, old);
        log.push(undo);
    }

    void logUnset(String name, String old) {
        if (old != null) {
            log.push(new Set(db, name, old));
        }
    }

    void rollback() {
        while (!log.isEmpty()) {
            Undo undo = log.pop();
            undo.apply();
        }
    }
}

final class TransactionManager {
    private final Storage db;
    private final Stack<Transaction> transactions = new Stack<>();

    public TransactionManager(Storage db) {
        this.db = db;
    }

    void logSet(String name, String old) {
        if (isInTransaction()) {
            transactions.peek().logSet(name, old);
        }
    }

    void logUnset(String name, String old) {
        if (isInTransaction()) {
            transactions.peek().logUnset(name, old);
        }
    }

    boolean isInTransaction() {
        return !transactions.isEmpty();
    }

    void begin() {
        transactions.push(new Transaction(db));
    }

    String rollback() {
        if (!isInTransaction()) {
            return "NO TRANSACTION";
        }
        Transaction t = transactions.pop();
        t.rollback();
        return null;
    }

    String commit() {
        if (!isInTransaction()) {
            return "NO TRANSACTION";
        }
        transactions.clear();
        return null;
    }

    void clear() {
        transactions.clear();
    }
}

final class Storage {
    private final Map<String, String> entries = new HashMap<>();
    private final Counter counter = new Counter();

    String get(String name) {
        return entries.getOrDefault(name, "NULL");
    }

    int numEqualTo(String name) {
        return counter.count(name);
    }

    String set(String name, String value) {
        String old = entries.put(name, value);
        counter.remove(old);
        counter.add(value);
        return old;
    }

    String unset(String name) {
        String old = entries.remove(name);
        counter.remove(old);
        return old;
    }

    void clear() {
        entries.clear();
        counter.clear();
    }
}

final class Counter {
    private final Map<String, Integer> map = new HashMap<>();

    int count(String name) {
        return map.getOrDefault(name, 0);
    }

    void add(String name) {
        map.merge(name, 1, Integer::sum);
    }

    void remove(String name) {
        map.computeIfPresent(name, (k, v) -> decrementOrRemove(v));
    }

    private Integer decrementOrRemove(int count) {
        return count <= 1 ? null : --count;
    }

    void clear() {
        map.clear();
    }
}


class SimpleDB implements Database {
    private final Storage storage;
    private final TransactionManager transactionManager;

    public SimpleDB() {
        storage = new Storage();
        transactionManager = new TransactionManager(storage);
    }


    @Override
    public String get(String name) {
        return storage.get(name);
    }

    @Override
    public int numEqualTo(String name) {
        return storage.numEqualTo(name);
    }

    @Override
    public void set(String name, String value) {
        String old = storage.set(name, value);
        transactionManager.logSet(name, old);
    }

    @Override
    public void unset(String name) {
        String old = storage.unset(name);
        transactionManager.logUnset(name, old);
    }

    @Override
    public boolean isInTransaction() {
        return transactionManager.isInTransaction();
    }

    @Override
    public void begin() {
        transactionManager.begin();
    }

    @Override
    public String rollback() {
        return transactionManager.rollback();
    }

    @Override
    public String commit() {
        return transactionManager.commit();
    }

    @Override
    public void clear() {
        storage.clear();
        transactionManager.clear();
    }
}

enum OPERATION {
    GET(1) {
        @Override
        String call(Database db, List<String> args) {
            return db.get(args.get(0));
        }
    },
    NUMEQUALTO(1) {
        @Override
        String call(Database db, List<String> args) {
            return "" + db.numEqualTo(args.get(0));
        }
    },
    SET(2) {
        @Override
        String call(Database db, List<String> args) {
            db.set(args.get(0), args.get(1));
            return null;
        }
    },
    UNSET(1) {
        @Override
        String call(Database db, List<String> args) {
            db.unset(args.get(0));
            return null;
        }
    },
    BEGIN {
        @Override
        String call(Database db, List<String> args) {
            db.begin();
            return null;
        }
    },
    ROLLBACK {
        @Override
        String call(Database db, List<String> args) {
            return db.rollback();
        }
    },
    COMMIT {
        @Override
        String call(Database db, List<String> args) {
            return db.commit();
        }
    },
    UNKNOW(-1) {
        @Override
        String call(Database db, List<String> args) {
            return "UNKNOW OPERATION";
        }
    },
    END {
        @Override
        String call(Database db, List<String> args) {

            return null;
        }
    };

    private int expectedArgs;

    OPERATION(int expectedArgs) {
        this.expectedArgs = expectedArgs;
    }

    OPERATION() {
        this(0);
    }

    static OPERATION parse(String op) {
        try {
            return valueOf(op.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOW;
        }
    }

    String apply(Database db, List<String> args) {
        return isValid(args) ? call(db, args) : reject(args);
    }

    private String reject(List<String> args) {
        return String.format("WRONG ARGUMENTS - EXPECTED: %1s, ACTUAL: %2s", expectedArgs, args.size());
    }

    private boolean isValid(List<String> args) {
        return expectedArgs < 0 || expectedArgs == args.size();
    }

    abstract String call(Database db, List<String> args);
}

class Command {
    OPERATION operation;
    Database db;
    List<String> args;

    public Command(Database db, OPERATION operation, String... args) {
        this.db = db;
        this.operation = operation;
        this.args = Arrays.asList(args);
    }

    boolean isEnd() {
        return operation.equals(OPERATION.END);
    }

    String apply() {
        return operation.apply(db, args);
    }
}

class Parser {
    private final Database db;

    public Parser(Database db) {
        this.db = db;
    }

    public Command parse(String line) {
        String[] arr = line.split("\\s+");
        OPERATION op = OPERATION.parse(arr[0]);
        String[] args = Arrays.copyOfRange(arr, 1, arr.length);
        return new Command(db, op, args);
    }
}

/**
 * @Storage is the unique data realm and keep the latest information, it contains @Map and @Counter to store data
 * and counter information respectively, when there is any write operation, update them accordingly.
 * @TransactionManager records a series of @Transaction in a @Stack, when transaction operation executed, manipulate the
 * stackqueue accordingly, as data operations, perform in current transaction.
 * @Transaction records the status before data operations perform, when rollback, just perform all the Undo operation in
 * the log stackqueue.
 */
public class SimpleDB3 {
    public static void main(String args[]) throws Exception {
        SimpleDB db = new SimpleDB();
        Parser parser = new Parser(db);
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            Console.logInput(input);
            // Handle blank input
            if (input == null || input.trim().length() == 0) {
                continue;
            }
            Command cmd = parser.parse(input);
            if (cmd.isEnd()) {
                break;
            }
            Console.logOutputIfPresent(cmd.apply());
        }
    }
}
