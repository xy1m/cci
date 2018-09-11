package com.xy1m.cci.chapter08_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }

    public int hashCode() {
        return (x * y) % 100;
    }
}

public class Q8_02_RobotGrid {

    static List<Point> getPath(boolean[][] maze) {
        List<Point> path = new ArrayList<>();
        if (maze == null || maze.length == 0) return path;
        Set<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return path;
    }

    static boolean getPath(boolean[][] maze, int row, int col, List<Point> path, Set<Point> failedPoints) {
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }
        Point point = new Point(row, col);
        if (failedPoints.contains(point)) {
            return false;
        }

        boolean isAtOrigin = col == 0 && row == 0;
        if (isAtOrigin || getPath(maze, row - 1, col, path, failedPoints) || getPath(maze, row, col - 1, path, failedPoints)) {
            path.add(point);
            return true;
        }
        failedPoints.add(point);
        return false;
    }

    public static void main(String[] args) {
        boolean[][] maze = new boolean[][]{
                {true, true, false},
                {false, true, false},
                {false, true, true}
        };
        getPath(maze).forEach(p -> System.out.println(p.x + "," + p.y));
    }
}


