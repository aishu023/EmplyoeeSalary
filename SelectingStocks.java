
import java.util.List;

class Result {
    public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
        int n = currentValue.size();
        int[] dp = new int[saving + 1]; // dp[i] = Maximum profit if we utilize at most i savings.
        for (int i = 0; i < n; i++) {
            int profit = futureValue.get(i) - currentValue.get(i);
            int weight = currentValue.get(i);
            if (profit > 0) {
                for (int j = saving; j >= 0; j--) {
                    if (j + weight <= saving) {
                        dp[j + weight] = Math.max(dp[j + weight], dp[j] + profit);
                    }
                }
            }
        }
        return dp[saving];
    }
}
