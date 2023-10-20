package com.cg.havherrank;

class Result {
    public static int getMaxDeletions(String s) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'U') {
                y += 1;
            } else if (c == 'D') {
                y -= 1;
            } else if (c == 'L') {
                x -= 1;
            } else {
                x += 1;
            }
        }
        return s.length() - Math.abs(x) - Math.abs(y);
    }
}
