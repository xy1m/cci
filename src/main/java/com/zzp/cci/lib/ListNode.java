package com.zzp.cci.lib;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public static ListNode from(int[] source) {
        if (source == null || source.length == 0) {
            return null;
        }
        ListNode head = new ListNode(source[0]);
        ListNode node = head;
        for (int i = 1; i < source.length; i++) {
            ListNode cur = new ListNode(source[i]);
            node.next = cur;
            node = cur;
        }
        return head;
    }

    public int length() {
        ListNode cur = this;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        while (head.next != null) {
            sb.append(head.data).append("->");
            head = head.next;
        }
        sb.append(head.data);
        return sb.toString();
    }
}
