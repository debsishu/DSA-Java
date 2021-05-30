package graphSeries;

import java.util.ArrayList;

class DetectCycleDFS {
  public static void main(String[] args) {

  }

  // Here the graph is 1 based indexed
  static class solutionDetectCycleDFS {
    boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean visited[] = new boolean[V + 1];
      for (int i = 1; i <= V; i++) {
        if (checkDFS(i, -1, visited, adj))
          return true;
      }
      return false;
    }

    boolean checkDFS(int node, int parent, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
      visited[node] = true;
      for (Integer it : adj.get(node)) {
        if (!visited[it]) {
          if (checkDFS(it, node, visited, adj)) {
            return true;
          }
        } else if (it != parent) {
          return true;
        }
      }
      return false;
    }

  }
}
