package com.xy1m.cci.sort;

import com.xy1m.cci.util.Utils;

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
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] < pivot) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = pivot;
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
