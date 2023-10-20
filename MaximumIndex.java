package com.cg.havherrank;

class Result {

    public static int maxIndex(int steps, int badIndex) {
        int i = 0, j = 1;
        for (int k = 0; k < steps; k++) {
            if (i + j == badIndex) {
                i -= 1;
            }
            i += j;
            j += 1;
        }
        return i;
    }
}
