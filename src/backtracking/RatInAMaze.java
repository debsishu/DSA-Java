package backtracking;

import java.util.*;

class RatInAMaze {
  public static void main(String[] args) {
    RatInAMaze rat = new RatInAMaze();
    int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
    N = maze.length;
    // rat.solveMaze(maze);

    ArrayList<String> result = rat.findPath(maze);
    System.out.println(result);

    // This is for the Apni kaksha solution
    // int sol[][] = new int[N][N];
    // rat.ratinMaze(maze, 0, 0, sol);
    // for (int i = 0; i < N; i++) {
    // for (int j = 0; j < N; j++) {
    // System.out.print(sol[i][j] + " ");
    // }
    // System.out.println();
    // }

  }

  // Size of the maze
  static int N;

  void printSolution(int sol[][]) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(" " + sol[i][j] + " ");
      }
      System.out.println();
    }
  }

  // Util function for checking if x and y
  // is a valid index in N*N matrix
  boolean isSafe(int maze[][], int x, int y) {
    return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
  }

  boolean solveMaze(int maze[][]) {
    int sol[][] = new int[N][N];
    if (solveMazeUtil(maze, 0, 0, sol) == false) {
      System.out.println("Solution doesn't exist");
      return false;
    }
    printSolution(sol);
    return true;
  }

  private boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
    // if x, y is the goal return true
    if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
      sol[x][y] = 1;
      return true;
    }

    if (isSafe(maze, x, y) == true) {
      // Check if the current block
      // is already part of the solution path
      if (sol[x][y] == 1) {
        return false;
      }
      // mark x, y as part of solution path
      sol[x][y] = 1;
      // Move forward in x direction
      if (solveMazeUtil(maze, x + 1, y, sol)) {
        return true;
      }
      // If moving in the x direction doesn't
      // give solution move in y direction
      if (solveMazeUtil(maze, x, y + 1, sol)) {
        return true;
      }
      // If moving in y direction doesn't give
      // solution then move down in y direction
      if (solveMazeUtil(maze, x - 1, y, sol)) {
        return true;
      }
      // if moving down in y direction doesn't give
      // solution then move upwards in y direction
      if (solveMazeUtil(maze, x, y - 1, sol)) {
        return true;
      }

      // If none of the above movements works then
      // BACKTRACK (unmark x, y as part of the solution)
      sol[x][y] = 0;
      return false;
    }
    return false;
  }

  // This is the apni kaksha solution
  boolean ratinMaze(int arr[][], int x, int y, int sol[][]) {
    if (x == N - 1 && y == N - 1 && arr[x][y] == 1) {
      sol[x][y] = 1;
      return true;
    }
    if (isSafe(arr, x, y)) {
      sol[x][y] = 1;
      if (ratinMaze(arr, x + 1, y, sol)) {
        return true;
      }
      if (ratinMaze(arr, x, y + 1, sol)) {
        return true;
      }
      sol[x][y] = 0;
      return false;
    }
    return false;
  }

  ArrayList<String> findPath(int maze[][]) {
    ArrayList<String> result = new ArrayList<>();
    String output = "";
    backtrack(maze, result, 0, 0, output);
    return result;
  }

  // This is the GFG solution
  private void backtrack(int[][] maze, ArrayList<String> result, int i, int j, String output) {
    // This means we have taken a wrong step
    if (i < 0 || i >= N || j < 0 || j >= N || maze[i][j] == 0) {
      return;
    }
    // This means we have reached the destination
    if (i == N - 1 && j == N - 1) {
      result.add(output);
      return;
    }
    // Making the maze visited
    maze[i][j] = 0;

    // Moving in the Down direction
    backtrack(maze, result, i + 1, j, output + "D");
    // Moving in the Left direction
    backtrack(maze, result, i, j - 1, output + "L");
    // Moving in the Right direction
    backtrack(maze, result, i, j + 1, output + "R");
    // Moving in the Up direction
    backtrack(maze, result, i - 1, j, output + "U");

    // Marking the maze unvisited
    maze[i][j] = 1;
  }
}