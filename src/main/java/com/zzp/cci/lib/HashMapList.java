package com.zzp.cci.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T, E> {
    private HashMap<T, ArrayList<E>> map = new HashMap<>();

    public void put(T key, E item) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(item);
    }

    public void put(T key, ArrayList<E> items) {
        map.put(key, items);
    }

    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    public boolean containsKeyValue(T key, E value) {
        ArrayList<E> list = get(key);
        if (list == null) return false;
        return list.contains(value);
    }

    public Set<T> keySet() {
        return map.keySet();
    }

    public Collection<ArrayList<E>> values() {
        return map.values();
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"0", "1", "22", "333"};
/*        HashMap<Integer, ArrayList<String>> mapList = new HashMap<>();
        for (String s : strings) {
            int val = s.length();
            if (!mapList.containsKey(val)) {
                mapList.put(val, new ArrayList<>());
            }
            mapList.get(val).add(s);
        }
        System.out.println(mapList);*/
        HashMapList<Integer, String> mapList = new HashMapList<>();
        for (String s : strings) {
            int key = s.length();
            mapList.put(key, s);
        }
        System.out.println(mapList);
    }

    public boolean equals(HashMapList item) {
        return false;
    }
}
