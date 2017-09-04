package com.zzp.cci.datastructure;

/**
 * Created by zhenpeng on 10/27/16.
 */
public class BinarySearchTree {
    // search minimum maximum successor predecessor
    public void inOrderWalk(TreeNode root) {
        if (root == null) return;
        inOrderWalk(root.left);
        System.out.println(root.key);
        inOrderWalk(root.right);
    }

    public void preOrderWalk(TreeNode root) {
        if (root == null) return;
        System.out.println(root.key);
        preOrderWalk(root.left);
        preOrderWalk(root.right);
    }

    public void postOrderWalk(TreeNode root) {
        if (root == null) return;
        postOrderWalk(root.left);
        postOrderWalk(root.right);
        System.out.println(root.key);
    }

    public TreeNode search(TreeNode x, int k) {
        if (x == null || x.key == k) return x;
        if (k < x.key) return search(x.left, k);
        else return search(x.right, k);
    }

    public TreeNode interativeSearch(TreeNode x, int k) {
        while (x != null && x.key != k) {
            if (k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    public TreeNode minimum(TreeNode x) {
        while (x != null && x.left != null) {
            x = x.left;
        }
        return x;
    }

    public TreeNode maximum(TreeNode x) {
        while (x != null && x.right != null) {
            x = x.right;
        }
        return x;
    }

    public TreeNode successor(TreeNode x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        TreeNode y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public TreeNode predecessor(TreeNode x) {
        if (x.left != null) {
            return maximum(x.left);
        }
        TreeNode y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public TreeNode insert(TreeNode t, TreeNode z) {
        TreeNode y = null;
        TreeNode x = t;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            return z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        return t;
    }
}
