package com.cg.havherrank;

class Result {

    public static int getMinOperations(String series) {
        int n = series.length();
        int inf = Integer.MAX_VALUE;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][n] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 1 + dp[i + 1][j];
                if (series.charAt(i) == series.charAt(i + 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                }
                for (int k = i + 2; k <= j; k++) {
                    if (series.charAt(i) == series.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
