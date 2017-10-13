package com.zzp.leetcode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFiles {

    Map<Integer, Map<String, List<String>>> hashCache = new HashMap<>();
    Map<String, List<String>> contentCache = new HashMap<>();

    public List<List<String>> findDuplicate(String directory) {
        List<List<String>> result = new ArrayList<>();
        for (File file : files(directory)) {
            if (file.isDirectory()) {
                findDuplicate(file.getAbsolutePath());
            } else {
                build(file);
            }
        }
        for (Map.Entry<String, List<String>> entry : contentCache.entrySet()) {
            List<String> list = entry.getValue();
            if (list.size() > 1) {
                result.add(list);
            }
        }
        return result;
    }

    public File[] files(String directory) {
        File file = new File(directory);
        return file.listFiles();
    }

    public void build(File file) {
        String key = file.toString();
        String path = file.getPath();
        build(key, path);
    }

    public void build(String key, String path) {
        List<String> list;
        if (!contentCache.containsKey(key)) {
            list = new ArrayList<>();
            contentCache.put(key, list);
        } else {
            list = contentCache.get(key);
        }
        list.add(path);
    }

    public static void main(String[] args) {

    }
}
