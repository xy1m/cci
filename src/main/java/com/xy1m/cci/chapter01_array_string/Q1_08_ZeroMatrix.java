package com.xy1m.cci.chapter01_array_string;

/**
 * Created by zhenpeng on 8/21/17.
 */
public class Q1_08_ZeroMatrix {
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param matrix
     */
    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param matrix
     */
    public static void setZerosInPlace(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                setRowZeros(matrix, i);
            }
        }
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                setColZeros(matrix, i);
            }
        }
        if (firstRowHasZero) {
            setRowZeros(matrix, 0);
        }
        if (firstColHasZero) {
            setColZeros(matrix, 0);
        }
    }

    public static void setRowZeros(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void setColZeros(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 6, 8},
                {3, 5, 0, 1},
                {1, 2, 4, 5}
        };
        //setZeros(matrix);
        //print(matrix);

        setZerosInPlace(matrix);
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
