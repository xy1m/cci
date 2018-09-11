package com.xy1m.cci.chapter08_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q8_04_PowSet {
    static List<List<Integer>> getSubsets(List<Integer> set, int index) {
        List<List<Integer>> allSubsets = null;
        if (set.size() == index) {// Base case add empty set index=0
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> more = new ArrayList<>();
            for (List<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubet = new ArrayList<>();
                newSubet.addAll(subset);
                newSubet.add(item);
                more.add(newSubet);
            }
            allSubsets.addAll(more);
        }
        return allSubsets;
    }

    public static List<List<Integer>> getSubsetBit(List<Integer> set) {
        List<List<Integer>> result = new ArrayList<>();
        int max = 1 << set.size();
        for (int i = 0; i < max; i++) {
            List<Integer> current = covertIntToSet(i, set);
            result.add(current);
        }
        return result;
    }

    public static List<Integer> covertIntToSet(Integer x, List<Integer> set) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                result.add(set.get(index));
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> res = getSubsets(source, 0);
        res.forEach(cur -> System.out.println(cur.stream().map(i -> i.toString()).collect(Collectors.joining(","))));
        res = getSubsetBit(source);
        res.forEach(cur -> System.out.println(cur.stream().map(i -> i.toString()).collect(Collectors.joining(","))));
    }
}
