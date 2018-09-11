package com.xy1m.cci.chapter05_bit_manipulation;

public class Q5_01_Insertion {

    public static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        
        int cleaned = n & mask;
        int shifted = m << i;
        return cleaned | shifted;
    }

    public static void main(String[] args) {
        System.out.println(updateBits(0, 19, 2, 6));
    }
}
