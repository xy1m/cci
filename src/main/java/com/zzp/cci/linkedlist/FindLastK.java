package com.zzp.cci.linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class FindLastK {
    // recursion
    public static int nthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int i = nthToLast(head.next, k) + 1;
        if (i == k) {
            System.out.println(head.data);
        }
        return i;
    }

    // IntWrapper
    public static ListNode nthToLastWrapper(ListNode head, int k, IntWrapper i) {
        if (head == null) {
            return null;
        }
        ListNode node = nthToLastWrapper(head.next, k, i);
        i.value++;
        if (i.value == k) {
            return head;
        }
        return node;
    }

    // runner
    public static int nthToLastRunner(ListNode head, int k) {
        ListNode p2 = head;
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1.data;
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 8, 8, 3, 4, 2, 3});
        nthToLast(nodes, 3);
        System.out.println(nthToLastWrapper(nodes, 3, new IntWrapper()).data);
        System.out.println(nthToLastRunner(nodes, 3));
    }
}

class IntWrapper {
    int value = 0;
}
