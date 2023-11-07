
import java.util.List;

class Result {

    public static int countWaysToCreateWave(List<Integer> arr, int m) {
        int n = arr.size();
        int mod = (int) (Math.pow(10, 9) + 7);
        int[][][] dp = new int[2][m + 1][2];
        int k = 0;
        int l = 1;
        for (int j = 1; j <= m; j++) {
            if (arr.get(k) == j || arr.get(k) == -1) {
                dp[k][j][1] = 1;
                dp[k][j][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[k][j][0] = (dp[k][j - 1][0] + dp[k][j][0]) % mod;
                dp[k][j][1] = (dp[k][j - 1][1] + dp[k][j][1]) % mod;
            }
            for (int j = 1; j <= m; j++) {
                if (arr.get(i) == j || arr.get(i) == -1) {
                    dp[l][j][1] = ((dp[k][m][0] - dp[k][j][0]) % mod + mod) % mod;
                    dp[l][j][0] = dp[k][j - 1][1];
                } else {
                    dp[l][j][0] = 0;
                    dp[l][j][1] = 0;
                }
            }
            int temp = k;
            k = l;
            l = temp;
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[k][i][0]) % mod;
            ans = (ans + dp[k][i][1]) % mod;
        }
        return ans;
    }
}
