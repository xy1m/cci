package com.xy1m.cci.chapter06_math_logic_puzzles;

/**
 * Created by gzhenpeng on 10/17/18
 */
public class Q06_01_TheHeavyPills {

    public static int indexOfHeavyPill(double[] pills) {
        double sum = 0;
        double expext = 0;
        for (int i = 0; i < 20; i++) {
            sum += (i + 1) * pills[i];
            expext += i + 1;
        }
        return (int) ((sum - expext) / 0.1);
    }

    public static void main(String... args) {
        double[] pills = new double[]{
                1f, 1f, 1f, 1f, 1f,
                1f, 1f, 1f, 1f, 1f,
                1f, 1f, 1.1f, 1f, 1f,
                1f, 1f, 1f, 1f, 1f
        };

        System.out.println(indexOfHeavyPill(pills));
    }
}
