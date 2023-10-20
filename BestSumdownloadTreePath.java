import java.util.*;

class Result {
    public static int bestSumDownwardTreePath(List<Integer> parent, List<Integer> values) {
        int n = values.size();
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i = 0; i < n; i++) {
            children.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int p = parent.get(i);
            if (p != -1) {
                children.get(p).add(i);
            }
        }
        int[] maxSum = new int[1];
        dfs(0, children, values, maxSum);
        return maxSum[0];
    }

    private static int dfs(int node, Map<Integer, List<Integer>> children, List<Integer> values, int[] maxSum) {
        int maxChildSum = 0;
        for (int child : children.get(node)) {
            int childSum = dfs(child, children, values, maxSum);
            maxChildSum = Math.max(maxChildSum, childSum);
        }
        maxSum[0] = Math.max(maxSum[0], values.get(node) + maxChildSum);
        return Math.max(values.get(node), values.get(node) + maxChildSum);
    }
}
