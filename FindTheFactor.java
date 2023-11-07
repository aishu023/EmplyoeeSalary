class Result {

    /*
     * Complete the 'pthFactor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER n
     *  2. LONG_INTEGER p
     */

   
public static long pthFactor(long n, long p) {
    List<Long> factors = new ArrayList<>();
    
    for (long i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            factors.add(i);
            if (i * i != n) {
                factors.add(n / i);
            }
        }
    }
    
    Collections.sort(factors);
    
    if (p > factors.size()) {
        return 0;
    }
    
    return factors.get((int) p - 1);
}





}

