package com.xy1m.cci.chapter05_bit_manipulation;

public class Q5_05_Debugger {
    /**
     * Explain:
     * when subtract 1 from a number, if least significant number is 1, then subtract it, done. else, borrow number from
     * larger bit, each bit from 0 to 1 until find a 1. flip 1 to 0 then done.
     *
     * if n=abcde1000
     * then n-1=abcde0111
     *
     * if (n&(n-1))==0, abcde must be 0s. then n is power of two
     * */
    public static void main(String[] args) {
        int n = 16;
        System.out.println(n & (n - 1));
    }
}
