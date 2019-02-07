package com.xy1m.cci.chapter16_moderate;

public class Q16_18_PatternMatching {

    public static boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;
        int size = value.length();
        for (int mainSize = 0; mainSize <= size; mainSize++) {
            String main = value.substring(0, mainSize);
            for (int altStart = mainSize; altStart <= size; altStart++) {
                for (int altEnd = altStart; altEnd <= size; altEnd++) {
                    String alt = value.substring(altStart, altEnd);
                    String cand = buildFromPattern(pattern, main, alt);
                    if (cand.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String buildFromPattern(String pattern, String main, String alt) {
        StringBuffer sb = new StringBuffer();
        char first = pattern.charAt(0);
        for (char c : pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            }
            else {
                sb.append(alt);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(buildFromPattern("ababb", "cat", "go"));
        System.out.println(doesMatch("aabab", "catcatgocatgo"));
        System.out.println(doesMatch("a", "catcatgocatgo"));
        System.out.println(doesMatch("b", "catcatgocatgo"));
        System.out.println(doesMatch("ab", "catcatgocatgo"));
    }
}
