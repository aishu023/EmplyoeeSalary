
class Result {
    public static int getMinMoves(String s) {
        int n = s.length();
        long inf = 10000000000L;

        long[][] dp_good = new long[n][26];
        long[][] dp_bad = new long[n][26];

        // Base case
        for (int c = 0; c < 26; c++) {
            dp_bad[0][c] = Math.abs(s.charAt(0) - 'a' - c);
        }

        // General case
        for (int i = 1; i < n; i++) {
            long prev_best = inf;
            for (int c = 0; c < 26; c++) {
                prev_best = Math.min(prev_best, dp_good[i - 1][c]);
            }
            for (int c = 0; c < 26; c++) {
                dp_good[i][c] = Math.min(dp_bad[i - 1][c], dp_good[i - 1][c]);
                dp_good[i][c] += Math.abs((s.charAt(i) - 'a') - c);
                dp_bad[i][c] = prev_best + Math.abs(s.charAt(i) - 'a' - c);
            }
        }

        long ans = inf;
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, dp_good[n - 1][i]);
        }

        return (int) ans;
    }
}
