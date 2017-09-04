package com.zzp.cci.linkedlist;


import com.zzp.cci.datastructure.ListNode;

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
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public static void main(String... args) {
        ListNode nodes1 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode nodes2 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(reverse1(nodes1));
        System.out.println(reverse2(nodes2));
    }
}
