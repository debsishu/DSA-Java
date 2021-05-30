// GFG LINK : https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

package graphSeries;

import java.util.ArrayList;

public class DetectCycleDFSDirected {
  public static void main(String[] args) {

  }

  static class solutionDetectCycleDirectedBFS {
    boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
      boolean visited[] = new boolean[v];
      boolean dfsVisited[] = new boolean[v];

      for (int i = 0; i < v; i++) {
        if (visited[i] == false) {
          if (isCycleDFS(i, adj, visited, dfsVisited)) {
            return true;
          }
        }
      }
      return false;
    }

    boolean isCycleDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean dfsVisited[]) {
      visited[node] = true;
      dfsVisited[node] = true;

      for (Integer it : adj.get(node)) {
        if (visited[it] == false) {
          if (isCycleDFS(it, adj, visited, dfsVisited)) {
            return true;
          }
        } else if (dfsVisited[it]) {
          return true;
        }
      }

      dfsVisited[node] = false;
      return false;
    }
  }

}
