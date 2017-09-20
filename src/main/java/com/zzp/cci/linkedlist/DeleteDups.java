package com.zzp.cci.linkedlist;


import com.zzp.cci.lib.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class DeleteDups {
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
        if (head == null) {
            return;
        }
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
        ListNode nodes = ListNode.from(new int[]{1, 2, 3, 4, 5, 6, 8, 8, 3, 4, 2, 3});
        deleteDups2(nodes);
        System.out.println(nodes);
    }
}
