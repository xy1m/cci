package com.xy1m.cci.chapter02_linkedlist;


import com.xy1m.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/22/17.
 */

public class Q2_05_SumLists {

    public static ListNode addLists(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        ListNode head = new ListNode(value % 10);
        head.next = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value / 10);
        return head;
    }

    public static ListNode addListsReverse(ListNode l1, ListNode l2) {
        int len1 = l1.length();
        int len2 = l2.length();

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        }
        else {
            l2 = padList(l2, len1 - len2);
        }
        PartialSum sum = addListHelper(l1, l2);
        if (sum.carry == 0) {
            return sum.sum;
        }
        else {
            ListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    public static ListNode padList(ListNode head, int padding) {
        for (int i = 0; i < padding; i++) {
            ListNode node = new ListNode(0);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static ListNode insertBefore(ListNode head, int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        return node;
    }

    public static PartialSum addListHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }
        PartialSum sum = addListHelper(l1.next, l2.next);
        int val = sum.carry + l1.data + l2.data;
        ListNode full_result = insertBefore(sum.sum, val % 10);
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    static class PartialSum {
        public ListNode sum = null;
        public int carry = 0;
    }

    public static void main(String... args) {
        ListNode l1 = ListNode.from(new int[]{7, 1, 6});
        ListNode l2 = ListNode.from(new int[]{5, 9, 2});

        ListNode sum = addLists(l1, l2, 0);
        sum.print();

        ListNode sum1 = addListsReverse(l1, l2);
        sum1.print();
    }
}


