package com.zzp.cci.tree;

import com.zzp.cci.lib.TreeNode;

public class BinaryTreeTraversal {

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
        System.out.println(head.data);
    }

}
