package com.zzp.cci.chapter04_tree_graph;

import com.zzp.cci.lib.TreeNode;

public class Q4_4_CheckBalanced {

    // Solution 1 check diff of left height and right height
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // Solution 2 check height and balance at same time
    public static boolean isBalancedAdvanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) return -1;
        int left = checkHeight(root.left);
        if (left == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right = checkHeight(root.right);
        if (right == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (Math.abs(left - right) > 1) return Integer.MIN_VALUE;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.insertInOrder(1);
        root.insertInOrder(2);
        root.insertInOrder(4);
        root.insertInOrder(5);
        System.out.println(isBalanced(root));
        System.out.println(isBalancedAdvanced(root));
    }
}
