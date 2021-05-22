package backtracking;

import java.util.Arrays;

public class KnightsTourGFG {

  static int N = 8;

  // In this question -1 indicates unvisited
  static boolean isSafe(int x, int y, int sol[][]) {
    return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
  }

  static void printSolution(int sol[][]) {
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        System.out.print(sol[x][y] + "\t");
      }
      System.out.println();
    }
  }

  static boolean knightsTour() {
    int sol[][] = new int[8][8];

    for (int e[] : sol) {
      Arrays.fill(e, -1);
    }

    // This decides the knights move around the chess board
    int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    // The Knight is initially at the first block
    sol[0][0] = 0;

    if (!knightsTourUtil(0, 0, 1, sol, xMove, yMove)) {
      System.out.println("Solution does not exist");
      return false;
    } else {
      printSolution(sol);
    }
    return true;
  }

  static boolean knightsTourUtil(int x, int y, int move, int sol[][], int xMove[], int yMove[]) {
    if (move == N * N) {
      return true;
    }

    // Try out all the positions on the chessboard of the knight
    for (int k = 0; k < 8; k++) {
      int nextX = x + xMove[k];
      int nextY = y + yMove[k];
      if (isSafe(nextX, nextY, sol)) {
        sol[nextX][nextY] = move;
        if (knightsTourUtil(nextX, nextY, move + 1, sol, xMove, yMove)) {
          return true;
        } else {
          // BACKTRACKING
          sol[nextX][nextY] = -1;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    knightsTour();
  }

}
