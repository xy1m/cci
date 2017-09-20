package com.zzp.cci.lib;

import com.zzp.cci.util.Utils;

public class Heap {
    public int[] data;
    public int size;

    public Heap(int[] arr) {
        data = arr;
        size = arr.length;
    }

    public int parent(int i) {
        return i >> 1;
    }

    public int left(int i) {
        return i << 1;
    }

    public int right(int i) {
        return (i + 1) << 1;
    }

    /**
     * 时间复杂度 O(lgn)
     *
     * @param i
     */
    public void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largetst = i;
        if (l < size && data[i] < data[l]) {
            l = largetst;
        }
        if (l < size && data[largetst] < data[r]) {
            r = largetst;
        }
        if (largetst != i) {
            Utils.swap(data, i, largetst);
            maxHeapify(largetst);
        }
    }

    /**
     * 时间复杂度 O(n*lgn)
     */
    public void buildMap() {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * 时间复杂度 O(n*lgn)
     */
    public void sort() {
        for (int i = size - 1; i > 0; i--) {
            Utils.swap(data, i, 0);
            size--;
            maxHeapify(i);
        }
    }

}
