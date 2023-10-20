package com.cg.havherrank;

import java.lang.Math;

class Result {
    public static int isPrime(long n) {
        // test for prime
        for (int i = 2; i <= (int)(Math.sqrt(n)) + 1; i++) {
            // if a divisor is found
            // return it
            if (n % i == 0) {
                return i;
            }
        }
        // no divisors found, so it is prime
        return 1;
    }
}
