package com.cg.havherrank;

import java.util.*;

class Result {
    public static int longestChain(List<String> words) {
        Map<String, Integer> dp = new HashMap<>();
        Map<Integer, Set<String>> buckets = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            dp.put(word, 1);
            buckets.putIfAbsent(length, new HashSet<>());
            buckets.get(length).add(word);
        }

        int globalMaxChain = 1;
        List<Integer> keys = new ArrayList<>(buckets.keySet());
        Collections.sort(keys);

        for (int length : keys) {
            if (!buckets.containsKey(length - 1)) {
                continue;
            }

            Set<String> currentWords = buckets.get(length);
            Set<String> smallerWords = buckets.get(length - 1);

            for (String word : currentWords) {
                int maxChain = 1;
                for (int i = 0; i < length; i++) {
                    String testWord = word.substring(0, i) + word.substring(i + 1);
                    if (smallerWords.contains(testWord)) {
                        maxChain = Math.max(dp.getOrDefault(testWord, 0) + 1, maxChain);
                    }
                }
                dp.put(word, maxChain);
                globalMaxChain = Math.max(globalMaxChain, maxChain);
            }
        }
        return globalMaxChain;
    }
}
