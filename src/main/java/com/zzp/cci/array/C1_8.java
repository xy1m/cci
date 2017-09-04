package com.zzp.cci.array;

/**
 * Created by zhenpeng on 8/21/17.
 */
public class C1_8 {
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
        C1_8 solution = new C1_8();
        System.out.println(solution.isRotation(s1, s2));
    }
}
