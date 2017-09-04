package com.zzp.cci.datastructure;

import java.util.ArrayList;

/**
 * Created by zhenpeng on 10/13/16.
 */
public class PriorityQueue {

    Heap data = new Heap(new ArrayList<Integer>());

    public void insert(int x) {
        data.heapSize++;
        if (data.heapSize >= data.size()) {
            data.add(Integer.MIN_VALUE);
        } else {
            data.set(data.heapSize - 1, Integer.MIN_VALUE);
        }
        increaseKey(data.heapSize - 1, x);
    }

    public int maximum() {
        if (data.heapSize < 1) {
            throw new RuntimeException("Heap is empty");
        }
        return data.get(0);
    }

    // lg(n)
    public int extractMax() {
        if (data.heapSize < 1) {
            throw new RuntimeException("Heap is empty");
        }
        int max = maximum();
        data.set(0, data.get(data.heapSize - 1));
        data.heapSize--;
        data.maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int k) {
        if (k < data.get(i)) {
            throw new RuntimeException("New key is smaller than current key");
        }
        data.set(i, k);
        while (i >= 0 && data.get(data.parent(i)) < data.get(i)) {
            data.swap(data.parent(i), i);
            i = data.parent(i);
        }
    }
}
