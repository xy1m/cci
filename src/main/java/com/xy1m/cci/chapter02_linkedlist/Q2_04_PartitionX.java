package com.zzp.cci.chapter02_linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class Q2_04_PartitionX {
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.data < x) {
                if (beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            } else {
                if (afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static ListNode partitionBefore(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = null;
        ListNode after = null;
        while (head != null) {
            ListNode next = head.next;
            if (head.data < x) {
                head.next = before;
                before = head;
            } else {
                head.next = after;
                after = head;
            }
            head = next;
        }
        if (before == null) {
            return after;
        }
        ListNode res = before;
        while (before.next != null) {
            before = before.next;
        }
        before.next = after;
        return res;
    }


    public static void main(String... args) {
        ListNode nodes = ListNode.from(new int[]{1, 222, 3, 4, 5, 6, 8, 8, 3, 4, 2, 3});
        System.out.println(partition(nodes, 7));
        System.out.println(partitionBefore(nodes, 7));
    }
}
