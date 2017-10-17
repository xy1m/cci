package com.zzp.cci.chapter8_recursion_dynamic_programming;

public class Q8_11_Coins {
    // Recursion
    public static int makeChange(int amount, int[] denoms, int index) {
        if (index == denoms.length - 1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    public static int makeChange(int n) {
        int[] denoms = new int[]{25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    // Add cache
    public static int makeChangeMemo(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) return map[amount][index];
        if (index == denoms.length - 1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChangeMemo(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    public static int makeChangeMemo(int n) {
        int[] denoms = new int[]{25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length];
        return makeChangeMemo(n, denoms, 0, map);
    }

    public static void main(String[] args) {
        int coins = 1000;
        System.out.println(makeChange(coins));
        System.out.println(makeChangeMemo(coins));
    }
}
