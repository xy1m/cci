package com.zzp.cci.recurive;

public class Fibonacci {

    public int f1(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return f1(i - 1) + f1(i - 2);
    }

    public int f2(int i, int[] memo) {
        if (i == 0 || i == 1) return i;
        if (memo[i] == 0) {
            memo[i] = f2(i - 1, memo) + f2(i - 2, memo);
        }
        return memo[i];
    }

    public int f3(int n) {
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
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.f2(100, new int[101]));
    }
}
