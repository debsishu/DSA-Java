package graphSeries;

import java.util.*;

public class BFS {
  public static void main(String[] args) {

  }

  // In this question the graph is 1 based indexed
  static class solutionBFS {
    ArrayList<Integer> BFSTraversal(int V, ArrayList<ArrayList<Integer>> adj) {
      ArrayList<Integer> result = new ArrayList<>();
      boolean visited[] = new boolean[V + 1];

      for (int i = 1; i <= V; i++) {
        if (visited[i] == false) {
          Queue<Integer> q = new LinkedList<>();
          q.add(i);
          visited[i] = true;

          while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int it : adj.get(node)) {
              if (visited[it] == false) {
                visited[it] = true;
                q.add(it);
              }
            }
          }
        }
      }
      return result;
    }
  }

}
