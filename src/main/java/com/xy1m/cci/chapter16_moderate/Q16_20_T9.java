package com.xy1m.cci.chapter16_moderate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Q16_20_T9 {

    List<List<Integer>> getSubsets(List<Integer> set, int index) {
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

    public static void main(String[] args) {
        //System.out.println(sumSubseqWidths(new int[]{2, 1, 3}));
        //TODO
    }
}
