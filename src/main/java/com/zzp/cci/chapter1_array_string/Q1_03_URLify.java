package com.zzp.cci.chapter1_array_string;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class Q1_03_URLify {

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param str
     * @param length
     * @return
     */
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
        Q1_03_URLify app = new Q1_03_URLify();
        String input = "Hello World  Apple   Google";
        char[] arr = input.toCharArray();
        System.out.println(new String(app.replaceSpaces(arr, input.length())));
    }
}
