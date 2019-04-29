package com.xy1m.cci.chapter10_sorting_searching;

import java.util.Arrays;

/**
 * Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 */
public class Q10_01_Sorted_Merge {

    static void merge(int[] a, int[] b, int sizeA, int sizeB) {
        int indexA = sizeA - 1;
        int indexB = sizeB - 1;
        int indexMerged = sizeA + sizeB - 1;
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA--];
            }
            else {
                a[indexMerged] = b[indexB--];
            }
            indexMerged--;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        Arrays.fill(a, -1);
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;

        int[] b = new int[]{2, 4, 6, 8};

        merge(a, b, 5, 4);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
