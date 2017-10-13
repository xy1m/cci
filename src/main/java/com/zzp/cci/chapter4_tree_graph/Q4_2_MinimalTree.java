package com.zzp.cci.chapter4_tree_graph;

import com.zzp.cci.lib.TreeNode;

/**
 * Minimal Tree:
 * Given a sorted (increasing order) chapter1_array_string with unique integer elements, write an algorithm to create a binary chapter10_sorting_searching
 * tree with minimal height.
 */
public class Q4_2_MinimalTree {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 9, 12};
        TreeNode node = TreeNode.createMinimalBST(arr, 0, arr.length - 1);
        node.print();
    }
}
