package com.xy1m.cci.chapter02_linkedlist;

import com.xy1m.cci.lib.ListNode;

public class Q2_07_Insertion {

    public static ListNode insertion(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int len1 = 0, len2 = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1.next != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            len2++;
        }
        // compare last node
        if (p1 != p2) return null;
        // from start and chop longer list
        p1 = l1;
        p2 = l2;
        if (len1 > len2) {
            p1 = step(p1, len1 - len2);
        } else {
            p2 = step(p2, len2 - len1);
        }
        // same length
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static ListNode step(ListNode node, int len) {
        for (int i = 0; i < len; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.from(7, 8, 9);
        ListNode node1 = ListNode.from(0, 1, 3);
        ListNode node2 = ListNode.from(4, 5, 6);
        node1.append(node);
        node2.append(node);
        insertion(node1, node2).print();
    }

}
