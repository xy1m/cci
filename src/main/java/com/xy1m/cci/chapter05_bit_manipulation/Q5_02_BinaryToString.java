package com.xy1m.cci.chapter05_bit_manipulation;

public class Q5_02_BinaryToString {
    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (num > 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            double r = 2 * num;
            if (r >= 1) {
                sb.append(1);
                num = r - 1;
            } else {
                sb.append(0);
                num = r;
            }
        }
        return sb.toString();
    }

    public static String printBinary2(double num) {
        if (num >= 1 || num <= 0) return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        double frac = 0.5;
        while (num > 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            if (num >= frac) {
                sb.append(1);
                num = num - frac;
            } else {
                sb.append(0);
            }
            frac /= 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printBinary(0.5));
    }
}
