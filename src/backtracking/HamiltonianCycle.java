package backtracking;

import java.util.Arrays;

public class HamiltonianCycle {

  final int V = 5;
  int path[];

  boolean isSafe(int v, int graph[][], int path[], int pos) {
    // Checks if this vertex is an adjacent vertex
    // of the previously added vertex
    // 1 means its adjacent 0 means its not
    if (graph[path[pos - 1]][v] == 0) {
      return false;
    }

    //
    for (int i = 0; i < pos; i++) {
      if (path[i] == v) {
        return false;
      }
    }
    return true;
  }

  boolean hamiltonianCycleUtil(int graph[][], int path[], int pos) {
    // If all vertices are added in cycle
    if (pos == V) {
      // If their is an edge from the last vertex
      // from the first included vertex
      if (graph[path[pos - 1]][path[0]] == 1) {
        return true;
      } else {
        return false;
      }
    }

    // Try out all the vertices
    for (int v = 1; v < V; v++) {
      if (isSafe(v, graph, path, pos)) {
        path[pos] = v;
        if (hamiltonianCycleUtil(graph, path, pos + 1)) {
          return true;
        }
        // Backtracking happens here
        path[pos] = -1;
      }
    }
    return false;
  }

  int hamiltonianCycle(int graph[][]) {
    path = new int[V];
    Arrays.fill(path, -1);
    // Putting vertex 0 as the first vertex in the path
    path[0] = 0;
    if (hamiltonianCycleUtil(graph, path, 1) == false) {
      System.out.println("Solution does not exist");
      return 0;
    }
    printSolution(path);
    return 1;
  }

  void printSolution(int path[]) {
    System.out.println("The hamiltonian cycle is");
    for (int i = 0; i < V; i++) {
      System.out.print(" " + path[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    HamiltonianCycle h = new HamiltonianCycle();
    int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 }, };
    h.hamiltonianCycle(graph1);
    int graph2[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, };
    h.hamiltonianCycle(graph2);
  }

}
