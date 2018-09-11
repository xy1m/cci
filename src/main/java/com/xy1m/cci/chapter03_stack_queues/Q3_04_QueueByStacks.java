package com.xy1m.cci.chapter03_stack_queues;

import java.util.Stack;

public class Q3_04_QueueByStacks {
    private Stack newest = new Stack<>(), oldest = new Stack<>();

    public int size() {
        return newest.size() + oldest.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(Object item) {
        newest.add(item);
    }

    private void shiftStacks() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

    public Object peek() {
        if (isEmpty()) throw new RuntimeException("Trying to peek from emtpy queue");
        shiftStacks();
        return oldest.peek();
    }

    public Object poll() {
        if (isEmpty()) throw new RuntimeException("Trying to poll from emtpy queue");
        shiftStacks();
        return oldest.pop();
    }

    public static void main(String[] args) {
        Q3_04_QueueByStacks queueByStacks = new Q3_04_QueueByStacks();
        queueByStacks.add(1);
        queueByStacks.add(2);
        queueByStacks.add(3);

        System.out.println(queueByStacks.poll());
        queueByStacks.add(4);
        System.out.println(queueByStacks.poll());
        System.out.println(queueByStacks.poll());
        System.out.println(queueByStacks.poll());
        System.out.println(queueByStacks.poll());
    }

}
