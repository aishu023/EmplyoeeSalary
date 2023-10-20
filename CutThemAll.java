class Result {

    /*
     * Complete the 'cutThemAll' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY lengths
     *  2. LONG_INTEGER minLength
     */

    public static String cutThemAll(List<Long> lengths, long minLength) {
    long mx = 0L;
        
        // find the length of the longest adjoining pair of sticks
        for (int i = 0; i < lengths.size() - 1; i++) {
            mx = Math.max(mx, lengths.get(i) + lengths.get(i+1));
        }
        
        // if there is a pair long enough to hold at the end
        if (mx >= minLength) {
            return "Possible";
        } else {
            return "Impossible";
        }

    }
}

