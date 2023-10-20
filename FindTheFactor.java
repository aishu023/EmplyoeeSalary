
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



