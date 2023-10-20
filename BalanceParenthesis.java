package com.cg.havherrank;

class Result {
    public static int minimumSwaps(String brackets) {
        int depth = 0;
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < brackets.length(); i++) {
            char c = brackets.charAt(i);
            if (c == '(') {
                depth += 1;
                cur += 1;
            } else {
                cur -= 1;
                if (depth > 0) {
                    depth -= 1;
                } else {
                    ans += 1;
                    depth += 1;
                }
            }
        }
        if (cur != 0) {
            return -1;
        }
        return ans;
    }
}
