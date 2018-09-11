package com.zzp.cci.sort;

/**
 * 基数排序根据最低有效位进行排序
 */
public class RadixSort {
    public void radixSort(int[] arr) {
        // use stable sort to sort chapter01_array_string arr on digit i
        for (int i = 0; i < 3; i++) {
            countingSort(arr, i, 10);
        }
    }

    public void countingSort(int[] arr, int i, int k) {
        // use stable sort to sort chapter01_array_string arr on digit i
        int[] output = new int[arr.length];
        int[] counter = new int[k];
        for (int j = 0; j < arr.length; j++) {
            counter[digitOfNumber(arr[j], i)]++;
        }
        for (int j = 1; j < k; j++) {
            counter[j] += counter[j - 1];
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            output[counter[digitOfNumber(arr[j], i)] - 1] = arr[j];
            counter[digitOfNumber(arr[j], i)]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }


    public int digitOfNumber(int num, int digit) {
        int base = 1;
        for (int j = 0; j < digit; j++) {
            base *= 10;
        }
        return (num / base) % 10;
    }

    public static void main(String args[]) {
        int[] arr = {311, 256, 302, 198, 197, 302, 864, 911, 730, 266, 521, 907, 102};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
