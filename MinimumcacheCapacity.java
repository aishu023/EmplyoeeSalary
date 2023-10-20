class Result {

    /*
     * Complete the 'getMinimumSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY requests
     *  2. INTEGER k
     */

   public static int getMinimumSize(List<String> requests, int k) {
       int n = requests.size();
        int lo = 1, hi = n, ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int cnt = 0;
            Map<String, Integer> last = new HashMap<>();
            PriorityQueue<String[]> cache = new PriorityQueue<>((a, b) -> Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0])));
            Map<String, Integer> in_cache = new HashMap<>();
            int hit = 0;

            for (String x : requests) {
                cnt++;
                if (in_cache.getOrDefault(x, 0) == 1) {
                    hit++;
                    last.put(x, cnt);
                    cache.add(new String[]{last.get(x).toString(), x});
                } else {
                    if (in_cache.size() < mid) {
                        in_cache.put(x, 1);
                        last.put(x, cnt);
                        cache.add(new String[]{last.get(x).toString(), x});
                    } else {
                        while (!cache.isEmpty() && Integer.parseInt(cache.peek()[0]) != last.getOrDefault(cache.peek()[1], -1)) {
                            cache.poll();
                        }
                        in_cache.put(cache.peek()[1], 0);
                        cache.poll();
                        last.put(x, cnt);
                        in_cache.put(x, 1);
                        cache.add(new String[]{last.get(x).toString(), x});
                    }
                }
            }

            if (hit >= k) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;

    }

}

