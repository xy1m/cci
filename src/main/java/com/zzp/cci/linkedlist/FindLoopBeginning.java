package com.zzp.cci.linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class FindLoopBeginning {

    public static ListNode findBeginning(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // LOOP_SIZE-k
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
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
