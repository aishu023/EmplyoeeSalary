package com.cg.havherrank;


import java.util.*;

class DSU {
    int count;
    int[] parent;
    int[] height;

    public DSU(int n) {
        this.count = n;
        this.parent = new int[n];
        this.height = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.height[i] = 0;
        }
    }

    public int findRoot(int arr) {
        if (this.parent[arr] == arr) {
            return arr;
        }
        return this.findRoot(this.parent[arr]);
    }

    public void union(int arr, int B) {
        int C = this.findRoot(arr);
        int D = this.findRoot(B);
        if (C == D) {
            return;
        }
        if (this.height[C] < this.height[D]) {
            this.parent[C] = D;
        } else if (this.height[C] > this.height[D]) {
            this.parent[D] = C;
        } else {
            this.parent[D] = C;
            this.height[C] += 1;
        }
        this.count -= 1;
    }
}

class Result {
    public static List<Integer> findIndices(int n, List<List<Integer>> query) {
        DSU dsu = new DSU(n + 1);
        for (List<Integer> q : query) {
            assert q.get(0) <= q.get(1);
            dsu.union(q.get(0) - 1, q.get(1));
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (dsu.findRoot(i) == dsu.findRoot(i - 1)) {
                ans.add(i);
            }
        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
}
