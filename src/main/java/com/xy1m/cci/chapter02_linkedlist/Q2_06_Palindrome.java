package com.xy1m.cci.chapter02_linkedlist;

import com.xy1m.cci.lib.ListNode;

import java.util.Stack;

/**
 * Created by zhenpeng on 8/23/17.
 */


public class Q2_06_Palindrome {
    // Reverse and compare
    public static boolean isPalindromeReverse(ListNode node) {
        ListNode reversed = reverseAndClone(node);
        return isEqual(node, reversed);
    }

    public static ListNode reverseAndClone(ListNode n) {
        ListNode head = null;
        while (n != null) {
            ListNode node = new ListNode(n.data);
            node.next = head;
            head = node;
            n = n.next;
        }
        return head;
    }

    public static boolean isEqual(ListNode n1, ListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == null && n2 == null;
    }

    // Using stack
    public static boolean isPalindromeStack(ListNode head) {
        ListNode p2 = head;
        ListNode p1 = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (p2 != null && p2.next != null) {
            stack.push(p1.data);
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2 != null) {
            p1 = p1.next;
        }
        while (p1 != null) {
            if (p1.data != stack.pop()) {
                return false;
            }
            p1 = p1.next;
        }
        return true;
    }

    public static Result isPalindromeRecurse(ListNode head, int length) {
        if (head == null || length == 0) {
            return new Result(null, true);
        }
        else if (length == 1) {
            return new Result(head.next, true);
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

    // reverse last half and compare
    public static boolean isPalindromeCutHalf(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        if (p2 != null) {
            p1 = p1.next;
        }
        ListNode reversed = Q2_00_ReverseLinkedList.reverse2(p1);
        p1 = reversed;
        p2 = head;
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        Q2_00_ReverseLinkedList.reverse2(reversed);
        return true;
    }

    static class Result {
        public ListNode node;
        public boolean result;

        public Result(ListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(new int[]{0, 1, 2, 1, 0});
        ListNode nodes1 = ListNode.from(new int[]{0, 1, 1, 0});
        System.out.println(isPalindromeStack(nodes));
        System.out.println(isPalindromeRecursion(nodes));
        System.out.println(isPalindromeCutHalf(nodes));
        nodes.print();
    }
}


