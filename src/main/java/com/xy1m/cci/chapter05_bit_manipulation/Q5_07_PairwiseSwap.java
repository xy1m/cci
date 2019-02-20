package com.xy1m.cci.chapter05_bit_manipulation;

public class Q5_07_PairwiseSwap {
    // mast even bits to 0 then right shift 1,
    // mast odd bits to 1 then left shift 1, then OR
    public static int swapOddEvenBits(int x) {
        return ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        System.out.println(swapOddEvenBits(8));
    }
}
