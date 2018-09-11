package com.xy1m.cci.chapter02_linkedlist;


import com.xy1m.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class Q2_00_ReverseLinkedList {

    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reNode = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return reNode;
    }

    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String... args) {
        ListNode nodes1 = ListNode.from(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ListNode nodes2 = ListNode.from(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        reverse1(nodes1).print();
        reverse2(nodes2).print();
    }
}
