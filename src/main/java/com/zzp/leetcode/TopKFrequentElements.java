package com.zzp.leetcode;

import java.util.*;

/**
 * Created by zhenpeng on 10/17/16.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>(k);
        // counter
        Map<Integer, int[]> counter = new HashMap<Integer, int[]>();
        for (int i : nums) {
            int[] wrapper = counter.get(i);
            if (wrapper == null) {
                counter.put(i, new int[1]);
            } else {
                counter.get(i)[0]++;
            }
        }
        // counter list
        Pair[] arr = new Pair[counter.size()];
        int index = 0;
        for (Map.Entry<Integer, int[]> entry : counter.entrySet()) {
            arr[index++] = new Pair(entry.getKey(), entry.getValue()[0]);
        }
        // heap sort
        Heap<Pair> heap = new Heap<Pair>(arr);
        heap.sort();
        for (int i = 0; i < k; i++) {
            result.add(arr[i].key);
        }
        return result;
    }
}

class Pair implements Comparable<Pair> {
    public Integer key;
    public Integer value;

    public Pair(Integer k, Integer v) {
        key = k;
        value = v;
    }

    @Override
    public int compareTo(Pair o) {
        return o.value.compareTo(this.value);
    }
}

class Heap<T extends Comparable> {
    private T[] data;
    private int size;
    private Comparator<T> comparator = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    };

    public Heap(T[] array) {
        this.size = array.length;
        this.data = array;
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
        T tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int k = i;
        if (l < size && comparator.compare(data[l], data[i]) > 0) {
            k = l;
        }
        if (r < size && comparator.compare(data[r], data[k]) > 0) {
            k = r;
        }
        if (i != k) {
            swap(i, k);
            heapify(k);
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