package com.zzp.cci.sort;

/**
 * 计数排序是稳定的，附带卫星数据比较重要
 * <p>
 * 当所有的值都在0-k之间
 * 最佳 O(n)
 * 平均 O(n)
 * 最差 O(n)
 * <p>
 * 不是比较排序，根据数据实际值定位
 */
public class CountingSort {
    public void countingSort(int[] a, int k) {
        int[] output = new int[a.length];
        int[] counter = new int[k];
        // counter[i] count number of elements equals to i
        for (int j = 0; j < a.length; j++) {
            counter[a[j]]++;
        }
        // counter[i] counter number of elements less or equals to i
        for (int j = 1; j < k; j++) {
            counter[j] += counter[j - 1];
        }
        // set a[j] position to output
        for (int j = a.length - 1; j >= 0; j--) {
            output[counter[a[j]] - 1] = a[j];
            counter[a[j]]--;
        }
        System.arraycopy(output, 0, a, 0, a.length);
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
