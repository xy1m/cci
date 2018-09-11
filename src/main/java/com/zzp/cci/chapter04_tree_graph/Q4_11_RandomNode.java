package com.zzp.cci.chapter04_tree_graph;

import java.util.Random;

/**
 * Random Node: You are implementing a binary tree class from scratch which, in addition to insert, find, and delete,
 * has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be
 * chosen. Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the
 * methods.
 */


public class Q4_11_RandomNode {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public int size;

        public TreeNode(int d) {
            this.val = d;
            this.size = 1;
        }

        public TreeNode getRandom() {
            int leftSize = left == null ? 0 : left.size;
            Random random = new Random();
            int index = random.nextInt(size);
            if (index < leftSize) {
                return left.getRandom();
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getRandom();
            }
        }

        public void insertInOrder(int d) {
            if (d <= val) {
                if (left == null) {
                    left = new TreeNode(d);
                } else {
                    left.insertInOrder(d);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(d);
                } else {
                    right.insertInOrder(d);
                }
            }
            size++;
        }

        public TreeNode find(int d) {
            if (d == val) return this;
            if (d < val) return left != null ? left.find(d) : null;
            if (d > val) return right != null ? right.find(d) : null;
            return null;
        }

        public TreeNode getIthNode(int i) {
            int leftSize = left == null ? 0 : left.size;
            if (i < leftSize) {
                return left.getIthNode(i);
            } else if (i == leftSize) {
                return this;
            } else {
                return right.getIthNode(i - (leftSize + 1));
            }
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    static class Tree {
        TreeNode root = null;

        public int size() {
            return root == null ? 0 : root.size;
        }

        public TreeNode getRandom() {
            if (root == null) return null;
            Random random = new Random();
            int i = random.nextInt(size());
            return root.getIthNode(i);
        }

        public void insertInOrder(int value) {
            if (root == null) root = new TreeNode(value);
            else root.insertInOrder(value);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.insertInOrder(2);
        treeNode.insertInOrder(3);
        treeNode.insertInOrder(4);
        treeNode.insertInOrder(5);
        System.out.println(treeNode.getRandom());
        System.out.println(treeNode.getRandom());
        System.out.println(treeNode.getRandom());
        System.out.println(treeNode.getRandom());
        System.out.println(treeNode.getRandom());
    }
}
