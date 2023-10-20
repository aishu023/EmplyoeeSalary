  public static int maxXor(int lo, int hi, int k) {
    // Write your code here
      IntBinaryOperator xor = (a, b) -> a ^ b;
        int mx = 0;
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                int xorValue = xor.applyAsInt(i, j);
                if (mx < xorValue && xorValue <= k) {
                    mx = xorValue;
                    if (mx == k) {
                        break;
                    }
                }
            }
            if (mx == k) {
                break;
            }
        }
        return mx;

}