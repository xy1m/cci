package com.xy1m.cci.chapter08_recursion_dynamic_programming;

import java.util.Stack;

public class Q8_06_TowerOfHanoi {
    static class Tower {
        Stack<Integer> disks;
        int index;

        public Tower(int i) {
            index = i;
            disks = new Stack<>();
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error");
            }
            else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower to) {
            to.add(disks.pop());
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }

    public static void moveDisks(int n) {
        Tower origin = new Tower(0);
        Tower buffer = new Tower(1);
        Tower destination = new Tower(2);
        for (int i = n; i > 0; i--) {
            origin.add(i);
        }
        origin.moveDisks(n, destination, buffer);

        while (!destination.disks.isEmpty()) {
            System.out.println(destination.disks.pop());
        }
    }

    public static void main(String[] args) {
        moveDisks(10);
    }
}


