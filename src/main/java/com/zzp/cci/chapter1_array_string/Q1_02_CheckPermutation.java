package com.zzp.cci.chapter1_array_string;

import java.util.Arrays;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class Q1_02_CheckPermutation {
    public final static int ASCII_SIZE = 128;

    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    /**
     * Sort two string then compare, including space and distinguish case
     *
     * Time: O(n*log(n))
     * Space: Depend on the sorting algorithm
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    /**
     * Calculate occurrence of every characters, assume characters are ASCII
     *
     * Time: O(n)
     * Space: O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isPermutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[ASCII_SIZE];
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
        Q1_02_CheckPermutation app = new Q1_02_CheckPermutation();
        System.out.println(app.isPermutation(s, t));
        System.out.println(app.isPermutation2(s, t));
    }
}
