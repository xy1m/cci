package com.zzp.cci.statistics;


import com.zzp.cci.sort.QuickSort;

/**
 * Created by zhenpeng on 10/25/16.
 */
public class Topk {
    public int randomSelect(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        QuickSort qs = new QuickSort();
        int q = qs.randomPartition(arr, p, r);
        int k = q - p + 1;
        if (k == i) {
            return arr[k];
        }
        if (k < i) {
            return randomSelect(arr, p, q - 1, i);
        } else {
            return randomSelect(arr, q + 1, r, i - k);
        }
    }

    public static void main(String args[]) {
    }

}
