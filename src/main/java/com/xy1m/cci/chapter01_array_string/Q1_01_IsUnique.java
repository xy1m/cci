package com.xy1m.cci.chapter01_array_string;

import java.util.Arrays;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class Q1_01_IsUnique {
    public final static int ASCII_SIZE = 128;
    public final static int LOWERCASE_SIZE = 26;

    /**
     * Time O(n)
     * Space O(1)
     *
     * @param str all characters are ASCII
     * @return
     */
    public static boolean isUniqueChars(String str) {
        if (str.length() > ASCII_SIZE) {
            return false;
        }
        boolean[] char_set = new boolean[ASCII_SIZE];
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
     * @param str all characters between a-z
     * @return
     */
    public static boolean isUniqueCharsBit(String str) {
        if (str.length() > LOWERCASE_SIZE) {
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
    public static boolean isUniqueCharsBruteForce(String str) {
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
     * Time O(n*log(n))
     * Space depend on the sort algorithm
     *
     * @param str
     * @return
     */
    public static boolean isUniqueCharsSort(String str) {
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
        String input = "Hello World";
        System.out.println(isUniqueChars(input));
        System.out.println(isUniqueCharsBit(input));
        System.out.println(isUniqueCharsBruteForce(input));
        System.out.println(isUniqueCharsSort(input));
    }
}
