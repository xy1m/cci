package com.zzp.cci.chapter05_bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class Q5_03_FlipToWin {
    public static int longestSequence(int n) {
        if (n == -1) return Integer.SIZE;
        List<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);
    }

    public static List<Integer> getAlternatingSequences(int n) {
        List<Integer> result = new ArrayList<>();
        int searchingFor = 0;
        int count = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((n & 1) != searchingFor) {
                result.add(count);
                searchingFor = n & 1;
                count = 0;
            }
            count++;
            n >>>= 1;
        }
        result.add(count);
        return result;
    }

    public static int findLongestSequence(List<Integer> sequences) {
        int maxSeq = 1;
        for (int i = 0; i < sequences.size(); i += 2) {
            int zeroSeq = sequences.get(i);
            int oneSeqLeft = i - 1 >= 0 ? sequences.get(i - 1) : 0;
            int oneSeqRight = i + 1 < sequences.size() ? sequences.get(i + 1) : 0;

            int thisSeq = 0;
            if (zeroSeq == 1) {
                thisSeq = 1 + oneSeqLeft + oneSeqRight;
            } else if (zeroSeq > 1) {
                thisSeq = 1 + Math.max(oneSeqLeft, oneSeqRight);
            } else if (zeroSeq == 0) {
                thisSeq = Math.max(oneSeqLeft, oneSeqRight);
            }
            maxSeq = Math.max(maxSeq, thisSeq);
        }
        return maxSeq;
    }

    public static int flipBit(int a) {
        if (~a == -1) return Integer.SIZE;
        int currentLength = 0;
        int previousLength = 0;
        int max = 1;
        while (a != 0) {
            if ((a & 1) == 1) {
                currentLength++;
            } else {
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            max = Math.max(max, previousLength + currentLength + 1);
            a >>>= 1;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestSequence(1775));
        System.out.println(flipBit(1775));
    }
}
