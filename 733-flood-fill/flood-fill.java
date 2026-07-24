class Solution {

    public void dfs(int[][] image, int row, int col,
                    int originalColor, int newColor) {

        if (row < 0 || col < 0 ||
            row >= image.length || col >= image[0].length ||
            image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, originalColor, newColor);
        dfs(image, row + 1, col, originalColor, newColor);
        dfs(image, row, col - 1, originalColor, newColor);
        dfs(image, row, col + 1, originalColor, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int originalColor = image[sr][sc];

        if (originalColor == newColor)
            return image;

        dfs(image, sr, sc, originalColor, newColor);

        return image;
    }
}