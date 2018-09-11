package com.xy1m.cci.sort;

/**
 * Created by zhenpeng on 10/20/16.
 */
public class MergeSort {

    public void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (r + p) >> 1;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        System.arraycopy(arr, p, left, 0, n1);
        System.arraycopy(arr, q + 1, right, 0, n2);
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
        }
    }

    public static void main(String args[]) {
        MergeSort ms = new MergeSort();
        int[] arr = {3, 2, 1, 4, 8, 7, 6, 9, 0, 5};
        ms.mergeSort(arr, 0, arr.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
