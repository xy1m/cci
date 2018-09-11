package com.zzp.cci.chapter8_recursion_dynamic_programming;

public class Q8_05_RecursiveMultiply {

    static int minProduct(int a, int b) {
        int small = a < b ? a : b;
        int big = a < b ? b : a;
        return minProductHelper(small, big);
    }

    static int minProductHelper(int small, int big) {
        if (small == 0) return 0;
        if (small == 1) return big;
        int s = small >> 1;

        int side1 = minProductHelper(s, big);
        int side2 = side1;
        if ((small & 1) == 1) {
            side2 = minProductHelper(small - s, big);
        }
        return side1 + side2;
    }

    static int minProductMemo(int a, int b) {
        int small = a < b ? a : b;
        int big = a < b ? b : a;
        int[] memo = new int[small + 1];
        return minProductMemoHelper(small, big, memo);
    }

    static int minProductMemoHelper(int small, int big, int[] memo) {
        if (small == 0) return 0;
        if (small == 1) return big;
        if (memo[small] > 0) return memo[small];

        int s = small >> 1;

        int side1 = minProductHelper(s, big);
        int side2 = side1;
        if ((small & 1) == 1) {
            side2 = minProductHelper(small - s, big);
        }
        memo[small] = side1 + side2;
        return side1 + side2;
    }

    static int minProductFast(int a, int b) {
        int small = a < b ? a : b;
        int big = a < b ? b : a;
        return minProductFastHelper(small, big);
    }

    static int minProductFastHelper(int small, int big) {
        if (small == 0) return 0;
        if (small == 1) return big;

        int s = small >> 1;

        int side1 = minProductHelper(s, big);
        int side2 = side1;
        if ((small & 1) == 1) {
            side2 += big;
        }
        return side1 + side2;
    }


    public static void main(String[] args) {
        System.out.println(minProduct(5, 8));
        System.out.println(minProductMemo(5, 8));
        System.out.println(minProductFast(5, 8));
    }
}
