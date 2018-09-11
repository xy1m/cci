package com.xy1m.cci.sort;

import com.xy1m.cci.util.Utils;

/**
 * 首先，在所有未排序的序列中找到最小元素，存放到排序序列起始位置，
 * 然后，从未排序序列中寻找最小元素，放到已排序序列末尾
 * 以此类推，直到所有元素排序完毕
 * <p>
 * 最佳 O(n^2)
 * 平均 O(n^2)
 * 最差 O(n^2)
 * 空间 O(1)
 * <p>
 * 优点：移动元素相关，最多进行n-1次元素移动
 * 适合：数据移动成本比较高的操作
 */
public class SelectionSort {
    public void selectionSort(int[] arr) {
        int len = arr.length;
        int min;
        for (int i = 0; i < len - 1; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            Utils.swap(arr, i, min);
        }
    }

    public static void main(String args[]) {
        int[] arr = {13, 2, 1, 4, 8, 7, 6, 9, 0, 5};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
