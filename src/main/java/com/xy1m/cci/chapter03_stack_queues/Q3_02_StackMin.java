package com.xy1m.cci.chapter03_stack_queues;

import java.util.Stack;


public class Q3_02_StackMin {
    static class StackWithMin extends Stack<NodeWithMin> {
        public void push(int value) {
            int newMin = Math.min(value, min());
            push(new NodeWithMin(value, newMin));
        }

        public int min() {
            if (isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return peek().min;
        }
    }

    static class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int v, int min) {
            this.value = v;
            this.min = min;
        }
    }

    static class StackWithMin2 extends Stack<Integer> {
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

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(3);
        stackWithMin.push(4);
        stackWithMin.push(2);
        stackWithMin.push(5);
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());

        StackWithMin2 stackWithMin2 = new StackWithMin2();
        stackWithMin2.push(3);
        stackWithMin2.push(1);
        stackWithMin2.push(2);
        System.out.println(stackWithMin2.min());
        stackWithMin2.pop();
        System.out.println(stackWithMin2.min());
        stackWithMin2.pop();
        System.out.println(stackWithMin2.min());
        stackWithMin2.pop();
        System.out.println(stackWithMin2.min());
    }
}

