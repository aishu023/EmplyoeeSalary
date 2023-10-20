import java.util.*;

class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder answer = new StringBuilder();
            if (i % 3 == 0) {
                answer.append("Fizz");
            }
            if (i % 5 == 0) {
                answer.append("Buzz");
            }
            if (answer.length() == 0) {
                answer.append(i);
            }
            System.out.println(answer.toString());
        }
    }

}
