package com.zzp.cci.lib;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T item) {
            this.data = item;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;
    private int size;

    public void add(T item) {
        QueueNode node = new QueueNode(item);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
        size++;
    }

    public T remove() {
        if (first == null) throw new RuntimeException("Tring to remove empty quque!");
        T item = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return item;
    }

    public T peek() {
        if (first == null) throw new RuntimeException("Tring to peek from empty quque!");
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
