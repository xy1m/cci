package com.zzp.cci.chapter8_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q8_08_PermutationsWithDups {

    public static List<String> getPerms(String str) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> counter = buildFreqTable(str);
        printPerms(counter, "", str.length(), result);
        return result;
    }

    public static Map<Character, Integer> buildFreqTable(String str) {
        Map<Character, Integer> map = new HashMap<>();
        if (str == null || str.isEmpty()) return map;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            int count = map.getOrDefault(cur, 0);
            map.put(cur, count + 1);
        }
        return map;
    }

    public static void printPerms(Map<Character, Integer> counter, String prefix, int remaining, List<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }
        for (Character c : counter.keySet()) {
            int count = counter.get(c);
            if (count > 0) {
                counter.put(c, count - 1);
                printPerms(counter, prefix + c, remaining - 1, result);
                counter.put(c, count);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getPerms("aabc"));
    }
}
