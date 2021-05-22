// UNFORTUNETLY THIS SOLUTION DOES NOT WORK

package backtracking;

import java.util.Arrays;

public class KnightsTour {
  public static void main(String[] args) {

    int n = 8;
    int chess[][] = new int[n][n];
    for (int[] e : chess) {
      Arrays.fill(e, 0);
    }
    printKnightsTour(chess, 0, 7, 1);

  }

  static void printKnightsTour(int chess[][], int row, int col, int move) {
    if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] >= 0) {
      return;
    } else if (move == chess.length * chess.length) {
      chess[row][col] = move;
      displayBoard(chess);
      chess[row][col] = 0;
      return;
    }
    chess[row][col] = move;
    printKnightsTour(chess, row - 2, col + 1, move + 1);
    printKnightsTour(chess, row - 1, col + 2, move + 1);
    printKnightsTour(chess, row + 1, col + 2, move + 1);
    printKnightsTour(chess, row + 2, col + 1, move + 1);
    printKnightsTour(chess, row + 2, col - 1, move + 1);
    printKnightsTour(chess, row + 1, col - 2, move + 1);
    printKnightsTour(chess, row - 1, col - 2, move + 1);
    printKnightsTour(chess, row - 2, col - 1, move + 1);
    chess[row][col] = 0;
  }

  static void displayBoard(int chess[][]) {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        System.out.print(chess[i][j] + " ");
      }
      System.out.println();
    }
  }

}
