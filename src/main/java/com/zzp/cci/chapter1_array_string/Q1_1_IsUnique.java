package com.zzp.cci.chapter1_array_string;

import java.util.Arrays;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class Q1_1_IsUnique {
    /**
     * Time O(n)
     * Space O(1)
     *
     * @param str If all characters are ASCII
     * @return
     */
    public boolean isUniqueChars2(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val] == true) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /**
     * Time O(n)
     * Space O(1)
     *
     * @param str If all characters between a-z
     * @return
     */
    public boolean isUniqueChars(String str) {
        if (str.length() > 26) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    /**
     * Time O(n^2)
     * Space O(1)
     *
     * @param str
     * @return
     */
    public boolean isUniqueCharsBruteForce(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Time O(nlog(n))
     * Space depend on the sort alogrithm
     *
     * @param str
     * @return
     */
    public boolean isUniqueCharsSort(String str) {
        char[] arr = str.toCharArray();
        // quick sort nlog(n)
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abcdefg";
        Q1_1_IsUnique app = new Q1_1_IsUnique();
        System.out.println(app.isUniqueChars(input));
        System.out.println(app.isUniqueChars2(input));
        System.out.println(app.isUniqueCharsBruteForce(input));
        System.out.println(app.isUniqueCharsSort(input));
    }
}
