package com.xy1m.cci.lib;

/**
 * Created by zhenpeng on 10/25/16.
 */
public class Queue {
    int[] queue;
    int head;
    int tail;

    public Queue(int n) {
        queue = new int[n];
        head = tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return head == (tail + 1) % queue.length;
    }

    public void enqueue(int x) {
        if (isFull()) {
            throw new RuntimeException("upflow");
        }
        queue[tail] = x;
        tail = (tail + 1) % queue.length;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("underflow");
        }
        int x = queue[head];
        head = (head + 1) % queue.length;
        return x;
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.isFull());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}
