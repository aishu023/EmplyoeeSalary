import java.util.ArrayList;
import java.util.List;

class Result {

    public static List<String> checkDivisibility(List<String> arr) {
        List<String> results = new ArrayList<>();
        for (String num : arr) {
            if (isDivisibleBy8(num)) {
                results.add("YES");
            } else {
                results.add("NO");
            }
        }
        return results;
    }

    private static boolean isDivisibleBy8(String num) {
        int n = num.length();
        if (n == 1) {
            return (num.charAt(0) - '0') % 8 == 0;
        }
        if (n == 2) {
            int val = Integer.parseInt(num);
            int reverseVal = Integer.parseInt("" + num.charAt(1) + num.charAt(0));
            return val % 8 == 0 || reverseVal % 8 == 0;
        }

        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }

        for (int i = 104; i < 1000; i += 8) {
            int x = i;
            int[] currentCount = new int[10];
            for (int j = 0; j < 3; j++) {
                currentCount[x % 10]++;
                x /= 10;
            }
            boolean possible = true;
            for (int j = 0; j < 10; j++) {
                if (currentCount[j] > count[j]) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                return true;
            }
        }
        return false;
    }
}
