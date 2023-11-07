import java.util.*;

class Result {
    public static int countVerticalPaths(List<Integer> cost, int edgeNodes, List<Integer> edgeFrom, List<Integer> edgeTo, int k) {
        int[] freq = new int[k];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < edgeNodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeFrom.size(); i++) {
            adj.get(edgeFrom.get(i) - 1).add(edgeTo.get(i) - 1);
            adj.get(edgeTo.get(i) - 1).add(edgeFrom.get(i) - 1);
        }

        return dfs(0, -1, freq, cost, 0, k, adj);
    }

    public static int dfs(int u, int p, int[] freq, List<Integer> cost, int summ, int k, List<List<Integer>> adj) {
        summ += cost.get(u);
        summ %= k;

        int ans = freq[summ];

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
