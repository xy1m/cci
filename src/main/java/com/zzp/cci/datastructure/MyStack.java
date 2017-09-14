package com.zzp.cci.datastructure;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T item) {
            this.data = item;
        }
    }

    private StackNode<T> top;
    private int size;

    public int getSize() {
        return size;
    }

    public T pop() {
        if (top == null) throw new RuntimeException("Trying to pop from empty stack!");
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(T item) {
        StackNode node = new StackNode(item);
        node.next = top;
        top = node;
        size++;
    }

    public T peek() {
        if (top == null) throw new RuntimeException("Trying to peek from empty stack!");
        return top.data;
    }

    public boolean isEmtpy() {
        return top == null;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
    }
}
