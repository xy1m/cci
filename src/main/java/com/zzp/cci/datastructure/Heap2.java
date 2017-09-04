package com.zzp.cci.datastructure;

import java.util.Comparator;

/**
 * Created by zhenpeng on 10/17/16.
 */
public class Heap2<T extends Comparable<T>> {
    private int capcity = 2;
    private T[] heap;
    private int size;
    private Comparator<T> comparator;
    private boolean isMaxHeap = true;

    public Heap2(T[] array, boolean max) {
        this.size = array.length;
        this.heap = array;
        this.isMaxHeap = max;
        this.comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return isMaxHeap ? o1.compareTo(o2) : o2.compareTo(o1);
            }
        };
        buildHeap();
    }

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
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && comparator.compare(heap[l], heap[i]) > 0) {
            largest = l;
        }
        if (r < size && comparator.compare(heap[r], heap[largest]) > 0) {
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

    public void sort() {
        for (int i = size - 1; i > 0; i--) {
            swap(i, 0);
            size--;
            heapify(0);
        }
    }
}
