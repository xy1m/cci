package com.zzp.cci.util;

/**
 * Created by zhenpeng on 10/17/16.
 */
public class Utils {
    public static void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[b];
        arr[a] ^= arr[b];
    }

}
