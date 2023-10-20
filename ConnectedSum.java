import java.util.ArrayList;
import java.util.List;

class Result {

    static int MAX = 100005;
    static List<List<Integer>> v = new ArrayList<>(MAX);
    static boolean[] visited = new boolean[MAX];

    static int getConnectedComponentSize(int x) {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(x);
        visited[x] = true;
        int cnt = 0;
        while (nodes.size() > 0) {
            x = nodes.remove(nodes.size() - 1);
            cnt += 1;
            for (int y : v.get(x)) {
                if (!visited[y]) {
                    visited[y] = true;
                    nodes.add(y);
                }
            }
        }
        return cnt;
    }

    public static int connectedSum(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo) {
        for (int i = 0; i < MAX; i++) {
            v.add(new ArrayList<>());
        }
        for (int i = 0; i < graphFrom.size(); i++) {
            int x = graphFrom.get(i);
            int y = graphTo.get(i);
            v.get(x).add(y);
            v.get(y).add(x);
        }

        int ans = 0;
        for (int node = 1; node <= graphNodes; node++) {
            if (!visited[node]) {
                int cnt = getConnectedComponentSize(node);
                ans += Math.ceil((Math.sqrt(cnt)));
            }
        }
        return ans;
    }
}
