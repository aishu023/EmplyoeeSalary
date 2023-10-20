package com.cg.havherrank;

import java.io.*;
import java.util.*;

class Result {
    public static int countPalindromes(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n; i++) {
                int j = i + gap;
                if (j >= n) {
                    continue;
                }
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
