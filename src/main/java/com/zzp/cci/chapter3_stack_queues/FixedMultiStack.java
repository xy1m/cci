package com.zzp.cci.chapter3_stack_queues;

public class FixedMultiStack {
    private int numberOfStacks;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int numberOfStacks, int stackCapacity) {
        this.numberOfStacks = numberOfStacks;
        this.stackCapacity = stackCapacity;
        values = new int[numberOfStacks * stackCapacity];
        sizes = new int[numberOfStacks];
    }

    public void push(int num, int value) {
        if (isFull(num)) throw new RuntimeException("chapter3_stack_queues overflow");
        sizes[num]++;
        values[indexOfTop(num)] = value;
    }

    public int pop(int num) {
        if (isEmpty(num)) throw new RuntimeException("Trying to pop from empty chapter3_stack_queues");
        int item = values[indexOfTop(num)];
        // clear element;
        values[indexOfTop(num)] = 0;
        sizes[num]--;
        return item;
    }

    public int peek(int num) {
        if (isEmpty(num)) throw new RuntimeException("Trying to pop from empty chapter3_stack_queues");
        return values[indexOfTop(num)];
    }

    public boolean isFull(int num) {
        return sizes[num] == stackCapacity;
    }

    public boolean isEmpty(int num) {
        return sizes[num] == 0;
    }

    private int indexOfTop(int num) {
        return stackCapacity * num + sizes[num] - 1;
    }

    public static void main(String[] args) {
        FixedMultiStack fixedMultiStack = new FixedMultiStack(3, 3);
        fixedMultiStack.push(0, 1);
        fixedMultiStack.push(0, 2);
        fixedMultiStack.push(0, 3);

        fixedMultiStack.push(1, 1);
        fixedMultiStack.push(1, 2);
        fixedMultiStack.push(1, 3);

        fixedMultiStack.push(2, 1);
        fixedMultiStack.push(2, 2);
        fixedMultiStack.push(2, 3);

        System.out.println(fixedMultiStack.pop(0));
        System.out.println(fixedMultiStack.pop(0));
        System.out.println(fixedMultiStack.pop(0));

        System.out.println(fixedMultiStack.pop(1));
        System.out.println(fixedMultiStack.pop(1));
        System.out.println(fixedMultiStack.pop(1));

        System.out.println(fixedMultiStack.pop(2));
        System.out.println(fixedMultiStack.pop(2));
        System.out.println(fixedMultiStack.pop(2));

    }
}
