import java.util.*;

class Result {

    public static List<Integer> getMinSumNodeValues(int serviceNodes, List<Integer> serviceFrom, List<Integer> serviceTo, int k, List<List<Integer>> currentValues) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= serviceNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // Building the adjacency list
        for (int i = 0; i < serviceFrom.size(); i++) {
            int from = serviceFrom.get(i);
            int to = serviceTo.get(i);
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // Priority queue to store nodes and their values
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        // Adding initial values to priority queue and visited set
        for (int i = 0; i < k; i++) {
            List<Integer> vertexValue = currentValues.get(i);
            int vertex = vertexValue.get(0);
            int value = vertexValue.get(1);
            pq.add(new int[]{vertex, -value});
            visited.add(vertex);
        }

        // Array to store the result values
        int[] resultValues = new int[serviceNodes + 1];

        // Processing the priority queue
        while (!pq.isEmpty()) {
            int[] vData = pq.poll();
            int v = vData[0];
            int vValue = -vData[1];
            resultValues[v] = vValue;

            // Processing neighbors of the current node
            List<Integer> neighbors = adjList.get(v);
            for (int u : neighbors) {
                if (!visited.contains(u)) {
                    pq.add(new int[]{u, -resultValues[v] + 1});
                    visited.add(u);
                }
            }
        }

        // Converting the result array to a list
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= serviceNodes; i++) {
            result.add(resultValues[i]);
        }
        return result;
    }
}
