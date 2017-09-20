package com.zzp.leetcode;

public class ReverseString {

    public static String reverse(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < (len >> 1); i++) {
            swap(arr, i, len - 1 - i);
        }
        return new String(arr);
    }

    public static void swap(char[] arr, int i, int j) {
        if (i == j) return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcdefghijklmn"));
        System.out.println(reverse(""));
        System.out.println(reverse("ab"));
        System.out.println(reverse("abc"));
    }
}
