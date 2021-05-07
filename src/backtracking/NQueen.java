package backtracking;

import java.util.Arrays;

public class NQueen {
  int N = 4;

  void printSolution(int board[][]) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  boolean isSafe(int board[][], int row, int col) {
    int i, j;
    // Checks if their is already an Queen
    for (i = 0; i < col; i++) {
      if (board[row][i] == 1) {
        return false;
      }
    }

    // Checks for the left diagonal position
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    // Checks for the right diagonal position
    for (i = row, j = col; j >= 0 && i < N; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  boolean solveNQUtil(int board[][], int col) {
    if (col >= N) {
      return true;
    }

    for (int i = 0; i < N; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 1;
        if (solveNQUtil(board, col + 1)) {
          return true;
        }
        board[i][col] = 0;
      }
    }
    return false;
  }

  boolean solveNQ() {
    int board[][] = new int[N][N];
    for (int e[] : board) {
      Arrays.fill(e, 0);
    }
    if (solveNQUtil(board, 0) == false) {
      System.out.println("Solution does not exist");
      return false;
    }
    printSolution(board);
    return true;
  }

  public static void main(String[] args) {
    NQueen q = new NQueen();
    q.solveNQ();
  }
}
