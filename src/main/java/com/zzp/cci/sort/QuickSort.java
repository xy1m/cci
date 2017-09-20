package com.zzp.cci.sort;

import com.zzp.cci.util.Utils;

import java.util.Random;

/**
 * Created by zhenpeng on 10/20/16.
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pos = partition(arr, left, right);
            quickSort(arr, left, pos - 1);
            quickSort(arr, pos + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                Utils.swap(arr, i, j);
            }
        }
        Utils.swap(arr, i + 1, right);
        return i + 1;
    }

    public int partition2(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            // find element on left that should be on right
            while (arr[left] < pivot) left++;
            // find element on right that should be on left
            while (arr[right] > pivot) right--;
            if (left <= right) {
                Utils.swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public int randomPartition(int[] arr, int l, int r) {
        Random random = new Random();
        int i = l + random.nextInt(r - l);
        Utils.swap(arr, i, r);
        return partition(arr, l, r);
    }


    public static void main(String args[]) {
        QuickSort qs = new QuickSort();
        int[] arr = {3, 2, 1, 4, 8, 7, 6, 9, 0, 5};
        qs.quickSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
