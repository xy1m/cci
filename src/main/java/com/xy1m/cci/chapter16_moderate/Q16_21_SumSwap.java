package com.xy1m.cci.chapter16_moderate;

public class Q16_21_SumSwap {
    public static int[] findPair(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        for (int one : array1) {
            for (int two : array1) {
                int newSum1 = sum1 - one + two;
                int newSum2 = sum2 + one - two;
                if (newSum1 == newSum2) {
                    return new int[]{one, two};
                }
            }
        }
        throw new IllegalArgumentException("No result");
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1, 2, 1, 1, 2}; //11
        int[] arr2 = new int[]{3, 6, 3, 3}; //15
        for (int i : findPair(arr1, arr2)) {
            System.out.println(i);
        }
    }
}
