package com.zzp.cci.chapter3_stack_queues;

import java.util.Stack;

public class SortStack {

    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    public void mergeSort() {
    }

    public void quickSort() {
    }

    public static void main(String[] args) {

    }
}
