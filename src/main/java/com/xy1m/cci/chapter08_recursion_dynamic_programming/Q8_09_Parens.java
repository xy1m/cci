package com.xy1m.cci.chapter08_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Parens: Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 * <p>
 * 0=null
 * 1=()
 * 2=()() , (())
 * 3=()()() , (())() , ()(()) , ((())) , (()())
 * 4=?
 */
public class Q8_09_Parens {

    public static Set<String> parensRecursive(int n) {
        if (n <= 0) return null;
        if (n == 1) {
            Set<String> result = new HashSet<>();
            result.add("()");
            return result;
        }
        Set<String> result = new HashSet<>();
        Set<String> previous = parensRecursive(n - 1);
        for (String pre : previous) {
            result.add(pre + "()");
            result.add("()" + pre);
            result.add("(" + pre + ")");

            for (int i = 1; i < pre.length() - 1; i++) {
                if (pre.charAt(i - 1) == '(' && pre.charAt(i) == ')') {
                    result.add(pre.substring(0, i + 1) + "()" + pre.substring(i + 1));
                }
            }
        }
        return result;
    }

    public static Set<String> parensIterative(int n) {
        if (n <= 0) return null;
        Set<String> previous = new HashSet<>();
        previous.add("()");
        if (n == 1) {
            return previous;
        }
        for (int j = 2; j <= n; j++) {
            Set<String> current = new HashSet<>();
            for (Iterator<String> iter = previous.iterator(); iter.hasNext(); ) {
                String pre = iter.next();
                iter.remove();
                current.add(pre + "()");
                current.add("()" + pre);
                current.add("(" + pre + ")");

                for (int i = 1; i < pre.length() - 1; i++) {
                    if (pre.charAt(i - 1) == '(' && pre.charAt(i) == ')') {
                        current.add(pre.substring(0, i + 1) + "()" + pre.substring(i + 1));
                    }
                }
            }
            previous = current;
        }
        return previous;
    }

    public static String prettyStr(Set<String> input) {
        StringJoiner joiner = new StringJoiner(",");
        input.forEach(s -> joiner.add(s));
        return joiner.toString();
    }

    public static List<String> generateParenthesis(int n) {
        return new ArrayList<>(parens(n));
    }
    static Set<String> parens(int n){
        Set<String> result=new HashSet<>();
        if(n==0){
            return result;
        }
        if(n==1){
            result.add("()");
            return result;
        }
        Set<String> previous=parens(n-1);
        for(String pre: previous){
            result.add("()"+pre);
            result.add(pre+"()");
            result.add("("+pre+")");
            for(int i=0;i<pre.length()-1;i++){
                if(pre.charAt(i)=='('&&pre.charAt(i+1)==')'){
                    result.add(pre.substring(0,i+1)+"()"+pre.substring(i+1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*String nums = "012345678";
        System.out.println(nums.substring(0, 2));
        System.out.println(nums.substring(2));
        System.out.println(nums.substring(2, 9));*/

        /*System.out.println(prettyStr(parensRecursive(1)));
        System.out.println(prettyStr(parensRecursive(2)));
        System.out.println(prettyStr(parensRecursive(3)));
        System.out.println(prettyStr(parensRecursive(4)));
        System.out.println(prettyStr(parensIterative(4)));

        long s1 = System.currentTimeMillis();
        parensRecursive(15);
        long s2 = System.currentTimeMillis();
        parensIterative(15);
        long s3 = System.currentTimeMillis();

        System.out.println(s2 - s1);
        System.out.println(s3 - s2);*/
        for (String s : generateParenthesis(6)) {
            System.out.println(s);
        }
    }
}