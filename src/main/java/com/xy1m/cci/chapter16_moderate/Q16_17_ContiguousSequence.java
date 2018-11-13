package com.xy1m.cci.chapter16_moderate;

public class Q16_17_ContiguousSequence {
    // sub-sequence could be empty
    int getMaxSum(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
            }
            else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    int getMaxSumWithoutEmpty(int[] arr) {
        int maxSum = arr[0];
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
            }
            else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Q16_17_ContiguousSequence main = new Q16_17_ContiguousSequence();
        System.out.println(main.getMaxSum(new int[]{2, 3, -8, -1, 2, 4, -2, 3}));
        System.out.println(main.getMaxSumWithoutEmpty(new int[]{-3, -10, -5}));
    }
}
