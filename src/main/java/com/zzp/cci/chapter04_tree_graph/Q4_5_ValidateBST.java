package com.zzp.cci.chapter04_tree_graph;

import com.zzp.cci.lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Check Balanced:
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
 * defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class Q4_5_ValidateBST {

    /**
     * Solution 1, copy elements to chapter01_array_string and check if sorted, only works if there is no duplicate elements
     *
     * @param root
     * @return
     */
    public static boolean isBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        copyBST(root, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(i - 1)) return false;
        }
        return true;
    }

    public static void copyBST(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        copyBST(root.left, arr);
        arr.add(root.val);
        copyBST(root.right, arr);
    }

    // Optimized solution if there is no duplicate elements
    static Integer last = null;

    public static boolean checkBST(TreeNode root) {
        if (root == null) return true;
        if (!checkBST(root.left)) return false;
        if (last != null && root.val <= last) return false;
        last = root.val;
        if (!checkBST(root.right)) return false;
        return true;
    }

    // Soution 2 check base on Max and Min value
    public static boolean checkBST2(TreeNode root) {
        return checkBST2(root, null, null);
    }

    public static boolean checkBST2(TreeNode root, Integer min, Integer max) {
        if (root == null) return false;
        if (min != null && root.val <= min || max != null && root.val > max) return false;
        return checkBST2(root.left, min, root.val) && checkBST2(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.insertInOrder(1);
        root.insertInOrder(2);
        root.insertInOrder(4);
        root.insertInOrder(5);
        root.insertInOrder(6);
        System.out.println(isBST(root));
        System.out.println(checkBST(root));
        System.out.println(checkBST2(root));
    }
}
