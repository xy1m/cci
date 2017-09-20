package com.zzp.cci.lib;

// binary serach tree node
public class BSTreeNode {
    public int data;
    public BSTreeNode left, right, parent;
    private int size = 0;

    public BSTreeNode(int d) {
        this.data = d;
        size = 1;
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                setLeftChild(new BSTreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRightChild(new BSTreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public BSTreeNode find(int d) {
        if (d == data) return this;
        if (d < data) return left != null ? left.find(d) : null;
        if (d > data) return right != null ? right.find(d) : null;
        return null;
    }

    public void setLeftChild(BSTreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRightChild(BSTreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }
}
