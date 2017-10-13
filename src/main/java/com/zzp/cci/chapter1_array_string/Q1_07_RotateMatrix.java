package com.zzp.cci.chapter1_array_string;

/**
 * Created by zhenpeng on 8/9/17.
 */
public class Q1_07_RotateMatrix {

    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        Q1_07_RotateMatrix app = new Q1_07_RotateMatrix();
        app.rotate(matrix, 4);
        print(matrix);
    }

    public static void print(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                sb.append(matrix[row][col]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
