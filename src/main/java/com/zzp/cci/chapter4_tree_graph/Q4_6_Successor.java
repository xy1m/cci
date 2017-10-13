package com.zzp.cci.chapter4_tree_graph;

import com.zzp.cci.lib.TreeNode;

/**
 * Successor:
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary chapter10_sorting_searching tree.
 * You may assume that each node has a link to its parent.
 */
public class Q4_6_Successor {
    public TreeNode inOrderSucc(TreeNode n) {
        if (n.right != null) {
            return leftMost(n);
        } else {
            while (n.parent != null && n != n.parent.left) {
                n = n.parent;
            }
            return n;
        }
    }

    public TreeNode leftMost(TreeNode n) {
        if (n == null) return n;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
