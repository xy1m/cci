package com.zzp.cci.chapter08_recursion_dynamic_programming;

public class Q8_00_Fibonacci {

    public static int f1(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return f1(i - 1) + f1(i - 2);
    }

    public static int f2(int i, int[] memo) {
        if (i == 0 || i == 1) return i;
        if (memo[i] == 0) {
            memo[i] = f2(i - 1, memo) + f2(i - 2, memo);
        }
        return memo[i];
    }

    public static int f3(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(f2(100, new int[101]));
    }
}
