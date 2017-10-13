package com.zzp.cci.chapter2_linkedlist;

import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class HalfNode {
    public static ListNode half(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String... args) {
        ListNode nodes1 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNode nodes2 = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(half(nodes1).data);
        System.out.println(half(nodes2).data);
    }
}
