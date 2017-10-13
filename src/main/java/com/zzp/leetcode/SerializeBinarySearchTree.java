package com.zzp.leetcode;

import com.zzp.cci.lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeBinarySearchTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "n";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append(root.val).append(',');
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return sb.substring(0, sb.length() - 1);
    }

    public TreeNode deserialize(String str) {
        if (str.equals("n")) return null;
        String[] strs = str.split(",");
        Queue<Integer> nodes = new LinkedList<>();
        for (String s : strs) {
            nodes.offer(Integer.valueOf(s));
        }
        return getNode(nodes);
    }

    private TreeNode getNode(Queue<Integer> nodes) {
        if (nodes.isEmpty()) return null;
        Integer val = nodes.poll();
        Queue<Integer> smaller = new LinkedList<>();
        while (!nodes.isEmpty() && nodes.peek() <= val) {
            smaller.offer(nodes.poll());
        }

        TreeNode root = new TreeNode(val);
        root.left = getNode(smaller);
        root.right = getNode(nodes);
        return root;
    }

    public static void main(String[] args) {
        SerializeBinarySearchTree solution = new SerializeBinarySearchTree();

        TreeNode node0 = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(3);
        TreeNode nodex = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(7);

        node0.left = node1;
        node1.left = node2;
        node2.left = nodex;

        node0.right = node3;
        node3.right = node4;

        String output = solution.serialize(node0);
        System.out.println(output);

        TreeNode node = solution.deserialize(output);

        System.out.println(node);
    }
}
