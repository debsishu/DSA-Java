package backtracking;

public class LongestPossibleRoute {

  // Solution is producing wrong answer

  public static void main(String[] args) {
    int[][] mat = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
    findPath(mat);
    System.out.println(maxPath);
  }

  static int maxPath = Integer.MIN_VALUE;

  static boolean visited[][] = new boolean[3][10];

  static boolean isSafe(int mat[][], int i, int j) {
    if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 1 && visited[i][j] == false) {
      return true;
    }
    return false;
  }

  static void findPath(int mat[][]) {

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        findPathUtil(mat, 0, 0, i, j, 0);
      }
    }

  }

  static void findPathUtil(int mat[][], int i, int j, int x, int y, int dist) {
    if (i == x && j == y && j < mat[0].length && i < mat.length) {
      maxPath = Math.max(maxPath, dist);
      return;
    }

    visited[i][j] = true;
    if (isSafe(mat, i + 1, j)) {
      findPathUtil(mat, i + 1, j, x, y, dist + 1);
    }
    if (isSafe(mat, i, j + 1)) {
      findPathUtil(mat, i, j + 1, x, y, dist + 1);
    }
    if (isSafe(mat, i, j - 1)) {
      findPathUtil(mat, i, j - 1, x, y, dist + 1);
    }
    if (isSafe(mat, i - 1, j)) {
      findPathUtil(mat, i - 1, j, x, y, dist + 1);
    }
    visited[i][j] = false;
  }
}
