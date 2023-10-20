package com.cg.havherrank;

public static int countPairs(List<Integer> projectCosts, int target) {
    int count = 0;
    Set<Integer> projectCostSet = new HashSet<>(projectCosts);

    for (int cost : projectCostSet) {
        int diff1 = cost - target;
        int diff2 = cost + target;

        if (projectCostSet.contains(diff1)) {
            count++;
        }
        if (projectCostSet.contains(diff2)) {
            count++;
        }
    }

    return count / 2; // Each pair is counted twice
}