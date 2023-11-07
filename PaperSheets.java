
class Result {

    public static int computeFolds(long x, long y) {
        int folds = 0;
        while (y < x) {
            y = y * 2;
            folds += 1;
        }
        return folds;
    }

    public static int minMoves(long h, long w, long h1, long w1) {
        return computeFolds(h, h1) + computeFolds(w, w1);
    }
}
