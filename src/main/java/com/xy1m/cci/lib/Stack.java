package com.xy1m.cci.lib;

/**
 * Created by zhenpeng on 10/25/16.
 */
public class Stack {
    int[] stack;
    int top;

    public Stack(int n) {
        stack = new int[n];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(int x) {
        stack[++top - 1] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("underflow");
        }
        return stack[top-- - 1];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("underflow");
        }
        return stack[top - 1];
    }


    public static void main(String args[]) {
        Stack s = new Stack(10);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());

    }
}
