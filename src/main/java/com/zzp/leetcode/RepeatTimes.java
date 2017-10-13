package com.zzp.leetcode;

public class RepeatTimes {
    public static int repeatedStringMatch(String A, String B) {
        if (A == null || B == null) return -1;

        int count = 0;
        while (B.contains(A)) {
            B = B.replaceFirst(A, "");
            count++;
        }
        if(A.contains(B)){
            count++;
            return count;
        }
        if ((A + A).contains(B)) {
            count += 2;
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
    }
}
