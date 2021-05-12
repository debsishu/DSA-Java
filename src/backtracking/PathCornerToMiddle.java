package backtracking;

public class PathCornerToMiddle {
  public static void main(String[] args) {
    int[][] maze = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 }, { 6, 7, 5, 6, 6, 2, 6, 6, 2 }, { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
        { 6, 5, 5, 1, 2, 3, 6, 5, 6 }, { 3, 3, 4, 3, 0, 1, 4, 3, 4 }, { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
        { 3, 5, 4, 3, 2, 6, 4, 4, 3 }, { 3, 5, 1, 3, 7, 5, 3, 6, 4 }, { 6, 2, 4, 3, 4, 5, 4, 5, 1 } };

    printPath(maze, 0, 0, "");
  }

  private static void printPath(int[][] maze, int i, int j, String ans) {
    // If we have reached the middle of the maze
    if (i == maze.length / 2 && j == maze.length / 2) {
      ans += "(" + i + ", " + j + ") -> MID";
      System.out.println(ans);
      return;
    }

    // If the cell is already visited
    // Here visited is marked with 0
    if (maze[i][j] == 0) {
      return;
    }

    // Storing the element for the recursive call
    // because we are marking the cell as visited as 0
    int k = maze[i][j];

    // Marking as visited
    maze[i][j] = 0;

    // Making recursive call in all the 4 directions
    // Right direction call
    if (j + k < maze.length) {
      printPath(maze, i, j + k, ans + "(" + i + ", " + j + ") ->");
    }

    // Down direction call
    if (i + k < maze.length) {
      printPath(maze, i + k, j, ans + "(" + i + ", " + j + ") ->");
    }

    // Left direction call
    if (j - k > 0) {
      printPath(maze, i, j - k, ans + "(" + i + ", " + j + ") ->");
    }

    // Up direction call
    if (i - k > 0) {
      printPath(maze, i - k, j, ans + "(" + i + ", " + j + ") ->");
    }

    // Unmarking the cell as visited
    // The backtracking happens here
    maze[i][j] = k;
  }
}
