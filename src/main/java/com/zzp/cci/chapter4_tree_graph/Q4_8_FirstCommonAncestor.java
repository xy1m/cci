package com.zzp.cci.chapter4_tree_graph;

import com.zzp.cci.lib.TreeNode;

/**
 * First Common Ancestor: Design an algorithm and write code to  nd the  rst common ancestor of two nodes in a binary
 * tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary chapter10_sorting_searching tree.
 */
public class Q4_8_FirstCommonAncestor {
    // With links to its parents
    // O(d) d is the height of deeper node
    TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q);
        TreeNode shallow = delta > 0 ? q : p;
        TreeNode deep = delta > 0 ? p : q;
        deep = goUpBy(deep, Math.abs(delta));
        while (shallow != deep && shallow != null && deep != null) {
            shallow = shallow.parent;
            deep = deep.parent;
        }
        return shallow == null || deep == null ? null : shallow;
    }

    TreeNode goUpBy(TreeNode n, int delta) {
        while (delta > 0 && n != null) {
            n = n.parent;
            delta--;
        }
        return n;
    }

    int depth(TreeNode n) {
        int depth = 0;
        while (n != null) {
            n = n.parent;
            depth++;
        }
        return depth;
    }

    // With links to its parents, better worst runtime
    // O(t) t is the size of subtree of first common ancestor
    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) return null;
        else if (cover(p, q)) return p;
        else if (cover(q, p)) return q;

        TreeNode sibling = sibling(p);
        TreeNode parent = p.parent;
        while (!cover(sibling, q)) {
            sibling = sibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    boolean cover(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return cover(root.left, p) || cover(root.right, p);
    }

    TreeNode sibling(TreeNode n) {
        if (n == null || n.parent == null) return n;
        TreeNode parent = n.parent;
        return parent.left == n ? parent.right : parent.left;
    }

    // Without links to its parent
    // O(n)
    TreeNode commonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) return null;
        return ancestorHelper(root, p, q);
    }

    TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        boolean pIsOnLeft = cover(root.left, p);
        boolean qIsOnLeft = cover(root.left, q);
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }
}
