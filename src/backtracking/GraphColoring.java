package backtracking;

public class GraphColoring {
  public static void main(String[] args) {
    GraphColoring coloring = new GraphColoring();
    int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
    int m = 3;
    coloring.graphColoring(graph, m);
  }

  int V = 4;
  int color[];

  boolean isSafe(int v, int graph[][], int color[], int c) {
    for (int i = 0; i < V; i++) {
      if (graph[v][i] == 1 && c == color[i]) {
        return false;
      }
    }
    return true;
  }

  boolean graphColoringUtil(int graph[][], int numOfColors, int color[], int v) {
    if (v == V) {
      return true;
    }

    for (int c = 1; c <= numOfColors; c++) {
      if (isSafe(v, graph, color, c)) {
        color[v] = c;
        if (graphColoringUtil(graph, numOfColors, color, v + 1)) {
          return true;
        }
        color[v] = 0;
      }
    }

    return false;
  }

  boolean graphColoring(int graph[][], int numOfColors) {
    color = new int[V];
    for (int i = 0; i < V; i++) {
      color[i] = 0;
    }
    if (!graphColoringUtil(graph, numOfColors, color, 0)) {
      System.out.println("Solution does not exist");
      return false;
    }

    printSolution(color);
    return true;
  }

  void printSolution(int color[]) {
    System.out.println("Solution Exists : Following are the assigned colors");
    for (int i = 0; i < V; i++) {
      System.out.print(" " + color[i] + " ");
    }
    System.out.println();
  }

}
