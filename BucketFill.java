class Result {

    /*
     * Complete the 'strokesRequired' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY picture as parameter.
     */
     static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static int strokesRequired(List<String> picture) {
       if (picture == null || picture.isEmpty()) {
            return 0;
        }

        int rows = picture.size();
        int columns = picture.get(0).length();
        boolean[][] visited = new boolean[rows][columns];
        int strokes = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (!visited[r][c]) {
                    strokes++;
                    dfs(picture, visited, r, c, picture.get(r).charAt(c));
                }
            }
        }

        return strokes;
}
     private static void dfs(List<String> picture, boolean[][] visited, int r, int c, char color) {
        int rows = picture.size();
        int columns = picture.get(0).length();

        if (r < 0 || r >= rows || c < 0 || c >= columns || visited[r][c] || picture.get(r).charAt(c) != color) {
            return;
        }

        visited[r][c] = true;
        dfs(picture, visited, r + 1, c, color); // Check south
        dfs(picture, visited, r - 1, c, color); // Check north
        dfs(picture, visited, r, c + 1, color); // Check east
        dfs(picture, visited, r, c - 1, color); // Check west
     }
}