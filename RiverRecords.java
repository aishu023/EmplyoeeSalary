package com.cg.havherrank;

class Result {

    /*
     * Complete the 'maxTrailing' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

   public static int maxTrailing(List<Integer> arr) {
    int n = arr.size();
    int maxDiff = -1;
    int minVal = arr.get(0);

    for (int i = 1; i < n; i++) {
        if (arr.get(i) < minVal) {
            minVal = arr.get(i);
        } else {
            int diff = arr.get(i) - minVal;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
    }

    return maxDiff >= 0 ? maxDiff : -1;
}


}


