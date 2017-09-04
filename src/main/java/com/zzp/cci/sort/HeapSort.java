package com.zzp.cci.sort;

public class HeapSort {
    int[] heap;
    int size;

    public int parent(int i) {
        return (i - 1) >> 1;
    }

    public int left(int i) {
        return (i << 1) + 1;
    }

    public int right(int i) {
        return (i + 1) << 1;
    }

    public void swap(int i, int j) {
        if (heap[i] != heap[j]) {
            heap[i] ^= heap[j];
            heap[j] ^= heap[i];
            heap[i] ^= heap[j];
        }
    }


    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && heap[l] > heap[i]) {
            largest = l;
        }
        if (r < size && heap[r] > heap[largest]) {
            largest = r;
        }
        if (i != largest) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void buildHeap() {
        for (int i = (size - 1) >> 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void heapSort(int[] arr) {
        this.heap = arr;
        size = heap.length;
        buildHeap();
        for (int i = size - 1; i > 0; i--) {
            swap(i, 0);
            size--;
            heapify(0);
        }
    }

    public static void main(String args[]) {
        HeapSort hs = new HeapSort();
        int[] arr = {3, 2, 1, 4, 8, 7, 6, 9, 0, 5};
        hs.heapSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
