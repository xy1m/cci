package com.zzp.cci.chapter4_tree_graph;

import com.zzp.cci.lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Check Balanced:
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
 * defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class Q4_4_CheckBST {

    /**
     * Solution 1, copy elements to chapter01_array_string and check if sorted, only works if there is no duplicate elements
     *
     * @param root
     * @return
     */
    public boolean isBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        copyBST(root, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(i - 1)) return false;
        }
        return true;
    }

    public void copyBST(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        copyBST(root.left, arr);
        arr.add(root.val);
        copyBST(root.right, arr);
    }

    // Optimized solution if there is no duplicate elements
    Integer last = null;

    public boolean checkBST(TreeNode root) {
        if (root == null) return true;
        if (!checkBST(root.left)) return false;
        if (last != null && root.val <= last) return false;
        last = root.val;
        if (!checkBST(root.right)) return false;
        return true;
    }

    // Soution 2 check base on Max and Min value
    public boolean checkBST2(TreeNode root) {
        return checkBST(root, null, null);
    }

    public boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return false;
        if (min != null && root.val <= min || max != null && root.val > max) return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

}
