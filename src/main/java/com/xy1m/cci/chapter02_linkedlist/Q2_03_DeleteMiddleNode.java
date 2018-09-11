package com.zzp.cci.chapter02_linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class Q2_03_DeleteMiddleNode {
    public static boolean deleteNode(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return true;
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(1, 2, 3, 4);
        ListNode head = new ListNode(0);
        head.next = nodes;
        deleteNode(nodes);
        head.print();
    }

}
