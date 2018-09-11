package com.xy1m.cci.chapter08_recursion_dynamic_programming;

public class Q8_03_MagicIndex {

    public static int magicSlow(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) return i;
        }
        return -1;
    }

    public static int magicFast(int[] nums, int start, int end) {
        if (end < start) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == mid) {
            return mid;
        } else if (nums[mid] > mid) {
            return magicFast(nums, start, mid - 1);
        } else {
            return magicFast(nums, mid + 1, end);
        }
    }

    public static int magicDuplicate(int[] nums, int start, int end) {
        if (end < start) return -1;
        int midIndex = (start + end) / 2;
        int midValue = nums[midIndex];
        if (midIndex == midValue) return midIndex;
        // chapter10_sorting_searching left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicDuplicate(nums, start, leftIndex);
        if (left >= 0) return left;
        // chapter10_sorting_searching right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicDuplicate(nums, rightIndex, end);
        return right;
    }

    public static void main(String[] args) {
        int[] distinct = new int[]{0, 1, 2, 3, 10, 12, 13, 15};
        int[] duplicate = new int[]{1, 2, 2, 4, 4, 6, 7, 8};

        System.out.println(magicSlow(distinct));
        System.out.println(magicFast(distinct, 0, distinct.length - 1));
        System.out.println(magicDuplicate(duplicate, 0, duplicate.length - 1));
    }

}
