package com.xy1m.cci.chapter05_bit_manipulation;

public class Q5_06_Conversion {
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        // c&(c-1) will clear least significant bit
        for (int c = a ^ b; c != 0; c = (c & (c - 1))) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitSwapRequired(4, 11));
    }
}
