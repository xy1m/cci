package com.zzp.cci.chapter02_linkedlist;


import com.zzp.cci.lib.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class Q2_01_DeleteDups {
    // hash solution
    public static void deleteDups(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode pre = null;
        while (head != null) {
            if (set.contains(head.data)) {
                pre.next = head.next;
            } else {
                set.add(head.data);
                pre = head;
            }
            head = head.next;
        }
    }

    // recursion
    public static void deleteDups2(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode runner = cur;
            while (runner.next != null) {
                if (runner.next.data == cur.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }

    public static void main(String... args) {
        ListNode nodes = ListNode.from(1, 2, 3, 3, 3, 3, 8, 8, 3, 4, 2, 3);
        deleteDups2(nodes);
        nodes.print();
    }
}
