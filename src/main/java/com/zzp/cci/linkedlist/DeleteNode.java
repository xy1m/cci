package com.zzp.cci.linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class DeleteNode {
    public static boolean deleteNode(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return true;
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 8, 8, 3, 4, 2, 3});
        ListNode head = new ListNode(0);
        head.next = nodes;

        deleteNode(nodes);
        System.out.println(head);
    }

}
