package com.zzp.cci.chapter02_linkedlist;


import com.zzp.cci.lib.ListNode;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class Q2_02_ReturnKthToLast {
    static class IntWrapper {
        int value = 0;
    }

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
        if (head == null || k < 1) {
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
    public static ListNode nthToLastRunner(ListNode head, int k) {
        // k>=1 and k<=size;
        if (k < 1) return null;
        ListNode p2 = head;
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            // k>size
            if (p2 == null) return null;
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(1, 2, 3, 4, 5);
        nthToLast(nodes, 2);
        System.out.println(nthToLastWrapper(nodes, 2, new IntWrapper()));
        System.out.println(nthToLastRunner(nodes, 2));
    }
}

