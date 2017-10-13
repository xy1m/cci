package com.zzp.cci.lib;

/**
 * Created by zhenpeng on 10/27/16.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int d) {
        this.val = d;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= val) {
            if (left == null) {
                TreeNode node = new TreeNode(d);
                setLeft(node);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                TreeNode node = new TreeNode(d);
                setRight(node);
            } else {
                right.insertInOrder(d);
            }
        }
    }

    public boolean isBST() {
        return isValidBST(this);
    }

    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode find(int d) {
        if (val == d) {
            return this;
        } else if (val < d) {
            return left != null ? left.find(d) : null;
        } else if (val > d) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }


    public static TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.setLeft(createMinimalBST(arr, start, mid - 1));
        root.setRight(createMinimalBST(arr, mid + 1, end));
        return root;
    }

    public void print() {
        BTreePrinter.printNode(this);
    }

    public void inOrderTraversal(TreeNode head) {
        if (head != null) {
            visit(head.left);
            visit(head);
            visit(head.right);
        }
    }

    public void preOrderTraversal(TreeNode head) {
        if (head != null) {
            visit(head);
            visit(head.left);
            visit(head.right);
        }
    }

    public void postOrderTraversal(TreeNode head) {
        if (head != null) {
            visit(head.left);
            visit(head.right);
            visit(head);
        }
    }

    public void visit(TreeNode head) {
        System.out.println(head.val);
    }
}
