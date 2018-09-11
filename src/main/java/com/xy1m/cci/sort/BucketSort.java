package com.zzp.cci.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhenpeng on 10/25/16.
 */
public class BucketSort {
    public void bucketSort(float[] a) {
        List<LinkedList<Float>> b = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            b.add(new LinkedList<>());
        }
        for (int i = 0; i < n; i++) {
            b.get((int) (n * a[i])).add(a[i]);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(b.get(i));
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (!b.get(i).isEmpty()) {
                for (float j : b.get(i)) {
                    a[index++] = j;
                }
            }
        }
    }

    public static void main(String args[]) {
        float[] arr = {0.31f, 0.31f, 0.24f, 0.01f, 0.89f, 0.13f, 0.24f, 0.73f};
        BucketSort bs = new BucketSort();
        bs.bucketSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
