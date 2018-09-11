package com.xy1m.cci.chapter04_tree_graph;

import com.xy1m.cci.lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which might be positive or
 * negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to
 * start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class Q4_12_PathsWithSum {

    public static List<String> findSumFromRoot(TreeNode root, int sum) {
        List<String> result = new ArrayList<>();
        buildSumPath(new LinkedList<>(), result, root, sum);
        return result;
    }

    public static void buildSumPath(LinkedList<TreeNode> paths, List<String> result, TreeNode root, int sum) {
        if (root == null) return;
        paths.add(root);
        if (root.val == sum) {
            // put into result
            StringJoiner joiner = new StringJoiner("->");
            paths.forEach(i -> joiner.add("" + i.val));
            result.add(joiner.toString());
        }
        buildSumPath(paths, result, root.left, sum - root.val);
        buildSumPath(paths, result, root.right, sum - root.val);
        paths.removeLast();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.insertInOrder(-3);
        root.insertInOrder(3);
        root.insertInOrder(2);
        root.insertInOrder(7);
        root.insertInOrder(8);
        root.insertInOrder(1);
        root.insertInOrder(4);
        root.print();

        System.out.println(findSumFromRoot(root, 5));
    }
}
