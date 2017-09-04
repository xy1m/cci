package com.zzp.cci.sort;

import java.util.Random;

/**
 * Created by zhenpeng on 10/20/16.
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }

    public void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public int partition(int[] arr, int l, int r) {
        int x = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= x) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
        /*       int i = l, j = r;
        int x = arr[l];
        while (i < j) {
            while (i < j && arr[j] > x) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] <= x) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = x;
        return i;*/
    }

    public int randomPartition(int[] arr, int l, int r) {
        Random random = new Random();
        int i = l + random.nextInt(r - l);
        swap(arr, i, r);
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
