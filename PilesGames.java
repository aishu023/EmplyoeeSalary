package com.cg.havherrank;

import java.util.List;

class Result {

    public static String gameOfPiles(List<Integer> piles, int k) {
        int nimSum = 0;
        for (int stones : piles) {
            nimSum ^= (stones / k) ^ (stones % k);
        }
        if (nimSum != 0) {
            return "Sam wins the game of " + piles.size() + " pile(s).";
        }
        return "Alex wins the game of " + piles.size() + " pile(s).";
    }
}
