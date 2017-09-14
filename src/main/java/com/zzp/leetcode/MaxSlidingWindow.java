package com.zzp.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k) deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, 3);
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

        Deque<Integer> deque=new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);
        deque.offer(5);
        System.out.println(deque.peek());
        System.out.println(deque.peekLast());
        System.out.println(null instanceof Object);
    }
}
