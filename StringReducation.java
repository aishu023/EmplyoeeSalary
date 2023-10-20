package com.cg.havherrank;

import java.util.List;
import java.util.ArrayList;

class Result {

    public static int getMinIterations(List<Integer> arr) {
        int n = arr.size();
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int it = binarySearchRight(lis, arr.get(i));
            if (it == lis.size()) {
                lis.add(arr.get(i));
            } else {
                lis.set(it, arr.get(i));
            }
        }

        return (n - lis.size() + 1) / 2;
    }

    private static int binarySearchRight(List<Integer> lis, int target) {
        int left = 0;
        int right = lis.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
