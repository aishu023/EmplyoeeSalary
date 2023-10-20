
class Result {
    public static long findMaximumProfit(List<Integer> category, List<Integer> price) {
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < price.size(); i++) {
            temp.add(new int[]{price.get(i), category.get(i)});
        }

        temp.sort(Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> vis = new HashMap<>();
        long ans = 0;
        int numCategories = (int) category.stream().distinct().count();

        for (int[] item : temp) {
            int p = item[0];
            int c = item[1];
            if (!vis.containsKey(c) || vis.get(c) == 0) {
                vis.put(c, 1);
                ans += vis.size() * p;
            } else {
                ans += numCategories * p;
            }
        }
        return ans;
    }
}









def findMaximumProfit(category, price):
    temp = [[price[i], category[i]] for i in range(len(price))]
    temp.sort()
    vis = {}
    ans = 0
    num_categories = len(set(category))
    
    for [p, c] in temp:
        if vis.get(c, 0) == 0:
            vis[c] = 1
            ans += len(vis) * p
        else:
            ans += num_categories * p
    return ans