package com.xy1m.cci.chapter10_sorting_searching;

import com.xy1m.cci.lib.HashMapList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q10_02_Group_Anagrams {
    static String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    static class AnagramComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return sortChars(o1).compareTo(sortChars(o2));
        }
    }

    static void sort1(String[] array) {
        Arrays.sort(array, new AnagramComparator());
        System.out.println(Arrays.asList(array));
    }

    static void sort2(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<>();
        for (String s : array) {
            mapList.put(sortChars(s), s);
        }
        int index = 0;
        for (String key : mapList.keySet()) {
            List<String> list = mapList.get(key);
            for (String t : list) {
                array[index++] = t;
            }
        }
        System.out.println(Arrays.asList(array));
    }

    public static void main(String[] args) {
        sort1(new String[]{"abc", "aba", "cba", "acb"});
        sort2(new String[]{"abc", "aba", "cba", "acb", "catdog", "docatg"});
    }
}
