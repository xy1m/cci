package com.zzp.cci.array;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class C1_5 {
    /**
     * Brute force solution
     *
     * @param str
     * @return
     */
    public String compressBad(String str) {
        String mystr = "";
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                mystr += last + "" + count;
                last = str.charAt(i);
                count = 1;
            }
        }
        return mystr + last + count;
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
        StringBuffer sb = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                sb.append(last);
                sb.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        return sb.append(last).append(count).toString();
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
        index = setChar(arr, index, last, count);
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

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        C1_5 solution = new C1_5();
        System.out.println(solution.compressBad(input));
        System.out.println(solution.compressBetter(input));
        System.out.println(solution.compressAlternate(input));
    }
}
