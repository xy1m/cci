package com.zzp.cci.sort;

public class InsertionSort {

    public void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int i = j - 1;
            int key = arr[j];
            while (i > 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    public static void main(String args[]) {
        InsertionSort is = new InsertionSort();
        int[] arr = {3, 2, 1, 4, 8, 7, 6, 9, 0, 5};
        is.insertionSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
