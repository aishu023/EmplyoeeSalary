import java.util.List;
import java.util.ArrayList;

class Result {
    public static List<String> doesCircleExist(List<String> commands) {
        List<String> res = new ArrayList<>();
        for (String command : commands) {
            StringBuilder extendedCommand = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                extendedCommand.append(command);
            }
            int x = 0, y = 0;
            int dx = 0, dy = 1;
            for (char c : extendedCommand.toString().toCharArray()) {
                if (c == 'G') {
                    x += dx;
                    y += dy;
                } else if (c == 'L') {
                    int temp = dx;
                    dx = -dy;
                    dy = temp;
                } else { // c = 'R'
                    int temp = dx;
                    dx = dy;
                    dy = -temp;
                }
            }
            if (x == 0 && y == 0) {
                res.add("YES");
            } else {
                res.add("NO");
            }
        }
        return res;
    }
}
