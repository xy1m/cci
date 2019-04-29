package com.xy1m;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    Solution() {
    }

    Map<String, Set<String>> query2userMap = new HashMap<>();
    Map<String, Set<String>> user2queryMap = new HashMap<>();

    public void add2map(Map<String, Set<String>> map, String key, String value) {
        if (!map.containsKey(key)) {
            Set<String> set = new HashSet<>();
            map.put(key, set);
        }
        map.get(key).add(value);
    }

    public List<String> getMostCommonQueries(String excludeQuery, Set<String> users) {
        List<String> res = new ArrayList<>();
        int maxCount = 0;
        Map<String, Integer> queryCounter = new HashMap<>();
        for (String user : users) {
            for (String query : user2queryMap.get(user)) {
                if (query.equals(excludeQuery)) {
                    continue;
                }
                int currentCount = queryCounter.getOrDefault(query, 0);
                int newCount = currentCount + 1;
                maxCount = Math.max(maxCount, newCount);
                queryCounter.put(query, newCount);
            }
        }
        for (Map.Entry<String, Integer> entry : queryCounter.entrySet()) {
            if (entry.getValue().equals(maxCount)) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }

    public void printResult(int score, List<String> mostCommonQueries) {
        if (mostCommonQueries.isEmpty()) {
            System.out.println(0);
        } else {
            StringJoiner stringJoiner = new StringJoiner(" ");
            mostCommonQueries.forEach(i -> stringJoiner.add(i));
            System.out.println(score + " " + stringJoiner.toString());
        }
    }


    public void handleUserQuery(String user, String query) {
        if (!query2userMap.containsKey(query)) {
            System.out.println(0);
        } else {
            Set<String> usersMadeThisQuery = query2userMap.get(query);
            usersMadeThisQuery.remove(user);
            int score = usersMadeThisQuery.size();
            List<String> mostCommonQueries = getMostCommonQueries(query, usersMadeThisQuery);
            printResult(score, mostCommonQueries);
        }
        add2map(query2userMap, query, user);
        add2map(user2queryMap, user, query);
    }

    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(input.nextLine());
        Solution solution = new Solution();
        for (int i = 0; i < numberOfLines; i++) {
            String user = input.next();
            String query = input.next();
            solution.handleUserQuery(user, query);
        }
    }
}