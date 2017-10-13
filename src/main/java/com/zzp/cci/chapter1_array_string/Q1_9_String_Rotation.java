package com.zzp.cci.chapter1_array_string;

/**
 * Created by zhenpeng on 8/21/17.
 */
public class Q1_9_String_Rotation {
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len > 0 && len == s2.length()) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    public static void main(String... args) {
        String s1 = "waterbotte";
        String s2 = "erbottewat";
        Q1_9_String_Rotation solution = new Q1_9_String_Rotation();
        System.out.println(solution.isRotation(s1, s2));
    }
}
