package com.zzp.cci.sort;

/**
 * Created by zhenpeng on 10/24/16.
 */
public class CountingSort {
    public void countingSort(int[] a, int k) {
        int[] b = new int[a.length];
        int[] c = new int[k];
        for (int j = 0; j < a.length; j++) {
            c[a[j]]++;
        }
        for (int j = 1; j < k; j++) {
            c[j] += c[j - 1];
        }
        for (int j = a.length - 1; j >= 0; j--) {
            b[c[a[j]] - 1] = a[j];
            c[a[j]]--;
        }
        System.arraycopy(b, 0, a, 0, a.length);
    }

    public static void main(String args[]) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        CountingSort cs = new CountingSort();
        cs.countingSort(arr, 6);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
