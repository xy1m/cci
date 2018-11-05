package com.xy1m.cci.chapter16_moderate;

/**
 * Number Swapper: Write a function to swap a number in place (that is, without temporary variables).
 */
public class Q16_01_NumberSwapper {

    public static void swapDiff(int a, int b) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        a = a - b;
        // a1 is diff now
        b = a + b;
        // b1 add diff=a0
        a = b - a;
        // b1 is original a0 now, a0 minus diff = b0
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public static void swapXor(int a, int b) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        a ^= b;
        // a=a^b
        b ^= a;
        // b=a^b^b=a
        a ^= b;
        // a=a^b^a^b^b=b
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public static void main(String[] args) {
        swapDiff(Integer.MAX_VALUE, Integer.MIN_VALUE);
        swapXor(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}
