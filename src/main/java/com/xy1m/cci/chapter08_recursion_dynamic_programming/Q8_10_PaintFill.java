package com.xy1m.cci.chapter08_recursion_dynamic_programming;

/**
 * Paint Fill: Implement the "paint fill" function that one might see on many image editing programs. That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding area until the color changes from the original color.
 */
public class Q8_10_PaintFill {

    public static void paintFill(int[][] colors, int y, int x, int dest) {
        int yLen = colors.length;
        if (yLen == 0) return;
        int xLen = colors[0].length;
        if (y < 0 || y >= yLen || x < 0 || x >= xLen) return;

        blankIfSameColor(colors, y, x, colors[y][x]);

        for (int n = 0; n < yLen; n++) {
            for (int m = 0; m < xLen; m++) {
                if (colors[n][m] == 2 << 8) {
                    colors[n][m] = dest;
                }
            }
        }
    }

    public static void blankIfSameColor(int[][] colors, int y, int x, int orginal) {
        int yLen = colors.length;
        if (yLen == 0) return;
        int xLen = colors[0].length;
        if (y < 0 || y >= yLen || x < 0 || x >= xLen) return;
        int current = colors[y][x];
        if (current != orginal) return;
        // blank
        colors[y][x] = 2 << 8;
        blankIfSameColor(colors, y - 1, x, orginal);
        blankIfSameColor(colors, y + 1, x, orginal);
        blankIfSameColor(colors, y, x - 1, orginal);
        blankIfSameColor(colors, y, x + 1, orginal);
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(String.format("%5s", matrix[i][j]));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // Assume there are 256 colors, then use ASCII code to represent a color, range [0,255]
        int[][] colors = {
                {1, 2, 4, 5, 5},
                {1, 5, 1, 3, 0},
                {1, 1, 1, 1, 5},
                {1, 2, 1, 5, 3},
                {1, 0, 5, 5, 5}
        };
        printMatrix(colors);
        paintFill(colors, 1, 2, 5);
        System.out.println("===== after =====");
        printMatrix(colors);
    }
}
