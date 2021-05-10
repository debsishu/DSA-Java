package backtracking;

import java.util.*;

public class NQueenMod {
  static List<List<Integer>> result = new ArrayList<List<Integer>>();

  static boolean isSafe(int board[][], int row, int col) {
    int i, j;
    int N = board.length;
    // checks if their is already an Queen or not
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

    // checks for the right diagonal position
    for (i = row, j = col; j >= 0 && i < N; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  static boolean solveNQutil(int board[][], int col) {
    int N = board.length;
    if (col == N) {
      List<Integer> v = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (board[i][j] == 1) {
            v.add(j + 1);
          }
        }
      }
      result.add(v);
      return true;
    }

    boolean res = false;
    for (int i = 0; i < N; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 1;
        res = solveNQutil(board, col + 1);
        board[i][col] = 0;
      }
    }
    return res;
  }

  static List<List<Integer>> nQueen(int n) {
    result.clear();
    int board[][] = new int[n][n];
    solveNQutil(board, 0);
    Collections.sort(result, new ListComparator<>());
    return result;
  }

  public static void main(String[] args) {
    int n = 4;
    List<List<Integer>> res = nQueen(n);
    System.out.println(res);
  }
}

// Copied from stackoverflow
// This is the comparator for sorting the list of list of integers
class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

  @Override
  public int compare(List<T> o1, List<T> o2) {
    for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
      int c = o1.get(i).compareTo(o2.get(i));
      if (c != 0) {
        return c;
      }
    }
    return Integer.compare(o1.size(), o2.size());
  }

}
