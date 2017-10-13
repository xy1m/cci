package com.zzp.cci.chapter4_tree_graph;

import com.zzp.cci.lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * List of Depths:
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class Q4_3_ListOfDepths {

    // Solution 1 DFS
    public static List<List<TreeNode>> dfs(TreeNode root) {
        List<List<TreeNode>> lists = new ArrayList<>();
        dfs(root, lists, 0);
        return lists;
    }

    public static void dfs(TreeNode root, List<List<TreeNode>> lists, int level) {
        if (root == null) return;
        List<TreeNode> current;
        if (lists.size() == level) {
            current = new ArrayList<>();
            lists.add(current);
        } else {
            current = lists.get(level);
        }
        current.add(root);

        dfs(root.left, lists, level + 1);
        dfs(root.right, lists, level + 1);
    }

    // Solution 2 BFS
    public static List<List<TreeNode>> bfs(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        if (root != null) {
            current.add(root);
        }
        while (!current.isEmpty()) {
            result.add(current);
            List<TreeNode> parents = current;
            current = new ArrayList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 9, 12};
        TreeNode node = TreeNode.createMinimalBST(arr, 0, arr.length - 1);
        node.print();

        List<List<TreeNode>> levels = dfs(node);
        for (List<TreeNode> i : levels) {
            for (TreeNode j : i) {
                System.out.print(j.val + " ");
            }
            System.out.println();
        }
        System.out.println("===");
        levels = bfs(node);
        for (List<TreeNode> i : levels) {
            for (TreeNode j : i) {
                System.out.print(j.val + " ");
            }
            System.out.println();
        }

    }
}
