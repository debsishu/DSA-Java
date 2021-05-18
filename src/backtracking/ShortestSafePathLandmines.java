package backtracking;

import java.util.*;

public class ShortestSafePathLandmines {

  static final int ROW = 12;
  static final int COLUMN = 10;

  static int rowNum[] = { -1, 0, 0, 1 };
  static int colNum[] = { 0, -1, 1, 0 };

  static int min_dist;

  // Checks if a given call can be visited or not
  static boolean isSafe(int mat[][], boolean visited[][], int x, int y) {
    if (mat[x][y] == 0 || visited[x][y]) {
      return false;
    }
    return true;
  }

  // Checks if a cell is valid or not
  // for the position x, y
  static boolean isValid(int x, int y) {
    if (x < ROW && y < COLUMN && x >= 0 && y >= 0) {
      return true;
    }
    return false;
  }

  // QUESTION STATEMENT
  // We have to avoid landmines and their four adjacent cells (left, right, above
  // and below) as they are also unsafe.

  // This marks all the adjacent cells of
  // landmines as unsafe.
  static void markUnsafeCells(int mat[][]) {

    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        // if landmines are found
        if (mat[i][j] == 0) {

          // Mark all adjacent cells

          // static int rowNum[] = { -1, 0, 0, 1 };
          // static int colNum[] = { 0, -1, 1, 0 };

          for (int k = 0; k < 4; k++) {
            if (isValid(i + rowNum[k], j + colNum[k])) {
              mat[i + rowNum[k]][j + colNum[k]] = -1;
            }
          }
        }
      }
    }

    // Mark all the found adjacent cells as unsafe
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        if (mat[i][j] == -1) {
          mat[i][j] = 0;
        }
      }
    }

    // This is for printing the path
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        System.out.print(mat[i][j] + " ");
      }
    }
    System.out.println();

  }

  static void findShortestPathUtil(int mat[][], boolean visited[][], int i, int j, int dist) {
    if (j == COLUMN - 1) {
      min_dist = Math.min(dist, min_dist);
      return;
    }
    if (dist > min_dist) {
      return;
    }
    visited[i][j] = true;

    // Try all the four neighbours
    for (int k = 0; k < 4; k++) {
      if (isValid(i + rowNum[k], j + colNum[k]) && isSafe(mat, visited, i + rowNum[k], j + colNum[k])) {
        findShortestPathUtil(mat, visited, i + rowNum[k], j + colNum[k], dist + 1);
      }
    }

    // Backtracking happens here
    visited[i][j] = false;
  }

  static void findShortestPath(int mat[][]) {
    min_dist = Integer.MAX_VALUE;

    boolean[][] visited = new boolean[ROW][COLUMN];

    markUnsafeCells(mat);

    // Start from first column and take minimum
    for (int i = 0; i < ROW; i++) {
      // If the cell is safe from the current cell
      if (mat[i][0] == 1) {
        // Initiliaze visited to false
        for (int k = 0; k < ROW; k++) {
          Arrays.fill(visited[k], false);
        }

        findShortestPathUtil(mat, visited, i, 0, 0);

        // If the minimum distance is already found
        if (min_dist == COLUMN - 1) {
          break;
        }
      }
    }

    if (min_dist != Integer.MAX_VALUE) {
      System.out.println("Length of shortest safe route is " + min_dist);
    } else {
      System.out.println("Destination not reachable from given source");
    }
  }

  public static void main(String[] args) {
    int[][] mat = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

    findShortestPath(mat);

  }

}
