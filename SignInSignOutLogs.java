package com.cg.havherrank;

import java.util.*;

class Result {
    public static List<String> processLogs(List<String> logs, int maxSpan) {
        Map<Integer, Integer> signInTimes = new HashMap<>();
        Map<Integer, Integer> signOutTimes = new HashMap<>();

        for (String log : logs) {
            String[] logParts = log.split(" ");
            int user = Integer.parseInt(logParts[0]);
            int time = Integer.parseInt(logParts[1]);
            String action = logParts[2];
            if (action.equals("sign-in")) {
                signInTimes.put(user, time);
            } else {
                signOutTimes.put(user, time);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : signOutTimes.entrySet()) {
            int user = entry.getKey();
            if (signInTimes.containsKey(user) && entry.getValue() - signInTimes.get(user) <= maxSpan) {
                ansList.add(user);
            }
        }

        Collections.sort(ansList);
        List<String> ans = new ArrayList<>();
        for (int x : ansList) {
            ans.add(String.valueOf(x));
        }
        return ans;
    }
}
