package com.zzp.cci.chapter03_stack_queues;

import java.util.Stack;

public class Q3_05_SortStack {
    Stack<Integer> origin = new Stack<>();
    Stack<Integer> buffer = new Stack<>();

    public Q3_05_SortStack() {

    }

    public void sort() {
        while (!origin.isEmpty()) {
            int tmp = origin.pop();
            while (!buffer.isEmpty() && buffer.peek() > tmp) {
                origin.push(buffer.pop());
            }
            buffer.push(tmp);
        }
        while (!buffer.isEmpty()) {
            origin.push(buffer.pop());
        }
    }

    public boolean isEmpty() {
        return origin.isEmpty();
    }

    public Integer push(Integer v) {
        Integer item = origin.push(v);
        sort();
        return item;
    }

    public Integer peek() {
        return origin.peek();
    }

    public Integer pop() {
        return origin.pop();
    }


    //TODO unlimited stacks
    public void mergeSort() {
    }

    public void quickSort() {
    }

    public static void main(String[] args) {
        Q3_05_SortStack sortStack = new Q3_05_SortStack();
        sortStack.push(5);
        sortStack.push(3);
        sortStack.push(1);
        sortStack.push(2);
        sortStack.push(4);

        System.out.println(sortStack.pop());
        System.out.println(sortStack.pop());
        System.out.println(sortStack.pop());
        System.out.println(sortStack.pop());
        System.out.println(sortStack.pop());
    }
}
