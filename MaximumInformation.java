import java.util.List;

 class Result {
    public static int gainMaxValue(List<Integer> security_val, int k) {
        if(security_val == null || security_val.isEmpty() || k <= 0) {
            return 0; // Return 0 or handle the error as per the requirement
        }

        int n = security_val.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int max_value_from_i = security_val.get(i);
            if (i + k < n) {
                max_value_from_i += dp[i + k];
            }
            dp[i] = max_value_from_i;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
