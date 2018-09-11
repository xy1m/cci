package com.zzp.cci.chapter8_recursion_dynamic_programming;

// BigInteger to solve boundary problem
public class Q8_01_TripleSteps {
    public static int countWays(int n) {
        int[] memo = new int[n + 1];
        return countWays(n, memo);
    }

    public static int countWays(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] > 0) return memo[n];
        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(30));
    }
}
