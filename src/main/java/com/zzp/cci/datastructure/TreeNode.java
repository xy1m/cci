package com.zzp.cci.datastructure;

/**
 * Created by zhenpeng on 10/27/16.
 */
public class TreeNode {
    int key;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.key = x;
    }

    public static void main(String args[]) {
        TreeNode a0 = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(7);
        a0.left = a1;
        a0.right = a2;
        a1.parent = a0;
        a2.parent = a0;
        a1.left = a3;
        a1.right = a4;
        a3.parent = a1;
        a4.parent = a1;
        a2.left = a5;
        a2.right = a6;
        a5.parent = a2;
        a6.parent = a2;
        BinarySearchTree bst = new BinarySearchTree();
        bst.inOrderWalk(a0);
    }

}
