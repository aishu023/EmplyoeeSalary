package com.cg.havherrank;

import java.util.List;
import java.util.stream.Collectors;

class Result {

    public static int slotWheels(List<String> history) {
        int n = history.size();
        for (int i = 0; i < n; i++) {
            List<Character> chars = history.get(i).chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            chars.sort(Character::compareTo);
            history.set(i, chars.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        int ans = 0;
        n = history.size();
        int m = history.get(0).length();
        for (int j = m - 1; j >= 0; j--) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                String str = history.get(i);
                curr = Math.max(curr, Character.getNumericValue(str.charAt(str.length() - 1)));
                history.set(i, str.substring(0, str.length() - 1));
            }
            ans += curr;
        }
        return ans;
    }
}
