package com.zzp.cci.chapter1_array_string;

/**
 * Created by zhenpeng on 8/21/17.
 */
public class Q1_8_Zero_Matrix {
    public void setZeros(int[][] matrix) {
        // BitOperation vector
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 0, 6, 8}, {3, 5, 0, 1}, {1, 2, 4, 5}};
        Q1_8_Zero_Matrix solution = new Q1_8_Zero_Matrix();
        solution.setZeros(matrix);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
