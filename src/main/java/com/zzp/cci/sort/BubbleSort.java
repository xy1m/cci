package com.zzp.cci.sort;

import com.zzp.cci.util.Utils;

/**
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * <p>
 * 最佳 O(n2)
 * 平均 O(n2)
 * 最坏 O(n2)
 * 空间 O(1)
 * <p>
 * 最坏需要 O(n2) 次交换
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = {13, 2, 1, 4, 8, 7, 6, 9, 0, 5};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
