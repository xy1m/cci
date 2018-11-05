package com.xy1m.cci.chapter06_math_logic_puzzles;

/**
 * Created by gzhenpeng on 10/17/18
 */
public class Q06_02_Basketball {
    public static void main(String... args) {
        // win game 1 p
        // s(k,n) = win k out of n
        // win game 2 = s(2,3)+s(3,3)
        //            = p*p*(1-p)*3+p^3 = 3p^2-2p^3
        // win game 1 = p>3p^2(1-p)+p^3 -> p-p^3>3p^2(1-p) ->p(1+p)(1-p)>3p(1-p)->1+p-3p>0-> p<0.5
    }
}
