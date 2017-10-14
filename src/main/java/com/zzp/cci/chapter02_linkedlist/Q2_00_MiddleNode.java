package com.zzp.cci.chapter02_linkedlist;

import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class Q2_00_MiddleNode {
    public static ListNode middle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String... args) {
        ListNode nodes1 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNode nodes2 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        middle(nodes1).print();
        middle(nodes2).print();
    }
}
