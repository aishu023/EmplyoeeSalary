import java.util.*;

class Result {

    public static long getMinimumTime(int connectionNodes, List<Integer> connectionFrom, List<Integer> connectionTo, List<Integer> connectionWeight, List<Integer> deliveries) {
        assert 1 <= connectionNodes && connectionNodes <= 100000;
        int n = connectionNodes;
        int k = deliveries.size();
        assert 1 <= k && k <= 10;

        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < connectionFrom.size(); i++) {
            int from = connectionFrom.get(i);
            int to = connectionTo.get(i);
            int weight = connectionWeight.get(i);
            g.get(from).add(new int[]{to, weight});
            g.get(to).add(new int[]{from, weight});
        }

        Map<Integer, long[]> dis = new HashMap<>();
        for (int x : deliveries) {
            dis.put(x, new long[n]);
            Arrays.fill(dis.get(x), (long) 1e15);
        }
        dis.put(0, new long[n]);
        Arrays.fill(dis.get(0), (long) 1e15);

        for (int s : deliveries) {
            dis.get(s)[s] = 0;
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
            pq.add(new long[]{0, s});
            while (!pq.isEmpty()) {
                long[] tp = pq.poll();
                if (dis.get(s)[(int) tp[1]] < tp[0]) {
                    continue;
                }
                for (int[] child : g.get((int) tp[1])) {
                    int ch = child[0];
                    int w = child[1];
                    if (dis.get(s)[ch] > tp[0] + w) {
                        dis.get(s)[ch] = tp[0] + w;
                        pq.add(new long[]{dis.get(s)[ch], ch});
                    }
                }
            }
        }

        deliveries.remove(0);
        Collections.sort(deliveries);

        long ans = (long) 1e15;
        List<List<Integer>> ps = new ArrayList<>();
        permutation(ps, deliveries, new ArrayList<>());
        for (List<Integer> p : ps) {
            long val = 0;
            int pv = 0;
            for (int d : p) {
                val += dis.get(pv)[d];
                pv = d;
            }
            val += dis.get(pv)[0];
            ans = Math.min(ans, val);
        }

        if (ans == (long) 1e15) {
            ans = -1;
        }

        return ans;
    }

    public static void permutation(List<List<Integer>> result, List<Integer> deliveries, List<Integer> tempList) {
        if (tempList.size() == deliveries.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < deliveries.size(); i++) {
                if (tempList.contains(deliveries.get(i))) {
                    continue;
                }
                tempList.add(deliveries.get(i));
                permutation(result, deliveries, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
