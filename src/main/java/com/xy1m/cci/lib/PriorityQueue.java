package com.xy1m.cci.lib;

import com.xy1m.cci.util.Utils;

/**
 * Created by zhenpeng on 10/13/16.
 */
public class PriorityQueue {

    Heap heap = new Heap(new int[100]);

    public void insert(int x) {
        heap.size++;
        heap.data[heap.size - 1] = Integer.MIN_VALUE;
        increaseKey(heap.size - 1, x);
    }

    public int maximum() {
        if (heap.size < 1) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.data[0];
    }

    // O(lgn)
    public int extractMax() {
        if (heap.size < 1) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heap.data[0];
        heap.data[0] = heap.data[heap.size - 1];
        heap.size--;
        heap.maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int k) {
        if (k < heap.data[i]) {
            throw new RuntimeException("New key is smaller than current key");
        }
        heap.data[i] = k;
        while (i > 0 && heap.data[heap.parent(i)] < heap.data[i]) {
            Utils.swap(heap.data, i, heap.parent(i));
            i = heap.parent(i);
        }
    }
}
