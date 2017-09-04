package com.zzp.cci.sort;

/**
 * Created by zhenpeng on 10/24/16.
 */
public class RadixSort {
    public void radixSort(int[] arr) {
        // use stable sort to sort array arr on digit i
        for (int i = 1; i < 3; i++) {
            countingSort(arr, i, 10);
        }
    }

    public void countingSort(int[] arr, int i, int k) {
        // use stable sort to sort array arr on digit i
        int[] b = new int[arr.length];
        int[] c = new int[k];
        for (int j = 0; j < arr.length; j++) {
            c[digitOfNumber(arr[j], i)]++;
        }
        for (int j = 1; j < k; j++) {
            c[j] += c[j - 1];
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            b[c[digitOfNumber(arr[j], i)] - 1] = arr[j];
            c[digitOfNumber(arr[j], i)]--;
        }
        System.arraycopy(b, 0, arr, 0, arr.length);
    }


    public int digitOfNumber(int num, int i) {
        int d = 1;
        for (int j = 1; j <= i; j++) {
            d *= 10;
        }
        return (num / d) % 10;
    }

    public static void main(String args[]) {
        int[] arr = {311, 256, 302, 198, 302, 864, 911, 730, 266, 521, 907, 102};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
