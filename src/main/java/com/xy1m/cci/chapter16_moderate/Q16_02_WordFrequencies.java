package com.xy1m.cci.chapter16_moderate;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Frequencies: Design a method to find the frequency of occurrences of any given word in a book. What if we were running this algorithm multiple times?
 */
public class Q16_02_WordFrequencies {
    public static int getFrequency(String[] book, String word) {
        word = word.trim().toLowerCase();
        int count = 0;
        for (String w : book) {
            if (w.trim().toLowerCase().equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static Map<String, Integer> setUpDictionary(String[] book) {
        Map<String, Integer> table = new HashMap<>();
        for (String w : book) {
            w = w.trim().toLowerCase();
            if (!w.isEmpty()) {
                if (!table.containsKey(w)) {
                    table.put(w, 0);
                }
                table.put(w, table.get(w) + 1);
            }
        }
        return table;
    }

    public static int getFrequency(Map<String, Integer> table, String word) {
        if (table == null || word == null) return 0;
        word = word.toLowerCase();
        if (table.containsKey(word)) {
            return table.get(word);
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] book = new String[]{"Hello", "World", "Apple", "Apple"};
        System.out.println(getFrequency(book, "apple"));

        Map<String, Integer> table = setUpDictionary(book);
        System.out.println(getFrequency(table, "apple"));
        System.out.println(getFrequency(table, "hello"));
    }
}
