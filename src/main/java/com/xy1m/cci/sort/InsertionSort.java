package com.xy1m.cci.sort;

/**
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * 反复把已排序元素向后挪位，为新元素提供空间
 * <p>
 * 最佳 O(n) 序列升序
 * 平均 O(n^2) 序列降序
 * 最坏 O(n^2)
 * 空间 O(1)
 * <p>
 * 适合 数据量很小，小于K， STL中stdlib中的qsort，数量8个以下
 * 不适合 数据量大
 */
public class InsertionSort {

    public void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int i = j - 1;
            int key = arr[j];
            /*
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            */
            for (; i >= 0 && arr[i] > key; i--) {
                arr[i + 1] = arr[i];
            }
            arr[i + 1] = key;
        }
    }

    public static void main(String args[]) {
        int[] arr = {13, 2, 1, 4, 8, 7, 6, 9, 0, 5};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
