package com.cg.havherrank;

import java.util.List;

class Result {

    public static int arraySum(List<Integer> numbers) {
        int ans = 0;
        for (int var : numbers) {
            ans = ans + var;
        }
        return ans;
    }
}
