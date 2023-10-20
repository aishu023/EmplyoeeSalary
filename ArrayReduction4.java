package com.cg.havherrank;

import java.util.*;

class Result {
    /*
     * Complete the 'getMaxArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> getMaxArray(List<Integer> arr) {
        int n = arr.size();
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            stacks.get(arr.get(i)).push(i);
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            for (int k = 0; k <= n; k++) {
                while (!stacks.get(k).isEmpty()) {
                    int val = stacks.get(k).pop();
                    if (val >= i) {
                        j = Math.max(j, val);
                        break;
                    }
                }
                if (stacks.get(k).isEmpty()) {
                    result.add(k);
                    break;
                }
            }
            i = j + 1;
        }
        return result;
    }
}




def getMaxArray(arr):
    n = len(arr)
    stacks = [[] for i in range(0, n + 1)]

    for i in range(n - 1, -1, -1):
        stacks[arr[i]].append(i)

    result = []
    i = 0
    while i < n:
        j = i
        for k in range(n + 1):
            while stacks[k]:
                val = stacks[k].pop()
                if val >= i:
                    j = max(j, val)
                    break
            else:
                result.append(k)
                break
        i = j + 1
    return result