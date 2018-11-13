package com.xy1m.cci.chapter16_moderate;

import java.util.ArrayList;
import java.util.List;

/**
 * Pond Sizes: You have an integer matrix representing a plot of land, where the value at that location represents the height above sea level. A value of zero indicates water. A pond is a region of water connected vertically, horizontally, or diagonally. The size of the pond is the total number of connected water cells. Write a method to compute the sizes of all ponds in the matrix.
 */
public class Q16_19_PondSizes {
    List<Integer> computePondSizes(int[][] land) {
        List<Integer> pondSizes = new ArrayList<>();
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                if (land[row][col] == 0) {
                    pondSizes.add(computeSize(land, row, col));
                }
            }
        }
        return pondSizes;
    }

    int computeSize(int[][] land, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[0].length || land[row][col] != 0) {
            return 0;
        }
        int size = 1;
        land[row][col] = -1;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computeSize(land, row + dr, col + dc);
            }
        }
        return size;
    }

    List<Integer> computePondSizesWithoutModification(int[][] land) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                int size = computeSize(land, visited, row, col);
                if (size > 0) result.add(size);
            }
        }
        return result;
    }

    int computeSize(int[][] land, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[0].length || visited[row][col] || land[row][col] != 0) {
            return 0;
        }
        int size = 1;
        visited[row][col] = true;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                size += computeSize(land, visited, row + r, col + c);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Q16_19_PondSizes main = new Q16_19_PondSizes();
        int[][] land = new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        main.computePondSizes(land).forEach(r -> System.out.println(r));

        int[][] land1 = new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        main.computePondSizesWithoutModification(land1).forEach(r -> System.out.println(r));
    }
}
