package com.xy1m.cci.chapter04_tree_graph;

import com.xy1m.cci.lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BST Sequences: A binary chapter10_sorting_searching tree was created by traversing through an chapter01_array_string from left to right and inserting each
 * element. Given a binary chapter10_sorting_searching tree with distinct elements, print all possible arrays that could have led to this
 * tree.
 */
public class Q4_9_BSTSequences {
    static List<LinkedList<Integer>> allSequences(TreeNode node) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.val);

        List<LinkedList<Integer>> leftSeq = allSequences(node.left);
        List<LinkedList<Integer>> rightSeq = allSequences(node.right);
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    static void weaveLists(LinkedList<Integer> first,
                           LinkedList<Integer> second,
                           List<LinkedList<Integer>> results,
                           LinkedList<Integer> prefix) {
        if (first.isEmpty() || second.isEmpty()) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        Integer headFirst = first.removeFirst();
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        Integer secondFirst = second.removeFirst();
        prefix.add(secondFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(secondFirst);
    }


    public static void main(String[] args) {
        /*TreeNode node = new TreeNode(50);
        node.insertInOrder(20);
        node.insertInOrder(10);
        node.insertInOrder(25);
        node.insertInOrder(5);
        node.insertInOrder(15);

        node.insertInOrder(60);
        node.insertInOrder(70);
        node.insertInOrder(65);
        node.insertInOrder(85);*/

        TreeNode node = new TreeNode(3);
        node.insertInOrder(1);
        node.insertInOrder(2);
        node.insertInOrder(4);
        node.insertInOrder(5);

        List<LinkedList<Integer>> result = allSequences(node);
        result.forEach(l -> System.out.println(l));
    }
}
