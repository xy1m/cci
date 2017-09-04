package com.zzp.cci.array;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class C1_4 {

    public char[] replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength, i;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = length + 2 * spaceCount;
        char[] res = new char[newLength];
        //res[newLength]='\0';
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                res[newLength - 1] = '0';
                res[newLength - 2] = '2';
                res[newLength - 3] = '%';
                newLength -= 3;
            } else {
                res[newLength - 1] = str[i];
                newLength--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        C1_4 solution = new C1_4();
        String input = "Hello World   My baby";
        char[] arr = input.toCharArray();
        int length = input.length();
        System.out.println(new String(solution.replaceSpaces(arr, length)));
    }
}
