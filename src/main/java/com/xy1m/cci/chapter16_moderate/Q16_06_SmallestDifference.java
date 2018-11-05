package com.xy1m.cci.chapter16_moderate;

import java.util.Arrays;

/**
 * Smallest Difference: Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.
 * EXAMPLE
 * Input: {l, 3, 15, 11, 2}, {23, 127, 235, 19, 8} Output: 3. That is, the pair (11, 8).
 */
public class Q16_06_SmallestDifference {

    public static int findSmallestDifferenceBruteForce(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int diff = Math.abs(arr1[i] - arr2[j]);
                min = Math.min(min, diff);
            }
        }
        return min;
    }

    public static int findSmallestDifferenceTwoPointers(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return -1;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int min = Integer.MAX_VALUE;

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            int diff = Math.abs(arr1[i] - arr2[j]);
            min = Math.min(min, diff);

            if (arr1[i] < arr2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 15, 11, 2};
        int[] arr2 = new int[]{23, 127, 235, 19, 8};
        System.out.println(findSmallestDifferenceBruteForce(arr1, arr2));
        System.out.println(findSmallestDifferenceTwoPointers(arr1, arr2));
    }
}
