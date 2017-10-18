package com.zzp.cci.chapter04_tree_graph;

import com.zzp.cci.lib.TreeNode;

/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an algorithm to
 * determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class Q4_10_CheckSubtree {
    /**
     * Time: O(n+m)
     * Space: O(n+m)
     *
     * @param t1
     * @param t2
     * @return
     */
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        getOrderString(t1, sb1);
        getOrderString(t2, sb2);
        return sb1.indexOf(sb2.toString()) != -1;
    }

    public static void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.val);
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }

    /**
     * Time: O(n*m) Better O(n+km) k is the occurrences of t2 in t1
     * Space: O(log(n)+log(m))
     *
     * @param t1
     * @param t2
     * @return
     */
    public static boolean containsTree1(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }

    public static boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
        else if (t1.val == t2.val && matchTree(t1, t2)) {
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    public static boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        node1.insertInOrder(1);
        node1.insertInOrder(2);
        node1.insertInOrder(3);
        node1.insertInOrder(4);
        node1.insertInOrder(6);
        node1.insertInOrder(7);
        node1.insertInOrder(8);
        node1.print();

        TreeNode node2 = new TreeNode(1);
        node2.insertInOrder(2);
        node2.insertInOrder(3);
        node2.insertInOrder(4);
        node2.print();

        System.out.println(containsTree(node1, node2));
        System.out.println(containsTree1(node1, node2));
    }
}
