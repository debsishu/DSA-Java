package backtracking;

public class PrintAllPossiblePaths {

  private static void printMatrix(int matrix[][], int row, int col, int i, int j, int path[], int index) {
    // Add current cell to the path
    path[index] = matrix[i][j];

    // Reached the bottom of the matrix so we are left with
    // only option to move right
    if (i == row - 1) {
      // Moving to the right direction of the matrix
      for (int k = j + 1; k < col; k++) {
        path[index + k - j] = matrix[i][k];
      }
      // Printing the path
      for (int l = 0; l < index + col - j; l++) {
        System.out.print(path[l] + " ");
      }
      System.out.println();
      return;
    }

    // Reached the right corner of the matrix we are left with
    // only the downward movement.
    if (j == col - 1) {
      // Downward movement across the matrix
      for (int k = i + 1; k < row; k++) {
        path[index + k - i] = matrix[k][j];
      }
      // Printing the path
      for (int l = 0; l < index + row - i; l++) {
        System.out.print(path[l] + " ");
      }
      System.out.println();
      return;
    }
    // Print all the paths that are possible after moving down
    printMatrix(matrix, row, col, i + 1, j, path, index + 1);

    // Print all the paths that are possible after moving right
    printMatrix(matrix, row, col, i, j + 1, path, index + 1);
  }

  public static void main(String[] args) {
    int m = 2;
    int n = 3;
    int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
    int maxLengthOfPath = m + n - 1;
    printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
  }

}
