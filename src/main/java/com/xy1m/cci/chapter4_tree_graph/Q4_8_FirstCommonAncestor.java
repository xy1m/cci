package com.zzp.cci.chapter4_tree_graph;

import com.zzp.cci.lib.TreeNode;

/**
 * First Common Ancestor: Design an algorithm and write code to  nd the  rst common ancestor of two nodes in a binary
 * tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary chapter10_sorting_searching tree.
 */
public class Q4_8_FirstCommonAncestor {
    // With links to its parents
    // O(d) d is the height of deeper node
    static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = p.height() - q.height();
        TreeNode shallow = delta > 0 ? q : p;
        TreeNode deep = delta > 0 ? p : q;
        deep = goUpBy(deep, Math.abs(delta));
        while (shallow != null && deep != null && shallow != deep) {
            shallow = shallow.parent;
            deep = deep.parent;
        }
        return shallow == null || deep == null ? null : shallow;
    }

    static TreeNode goUpBy(TreeNode n, int delta) {
        while (delta > 0 && n != null) {
            n = n.parent;
            delta--;
        }
        return n;
    }

    // With links to its parents, better worst runtime
    // O(t) t is the size of subtree of first common ancestor
    static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) return null;
        else if (cover(p, q)) return p;
        else if (cover(q, p)) return q;

        TreeNode sibling = sibling(p);
        TreeNode parent = p.parent;
        while (parent != null && !cover(sibling, q)) {
            sibling = sibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    static boolean cover(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return cover(root.left, p) || cover(root.right, p);
    }

    static TreeNode sibling(TreeNode n) {
        if (n == null || n.parent == null) return n;
        TreeNode parent = n.parent;
        return parent.left == n ? parent.right : parent.left;
    }

    // Without links to its parent
    // O(n)
    static TreeNode commonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) return null;
        return ancestorHelper(root, p, q);
    }

    static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        boolean pIsOnLeft = cover(root.left, p);
        boolean qIsOnLeft = cover(root.left, q);
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    static TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        TreeNode left = commonAncestor2(root.left, p, q);
        TreeNode right = commonAncestor2(root.left, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.setLeft(node1);
        root.setRight(node2);
        System.out.println(commonAncestor(node1, node2).val);
        System.out.println(commonAncestor(root, node1, node2).val);
        System.out.println(commonAncestor1(root, node1, node2).val);
        System.out.println(commonAncestor2(root, node1, node2).val);
    }
}
