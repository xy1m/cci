package com.xy1m.cci.chapter16_moderate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gzhenpeng on 2019-10-23
 */
public class LRUCache3<K, V> {

    class Node {
        private K key;
        private V value;
        private Node pre;
        private Node next;
    }

    private Map<K, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    private final int capacity;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        Node node = map.get(key);
        if (node != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = head;
            head.pre = node;
            head = node;

            return node.value;
        }
        return null;
    }

    public void set(K key, V value) {
    }

    private void detach(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }
        node.pre = null;
        node.next = null;
    }

    private void removeLRUNode() {
        if (tail != null) {
            map.remove(tail.key);

            Node tailPre = tail.pre;
            if (tailPre != null) {
                tailPre.next = null;
                tail.pre = null;
                tail = tailPre;
            }

        }

    }

    private void insertIntoFront(Node node) {
        if (head == null) {
            head = node;
        }
        else {
            node.next = head;
            head.pre = node;
            head = node;
        }

    }

}
