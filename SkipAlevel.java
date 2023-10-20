package com.cg.havherrank;

public static int maximumPoints(int k, List<Integer> costs) {
    int mx = 0;
    int sum = 0;
    int ans = 0;

    if (costs.stream().mapToInt(Integer::intValue).sum() <= k) {
        return costs.size();
    }

    for (int i = 0; i < costs.size(); i++) {
        int val = costs.get(i);
        mx = Math.max(mx, val);
        sum += val;
        if (sum - mx <= k) {
            ans = i;
        }
    }

    return ans + 1;
}





def maximumPoints(k, costs):
    # Write your code here

    mx = 0
    summ = 0
    ans = 0
    
    if sum(costs) <= k:
        return len(costs)
    
    for idx, val in enumerate(costs):
        mx = max(mx, val)
        summ += val
        if summ - mx <= k:
            ans  = idx

    return ans