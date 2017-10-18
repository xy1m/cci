package com.zzp.leetcode;

import com.zzp.cci.lib.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    public String serializePreOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('n').append(',');
        } else {
            sb.append(root.val).append(',');
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }


    // Decodes your encoded val to chapter04_tree_graph.
    public TreeNode deserializePreOrder(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("n")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
        SerializeBinaryTree sbt = new SerializeBinaryTree();

        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node0.left = node1;
        node0.right = node2;

        node1.left = node3;
        node2.left = node4;

        node2.right = node5;

        String res = sbt.serializePreOrder(node0);
        System.out.println(res);
    }

}
