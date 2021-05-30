package graphSeries;

import java.util.ArrayList;

public class DFS {
  public static void main(String[] args) {

  }

  // Here the graph is 1 indexing based
  static class solutionDFS {
    ArrayList<Integer> DFS(int V, ArrayList<ArrayList<Integer>> adj) {
      ArrayList<Integer> res = new ArrayList<>();
      boolean visited[] = new boolean[V + 1];
      for (int i = 1; i <= V; i++) {
        if (visited[i] == false) {
          DFSUtil(i, visited, adj, res);
        }
      }
      return res;
    }

    void DFSUtil(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
      res.add(node);
      visited[node] = true;
      for (Integer it : adj.get(node)) {
        if (visited[it] == false) {
          DFSUtil(it, visited, adj, res);
        }
      }
    }
  }

}
