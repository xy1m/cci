package com.zzp.cci.chapter3_stack_queues;

import java.util.Arrays;

/**
 * Created by zhenpeng on 8/23/17.
 */
public class ThreeStackByArray {
    public static void main(String... args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);
        stack.push(0, 4);
        stack.push(0, 5);
        System.out.println(stack.peek(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
    }
}

class Stack<N> {
    int stackNum = 3;
    int stackSize = 100;
    int[] buffer = new int[stackSize * stackNum];
    int[] stackPointer = new int[stackNum];

    public Stack() {
        Arrays.fill(stackPointer, -1);
    }

    public void push(int num, int value) {
        if (stackPointer[num] + 1 >= stackSize) {
            throw new RuntimeException("Stack overflow");
        }
        stackPointer[num]++;
        buffer[absTopOfStack(num)] = value;
    }

    public int pop(int num) {
        if (isEmpty(num)) {
            throw new RuntimeException("Trying to pop an empty chapter3_stack_queues!");
        }
        int value = buffer[absTopOfStack(num)];
        // clear element
        buffer[absTopOfStack(num)] = 0;
        // decrease pointer
        stackPointer[num]--;
        return value;
    }

    public int peek(int num) {
        if (isEmpty(num)) {
            throw new RuntimeException("Trying to peek an empty chapter3_stack_queues!");
        }
        return buffer[absTopOfStack(num)];
    }

    public boolean isEmpty(int num) {
        return stackPointer[num] == -1;
    }

    public int absTopOfStack(int num) {
        return stackSize * num + stackPointer[num];
    }
}
