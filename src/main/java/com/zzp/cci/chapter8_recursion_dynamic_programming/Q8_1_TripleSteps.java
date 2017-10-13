package com.zzp.cci.chapter8_recursion_dynamic_programming;

import java.util.Arrays;

// BigInteger to solve boundary problem
public class Q8_1_TripleSteps {
    public int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    public int countWays(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] > -1) return memo[n];
        return countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
    }

    public static void main(String[] args) {
        Q8_1_TripleSteps app = new Q8_1_TripleSteps();
        System.out.println(app.countWays(10));
    }
}
