package com.zzp.cci.chapter1_array_string;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class Q1_06_StringCompression {
    /**
     * Brute force solution
     *
     * @param str
     * @return
     */
    public String compressBad(String str) {
        StringBuilder compressed = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                compressed.append(last).append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        return compressed.append(last).append(count).toString();
    }
    /**
     * Calculate str length after compression
     *
     * @param str
     * @return
     */
    public int countCompression(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int size = 0;
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                size += 1 + String.valueOf(count).length();
                last = str.charAt(i);
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    /**
     * Judge if compressed str longer than before
     *
     * @param str
     * @return
     */
    public String compressBetter(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }
        StringBuffer compressed = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                compressed.append(last).append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        return compressed.append(last).append(count).toString();
    }

    public String compressAlternate(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }
        char[] arr = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                index = setChar(arr, index, last, count);
                last = str.charAt(i);
                count = 1;
            }
        }
        setChar(arr, index, last, count);
        return new String(arr);
    }

    public int setChar(char[] arr, int index, char last, int count) {
        arr[index++] = last;
        char[] cnt = String.valueOf(count).toCharArray();
        for (char x : cnt) {
            arr[index++] = x;
        }
        return index;
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        Q1_06_StringCompression app = new Q1_06_StringCompression();
        System.out.println(app.compressBad(input));
        System.out.println(app.compressBetter(input));
        System.out.println(app.compressAlternate(input));
    }
}
