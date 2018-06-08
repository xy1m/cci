package com.zzp.cci.chapter4_tree_graph;

import com.zzp.cci.lib.TreeNode;

/**
 * Successor:
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary chapter10_sorting_searching tree.
 * You may assume that each node has a link to its parent.
 */
public class Q4_6_Successor {
    public static TreeNode inOrderSucc(TreeNode n) {
        if (n.right != null) {
            return leftMost(n.right);
        } else {
            while (n.parent != null && n != n.parent.left) {
                n = n.parent;
            }
            return n;
        }
    }

    public static TreeNode leftMost(TreeNode n) {
        if (n == null) return n;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.insertInOrder(1);
        root.insertInOrder(2);
        root.insertInOrder(3);
        root.insertInOrder(4);
        root.insertInOrder(5);
        System.out.println(inOrderSucc(root).val);
    }
}
