package com.xy1m.cci.sort;

/**
 * 是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点
 * 最佳 O(n*lgn)
 * 平均 O(n*lgn)
 * 最差 O(n*lgn)
 * 空间 O(1) in-place
 */
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
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < size && heap[left] > heap[i]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
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
