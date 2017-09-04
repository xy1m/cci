package com.zzp.cci.array;

import java.util.Arrays;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class C1_3 {
    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    /**
     * Sort two string then compare
     * include space and distinguish case
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    /**
     * Calculate occurrence of every characters
     * Assume characters are ASCII
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[256];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = " dog";
        String t = "god ";
        C1_3 solution = new C1_3();
        System.out.println(solution.permutation1(s, t));
        System.out.println(solution.permutation2(s, t));
    }
}
