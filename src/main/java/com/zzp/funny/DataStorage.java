package com.zzp.funny;

import java.util.*;

class User {
    private int id;
    private String firstName;

    public User(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
}

public class DataStorage {
    public static void sortThenPrintUsers(List<String> inputs) {
        // Build users
        List<User> users = new ArrayList<>();
        inputs.forEach(s -> {
            String[] row = s.split(",");
            users.add(new User(Integer.valueOf(row[0]), row[1]));
        });
        // Sort by name, id asc
        Collections.sort(users, Comparator.comparing(User::getFirstName).thenComparing(User::getId));
        // Print
        users.forEach(user -> System.out.println(user));
    }

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            inputs.add(input);
        }
        sortThenPrintUsers(inputs);
    }
}