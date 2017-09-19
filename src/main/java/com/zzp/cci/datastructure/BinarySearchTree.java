package com.zzp.cci.datastructure;

import com.zzp.cci.lib.TreeNode;

/**
 * Created by zhenpeng on 10/27/16.
 */
public class BinarySearchTree {
    // search minimum maximum successor predecessor
    public TreeNode search(TreeNode x, int k) {
        if (x == null || x.data == k) return x;
        if (k < x.data) return search(x.left, k);
        else return search(x.right, k);
    }

    public TreeNode interativeSearch(TreeNode x, int k) {
        while (x != null && x.data != k) {
            if (k < x.data) {
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
            if (z.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            return z;
        } else if (z.data < y.data) {
            y.left = z;
        } else {
            y.right = z;
        }
        return t;
    }
}
