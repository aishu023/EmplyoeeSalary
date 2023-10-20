import java.util.*;

class Result {

    /*
     * Complete the 'reachTheEnd' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER maxTime
     */

    public static String reachTheEnd(List<String> grid, int maxTime) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] maze = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            maze[i] = grid.get(i).toCharArray();
        }

        // Use BFS to explore the grid
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, maxTime});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];

            if (row < 0 || col < 0 || row >= rows || col >= cols || maze[row][col] == '#') {
                continue;
            }

            if (row == rows - 1 && col == cols - 1) {
                return "Yes";
            }

            if (time > 0) {
                maze[row][col] = '#';
                queue.add(new int[]{row + 1, col, time - 1});
                queue.add(new int[]{row - 1, col, time - 1});
                queue.add(new int[]{row, col + 1, time - 1});
                queue.add(new int[]{row, col - 1, time - 1});
            }
        }

        return "No";
    }
}
