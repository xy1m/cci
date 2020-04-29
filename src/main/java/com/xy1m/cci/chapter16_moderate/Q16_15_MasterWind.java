package com.xy1m.cci.chapter16_moderate;

public class Q16_15_MasterWind {

    static int MAX_COLORS = 4;

    static class Result {
        public int hit;
        public int pseudoHit;

        public String toString() {
            return "hit=" + hit + ",pseudoHit=" + pseudoHit;
        }
    }

    static int code(char c) {
        switch (c) {
            case 'R':
                return 0;
            case 'G':
                return 1;
            case 'B':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }


    static Result estimate(String guess, String solution) {
        if (guess == null || solution == null || guess.length() != solution.length()) {
            return null;
        }
        Result res = new Result();
        int[] frequencies = new int[MAX_COLORS];

        for (int i = 0; i < solution.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hit++;
            }
            else {
                int code = code(solution.charAt(i));
                frequencies[code]++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                res.pseudoHit++;
                frequencies[code]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(estimate("RGBY", "RRGG"));
        System.out.println(estimate("RRRR", "RRRR"));
    }
}
