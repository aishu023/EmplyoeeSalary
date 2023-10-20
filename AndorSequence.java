
public static Return findSequence(long x, long y) {
    long mod = (long)1e9 + 7;
    long count = 1;
    ArrayList <Long> ret = new ArrayList <>();
    int bitx = bitcount(x);
    int bity = bitcount(y);
    for (int i = bitx; i <= bity; i++) {
        long low = Math.max(1l << (i - 1), x);
        long high = Math.min((1l << i) - 1, y);
        count = (count * ((high - low + 1) % mod)) % mod;
        ret.add(high);
    }
    Return ans = new Return((int)count, ret);
    return ans;
}
public static int bitcount(long x) {
    int count = 0;
    while (x > 0) {
        count++;
        x /= 2;
    }
    return count;
}

    
}
