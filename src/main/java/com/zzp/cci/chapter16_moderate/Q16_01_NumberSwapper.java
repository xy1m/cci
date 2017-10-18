package com.zzp.cci.chapter16_moderate;

public class Q16_01_NumberSwapper {

    public static void main(String[] args) {
        int a = 9, b = 5;
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println(a);
        System.out.println(b);

        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);
    }
}
