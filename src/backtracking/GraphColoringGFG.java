package backtracking;

import java.util.*;

// Check the Striver(TakeUForward) video
// Check GFG solution for an easy way

public class GraphColoringGFG {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    List<Integer>[] graph = new ArrayList[4];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    int graphArr[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        graph[i].add(graphArr[i][j]);
      }
    }
    int color[] = new int[graph.length];
    graphColoring(graph, color, 0, 3);
  }

  static boolean graphColoring(List<Integer> graph[], int color[], int v, int c) {
    for (int i = 0; i < graph.length; i++) {
      color[i] = 0;
    }
    if (!graphColoringUtil(graph, c, color, v)) {
      return false;
    }
    printSolution(color);
    return true;
  }

  static void printSolution(int color[]) {
    System.out.println("Solution Exists : Following are the assigned colors");
    for (int i = 0; i < color.length; i++) {
      System.out.print(" " + color[i] + " ");
    }
    System.out.println();
  }

  static boolean isSafe(int v, List<Integer> graph[], int color[], int selectedColor) {
    List<Integer> adjacentList = graph[v];
    for (int i = 0; i < adjacentList.size(); i++) {
      if (selectedColor == color[adjacentList.get(i)]) {
        return false;
      }
    }
    return true;
  }

  static boolean graphColoringUtil(List<Integer> graph[], int m, int color[], int v) {
    if (v == graph.length) {
      return true;
    }

    for (int i = 1; i <= m; i++) {
      if (isSafe(v, graph, color, i)) {
        color[v] = i;
        if (graphColoringUtil(graph, m, color, v + 1)) {
          return true;
        }
        color[v] = 0;
      }
    }
    return false;
  }
}
