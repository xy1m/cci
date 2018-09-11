package com.xy1m.cci.chapter03_stack_queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q3_03_SetOfStacks {
    List<LinkedList> stacks = new ArrayList<>();
    public int capacity;

    public Q3_03_SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object v) {
        LinkedList lastStack = getLastStack();
        if (lastStack != null && lastStack.size() != capacity) {
            lastStack.push(v);
        } else {
            LinkedList newStack = new LinkedList();
            newStack.push(v);
            stacks.add(newStack);
        }
    }

    public Object pop() {
        LinkedList last = getLastStack();
        if (last == null) throw new RuntimeException("Trying to pop from empty chapter03_stack_queues");
        Object v = last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public Object peek() {
        LinkedList last = getLastStack();
        if (last == null) throw new RuntimeException("Trying to pop from empty chapter03_stack_queues");
        return last.peek();
    }

    private LinkedList getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public Object popAt(int index) {
        return leftShift(index, true);
    }

    private Object leftShift(int index, boolean removeTop) {
        if (index < 0 || index >= stacks.size()) throw new RuntimeException("Index out of boundary!");

        LinkedList stack = stacks.get(index);
        Object removed_item;

        if (removeTop) removed_item = stack.pop();
        else removed_item = stack.poll();

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (index + 1 < stack.size()) {
            leftShift(index + 1, false);
        }
        return removed_item;
    }

    //TODO double direction stack

    public static void main(String[] args) {
        Q3_03_SetOfStacks setOfStacks = new Q3_03_SetOfStacks(1);

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
