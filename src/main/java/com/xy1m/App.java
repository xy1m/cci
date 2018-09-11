package com.zzp;

import java.math.BigInteger;
import java.util.*;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    /**
     * TODO
     * unicode vs ascii
     * <p>
     * <p>
     * <p>
     * Q5_00_BitOperation operations
     * Heap
     * PriorityQueue
     * Sort
     * Search
     *
     * @param args
     */
    public static void main1(String[] args) {
        /*Integer[] res = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.asList(res);
        list.forEach(e -> {
            System.out.println(e);
        });
        Integer[] res2 = new Integer[2];
        Arrays.fill(res2, 0);
        System.out.println(res2[0]);
        test:
        for(int i=0;i<5;i++){
            Set set=new HashSet();
            for (int j=0;j<5;j++){
                if(j==1){
                    continue test;
                }
            }
        }
        Collections.sort(list,Comparator.reverseOrder());*/
        StringBuilder sb = new StringBuilder("01234567");
        String s = "01234567";

        System.out.println(sb.substring(0, 0));
        System.out.println(s.substring(0, 1));

        int[] arr = new int[3];

        Arrays.sort(arr);

        Arrays.fill(arr, 0);

        Queue<Integer> queue = new LinkedList();
        queue.offer(1);
        queue.peek();
        queue.poll();
        queue.isEmpty();
        queue.size();

        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.peek();
        stack.pop();
        stack.isEmpty();
        Deque<Integer> deque = new LinkedList<>();

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());

        Queue<Integer> q2 = new PriorityQueue();

        Character character = 'c';
        String s1 = "";
        s.equalsIgnoreCase("");
        Character.isAlphabetic(1);

        BigInteger bigInteger = new BigInteger("0");
        bigInteger.shiftLeft(1);
        Integer.bitCount(1);
        Arrays.fill(arr, 0, 1, 1);
        "".trim();
        Math.sqrt(1);
        Map map = new HashMap();
        map.put(1, 1);

        StringJoiner sj1 = new StringJoiner(",", "[", "]");
        StringJoiner sj2 = new StringJoiner(",", "[", "]");
        sj1.add("1");
        sj1.add("2");
        sj1.add("3");
        sj2.add("4");
        sj2.add("5");
        sj2.add("6");
        sj1.merge(sj2);
        System.out.println(sj1.toString());

        Map.Entry<String, Integer> entry;
        List list = new ArrayList();
        list.add(0, 1);
        char x = 0x0061;
        System.out.println(x);

        char[] chars = new char[5];
    }

    public static void cashRegister(double cost, double pay) {
        double diff = pay - cost;
        if (diff < 0) {
            throw new RuntimeException("Pay not enough");
        }
        Double[] coins = new Double[]{20d, 5d, 1d, 0.25, 0.1, 0.01};
        combine(coins, diff, 0, new ArrayList<Double>());
    }

    public static void combine(Double[] coins, Double amount, int index, List<Double> tmp) {
        if (index >= coins.length) return;
        if (amount.equals(0)) {
            // print tmp;
            tmp.forEach(i -> System.out.print(i + " "));
            System.out.println();
            return;
        }
        double denormAmount = coins[index];
        if (denormAmount > amount) {
            combine(coins, amount, index + 1, tmp);
            return;
        }
        for (int i = 0; i * denormAmount <= amount; i++) {
            double remain = amount - i * denormAmount;
            for (int j = 0; j < i; j++) {
                tmp.add(denormAmount);
            }
            combine(coins, remain, index + 1, tmp);
            for (int j = 0; j < i; j++) {
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{new int[]{0, 2}, new int[]{1, 2}, new int[]{2, 0}};
    }
}