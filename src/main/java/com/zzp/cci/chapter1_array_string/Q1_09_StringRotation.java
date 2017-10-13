package com.zzp.cci.chapter1_array_string;

/**
 * Created by zhenpeng on 8/21/17.
 */
public class Q1_09_StringRotation {
    public boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    public static void main(String... args) {
        String s1 = "waterbotte";
        String s2 = "erbottewat";
        Q1_09_StringRotation app = new Q1_09_StringRotation();
        System.out.println(app.isRotation(s1, s2));
    }
}
