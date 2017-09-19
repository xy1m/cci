package com.zzp.cci.stackqueue;

import java.util.Stack;

public class QueueByStacks<T> {
    private Stack<T> newest = new Stack<>(), oldest = new Stack<>();

    public int size() {
        return newest.size() + oldest.size();
    }

    public void add(T item) {
        newest.add(item);
    }

    private void shiftStacks() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return oldest.peek();
    }

    public T remove() {
        shiftStacks();
        return oldest.pop();
    }
}
