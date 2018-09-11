package com.xy1m.cci.chapter01_array_string;

/**
 * Created by zhenpeng on 8/21/17.
 */
public class Q1_09_StringRotation {
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    public static void main(String... args) {
        String s1 = "waterbotte";
        String s2 = "erbottewat";
        System.out.println(isRotation(s1, s2));
    }
}
