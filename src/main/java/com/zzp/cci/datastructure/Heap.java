package com.zzp.cci.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenpeng on 10/13/16.
 */
public class Heap extends ArrayList<Integer> {
    public int heapSize;

    public Heap(List<Integer> data) {
        super(data);
        buildMaxHeap();
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
        int a = get(i);
        int b = get(j);
        set(i, b);
        set(j, a);
    }

    // lg(n);
    public void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && get(i) < get(l)) {
            largest = l;
        }
        if (r < heapSize && get(largest) < get(r)) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        heapSize = size();
        for (int i = (size() - 1) / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }
}
