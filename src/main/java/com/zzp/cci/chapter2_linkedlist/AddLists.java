package com.zzp.cci.chapter2_linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class AddLists {
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
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }
        PartialSum sum = addListHelper(l1, l2);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            ListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    public static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static ListNode padList(ListNode head, int padding) {
        ListNode res = head;
        for (int i = 0; i < padding; i++) {
            ListNode node = new ListNode(0);
            node.next = res;
            res = node;
        }
        return res;
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

    public static void main(String... args) {
        ListNode l1 = ListNode.from(new int[]{7, 1, 6});
        ListNode l2 = ListNode.from(new int[]{5, 9, 2});

        ListNode sum = addLists(l1, l2, 0);
        System.out.println(sum);

        ListNode sum1 = addListsReverse(l1, l2);
        System.out.println(sum1);
    }
}

class PartialSum {
    public ListNode sum = null;
    public int carry = 0;
}
