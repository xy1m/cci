package com.xy1m.cci.chapter16_moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Pairs with Sum: Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 */
public class Q16_24_PairsWithSum {

    //  contain duplicates including same instances
    List<List<Integer>> pairsWithSumBruteForce(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(arr[i]);
                    tmp.add(arr[j]);
                    result.add(tmp);
                }
            }
        }
        return result;
    }

    // may contain duplicates but not same instance
    List<List<Integer>> pairsWithSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> unpairedCounter = new HashMap();
        for (int x : arr) {
            if (unpairedCounter.getOrDefault(target - x, 0) > 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(target - x);
                tmp.add(x);
                result.add(tmp);
                adjustCounterBy(unpairedCounter, target - x, -1);
            }
            else {
                adjustCounterBy(unpairedCounter, x, 1);
            }
        }
        return result;
    }

    void adjustCounterBy(Map<Integer, Integer> counter, int key, int delta) {
        counter.put(key, counter.getOrDefault(key, 0) + delta);
    }

    List<List<Integer>> pairsWithSumSort(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int first = 0, last = arr.length - 1;
        while (first < last) {
            int s = arr[first] + arr[last];
            if (s == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[first]);
                tmp.add(arr[last]);
                result.add(tmp);
                first++;
                last--;
            }
            else {
                if (s < target) first++;
                else last--;
            }
        }
        return result;
    }

    // distinguish
    List<List<Integer>> pairsWithSumUnique(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int i : arr) {
            if (seen.contains(target - i)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(target - i);
                tmp.add(i);
                result.add(tmp);
            }
            seen.add(i);
        }
        return result;
    }

    public static void prettyPrint(List<List<Integer>> result) {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : result) {
            for (Integer item : list) {
                sb.append(item).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Q16_24_PairsWithSum main = new Q16_24_PairsWithSum();
        prettyPrint(main.pairsWithSumBruteForce(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8}, 10));
        prettyPrint(main.pairsWithSumSort(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8}, 10));
        prettyPrint(main.pairsWithSum(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8}, 10));
    }
}
