package com.zzp.leetcode;

/**
 * Created by zhenpeng on 10/20/16.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    public int maxSubArray(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = high >> 1;
        int left = maxSubArray(nums, 0, mid);
        int right = maxSubArray(nums, mid + 1, high);
        int crossing = maxCrossingSubArray(nums, 0, mid, high);
        return Math.max(Math.max(left, right), crossing);
    }


    public int maxCrossingSubArray(int[] nums, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }
        return leftMax + rightMax;
    }
}
