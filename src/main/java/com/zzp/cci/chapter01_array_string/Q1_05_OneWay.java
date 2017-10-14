package com.zzp.cci.chapter01_array_string;

public class Q1_05_OneWay {

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneReplaceAway(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneInsertAway(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneInsertAway(second, first);
        }
        return true;
    }

    public static boolean oneReplaceAway(String w1, String w2) {
        boolean foundDiff = false;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (foundDiff) return false;
                foundDiff = true;
            }
        }
        return true;
    }

    public static boolean oneInsertAway(String w1, String w2) {
        int index1 = 0, index2 = 0;
        while (index1 < w1.length() && index2 < w2.length()) {
            if (w1.charAt(index1) != w2.charAt(index2)) {
                if (index1 != index2) return false;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean oneEditAway2(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;
        int index1 = 0;
        int index2 = 0;
        boolean foundDiff = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDiff) return false;
                foundDiff = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("apple", "aple"));
        System.out.println(oneEditAway("apple", "axple"));
        System.out.println(oneEditAway("aple", "apple"));

        System.out.println(oneEditAway2("apple", "aple"));
        System.out.println(oneEditAway2("apple", "axple"));
        System.out.println(oneEditAway2("aple", "apple"));

    }
}
