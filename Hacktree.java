import java.util.*;

class Result {

    public static int countVerticalPaths(List<Integer> cost, int edgeNodes, List<Integer> edgeFrom, List<Integer> edgeTo, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < edgeNodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeFrom.size(); i++) {
            int from = edgeFrom.get(i) - 1;
            int to = edgeTo.get(i) - 1;
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        int[] freq = new int[k];
        Arrays.fill(freq, 0);
        freq[0] = 1;

        return dfs(0, -1, freq, cost, 0, k, adj);
    }

    private static int dfs(int u, int p, int[] freq, List<Integer> cost, int summ, int k, List<List<Integer>> adj) {
        int ans = 0;
        summ += cost.get(u);
        summ %= k;

        ans = freq[summ];
        freq[summ] += 1;

        for (int v : adj.get(u)) {
            if (v != p) {
                ans += dfs(v, u, freq, cost, summ, k, adj);
            }
        }
        freq[summ] -= 1;
        return ans;
    }
}
