package com.xy1m.cci.lib;

import java.util.StringJoiner;

/**
 * Created by zhenpeng on 8/22/17.
 */
public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public static ListNode from(int... source) {
        if (source.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode n = null;
        for (int d : source) {
            if (n == null) {
                head = new ListNode(d);
                n = head;
            } else {
                ListNode node = new ListNode(d);
                n.next = node;
                n = node;
            }
        }
        return head;
    }

    public void append(ListNode node) {
        ListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public int length() {
        ListNode n = this;
        int len = 0;
        while (n != null) {
            n = n.next;
            len++;
        }
        return len;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("->");
        ListNode n = this;
        while (n != null) {
            joiner.add(String.valueOf(n.data));
            n = n.next;
        }
        return joiner.toString();
    }

    public void print() {
        System.out.println(this);
    }
}
