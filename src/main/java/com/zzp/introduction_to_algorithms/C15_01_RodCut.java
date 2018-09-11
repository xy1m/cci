package com.zzp.introduction_to_algorithms;

import java.util.Arrays;

public class C15_01_RodCut {

    public static int cut(int[] p, int n) {
        if (n == 0) return 0;
        int result = p[n - 1];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, cut(p, i) + cut(p, n - i));
        }
        return result;
    }

    public static int cut1(int[] p, int n) {
        if (n == 0) return 0;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, p[i - 1] + cut1(p, n - i));
        }
        return result;
    }

    public static int cutMemo(int[] p, int n) {
        int[] r = new int[n + 1];
        Arrays.fill(r, 1, n + 1, Integer.MIN_VALUE);
        return cutMemoSub(p, n, r);
    }

    public static int cutMemoSub(int[] p, int n, int[] r) {
        if (r[n] >= 0) return r[n];
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cutMemoSub(p, n - i, r));
        }
        r[n] = q;
        return q;
    }

    public static int cutMemoBottomUp(int[] p, int n) {
        int[] r = new int[n + 1];
        int[] s = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < p[i - 1] + r[j - i]) {
                    q = p[i - 1] + r[j - i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        printCut(s, n);
        return r[n];
    }

    public static void printCut(int[] s, int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            System.out.println(s[n]);
            n -= s[n];
        }
    }

    public static void main(String[] args) {
        int[] p = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(cut(p, 4));
        System.out.println(cut1(p, 4));
        System.out.println(cutMemo(p, 4));
        System.out.println(cutMemoBottomUp(p, 7));
    }
}
