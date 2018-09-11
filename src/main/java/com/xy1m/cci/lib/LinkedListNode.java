package com.xy1m.cci.lib;

public class LinkedListNode {
    public LinkedListNode prev, next, last;
    public int data;

    public LinkedListNode() {
    }

    public LinkedListNode(int d, LinkedListNode p, LinkedListNode n) {
        this.data = d;
        prev = p;
        next = n;
    }

    public void setPrev(LinkedListNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public void setNext(LinkedListNode n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrev(this);
        }
    }

    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        if (next != null) {
            next2 = next.clone();
        }
        LinkedListNode head2 = new LinkedListNode(data, next2, null);
        return head2;
    }

}
