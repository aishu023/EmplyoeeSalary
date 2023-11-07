class Result {

    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY projectCosts
     *  2. INTEGER target
     */

   
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

}

