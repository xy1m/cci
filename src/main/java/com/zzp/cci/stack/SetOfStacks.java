package com.zzp.cci.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SetOfStacks<T> {
    List<LinkedList<T>> stacks = new ArrayList<>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(T v) {
        LinkedList<T> lastStack = getLastStack();
        if (lastStack != null && lastStack.size() != capacity) {
            lastStack.push(v);
        } else {
            LinkedList<T> newStack = new LinkedList<>();
            newStack.push(v);
            stacks.add(newStack);
        }
    }

    public T pop() {
        LinkedList<T> last = getLastStack();
        if (last == null) throw new RuntimeException("Trying to pop from empty stack");
        T v = last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public T peek() {
        LinkedList<T> last = getLastStack();
        if (last == null) throw new RuntimeException("Trying to pop from empty stack");
        return last.peek();
    }

    public T popAt(int index) {
        return leftShift(index, true);
    }

    private T leftShift(int index, boolean removeTop) {
        if (index < 0 || index >= stacks.size()) throw new RuntimeException("Index out of boundry!");

        LinkedList<T> stack = stacks.get(index);
        T removed_item;

        if (removeTop) removed_item = stack.pop();
        else removed_item = stack.pollFirst();

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (index + 1 < stack.size()) {
            leftShift(index + 1, false);
        }

        return removed_item;
    }

    private LinkedList<T> getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public boolean isEmpty() {
        LinkedList<T> last = getLastStack();
        return last == null || last.isEmpty();
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(1);

        setOfStacks.push(0);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        System.out.println(setOfStacks.popAt(1));
        System.out.println(setOfStacks.popAt(1));

        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
    }

}
