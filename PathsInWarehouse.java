
public static int numPaths(List<List<Integer>> warehouse) {
    int n = warehouse.size();
    int m = warehouse.get(0).size();
    int mod = 1000000007; // 10^9 + 7

    int[][] dp = new int[n][m];
    dp[0][0] = warehouse.get(0).get(0);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (warehouse.get(i).get(j) == 1) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= mod;
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= mod;
                }
            }
        }
    }

    return dp[n - 1][m - 1];
}
