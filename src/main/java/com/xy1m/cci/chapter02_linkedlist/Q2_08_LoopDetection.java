package com.zzp.cci.chapter02_linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class Q2_08_LoopDetection {

    public static ListNode findBeginning(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        // LOOP_SIZE-k
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }
        if (p2 == null || p2.next == null) {
            return null;
        }
        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(new int[]{1, 2, 3, 4, 5});
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n1;
        ListNode head = nodes;
        while (nodes.next != null) {
            nodes = nodes.next;
        }
        nodes.next = n1;
        System.out.println(findBeginning(head).data);
    }
}
