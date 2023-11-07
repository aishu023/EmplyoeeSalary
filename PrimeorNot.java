import java.lang.Math;

class Result {
    public static int isPrime(long n) {
        if (n < 2) {
            return 0; // 0 and 1 are not prime
        }
        // test for prime
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
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
