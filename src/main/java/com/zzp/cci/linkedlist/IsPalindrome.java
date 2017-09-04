package com.zzp.cci.linkedlist;

import com.zzp.cci.datastructure.ListNode;

import java.util.Stack;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class IsPalindrome {
    public static boolean isPalindromeStack(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int top = stack.pop();
            if (slow.data != top) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static Result isPalindromeRecurse(ListNode head, int length) {
        if (head == null || length == 0) {
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        } else if (length == 2) {
            return new Result(head.next.next, head.data == head.next.data);
        }
        Result res = isPalindromeRecurse(head.next, length - 2);
        if (!res.result || res.node == null) {
            return res;
        }
        res.result = head.data == res.node.data;
        res.node = res.node.next;
        return res;
    }

    public static boolean isPalindromeRecursion(ListNode head) {
        Result result = isPalindromeRecurse(head, head.length());
        return result.result;
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(new int[]{0, 1, 2, 1, 0});
        ListNode nodes1 = ListNode.from(new int[]{0, 1, 2, 3, 0});
        System.out.println(isPalindromeStack(nodes));
        System.out.println(isPalindromeRecursion(nodes));
    }
}

class Result {
    public ListNode node;
    public boolean result;

    public Result(ListNode node, boolean result) {
        this.node = node;
        this.result = result;
    }
}
