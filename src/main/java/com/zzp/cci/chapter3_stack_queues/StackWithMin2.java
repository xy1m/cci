package com.zzp.cci.chapter3_stack_queues;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2 = new Stack<>();

    public void push(int v) {
        if (v <= min()) {
            s2.push(v);
        }
        super.push(v);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public Integer min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return s2.peek();
    }
}
