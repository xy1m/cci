package com.zzp.cci.chapter2_linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class Reverse {

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
        ListNode nodes1 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode nodes2 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(reverse1(nodes1));
        System.out.println(reverse2(nodes2));
    }
}
