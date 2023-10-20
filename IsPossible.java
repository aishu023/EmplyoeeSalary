class Result {

    /*
     * Complete the 'isPossible' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     *  3. INTEGER c
     *  4. INTEGER d
     */

   public static String isPossible(int a, int b, int c, int d) {
    if (a == c && b == d) {
            return "Yes";
        }

        if (a + b <= 1000 && "Yes".equals(isPossible(a + b, b, c, d))) {
            return "Yes";
        }
        if (a + b <= 1000 && "Yes".equals(isPossible(a, a + b, c, d))) {
            return "Yes";
        }

      
        return "No";
   }

}

