
class Result {
    public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
        int n = magic.size();
        for (int i = 0; i < n; i++) {
            int magicSum = 0;
            int j;
            for (j = 0; j < n; j++) {
                int idx = (i + j) % n;
                magicSum += magic.get(idx) - dist.get(idx);
                if (magicSum < 0) break;
            }
            if (j == n) return i;
        }
        return -1;
    }
}