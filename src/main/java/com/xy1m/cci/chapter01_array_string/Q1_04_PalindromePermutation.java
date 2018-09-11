package com.xy1m.cci.chapter01_array_string;

public class Q1_04_PalindromePermutation {
    public final static int LOWERCASE_SIZE = 26;

    /**
     * Case insensitive
     *
     * @param str
     * @return
     */
    public static boolean isPalindromePermutation(String str) {
        int[] freq = new int[LOWERCASE_SIZE];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                freq[Character.toLowerCase(c) - 'a']++;
            }
        }
        boolean oddFound = false;
        for (int i = 0; i < LOWERCASE_SIZE; i++) {
            if (freq[i] % 2 == 1) {
                if (oddFound) {
                    return false;
                }
                oddFound = true;
            }
        }
        return true;
    }

    public static boolean isPalindromePermutationOneLoop(String str) {
        int[] freq = new int[LOWERCASE_SIZE];
        int oddCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                int index = Character.toLowerCase(c) - 'a';
                freq[index]++;
                if (freq[index] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }
        return oddCount < 2;
    }

    public static boolean isPalindromePermutationBit(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                int index = Character.toLowerCase(c) - 'a';
                checker ^= 1 << index;
            }
        }
        return checker == 0 || (checker & (checker - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
        System.out.println(isPalindromePermutationOneLoop("Tact Coa"));
        System.out.println(isPalindromePermutationBit("Tact Coa"));
        System.out.println(isPalindromePermutationBit("Tact Coa"));
    }
}
