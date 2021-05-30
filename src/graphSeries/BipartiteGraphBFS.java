package graphSeries;

import java.util.*;

public class BipartiteGraphBFS {
  public static void main(String[] args) {

    int n = 7;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(0).add(1);
    adj.get(1).add(0);

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(2).add(3);
    adj.get(3).add(2);

    adj.get(4).add(3);
    adj.get(3).add(4);

    adj.get(4).add(5);
    adj.get(5).add(4);

    adj.get(4).add(6);
    adj.get(6).add(4);

    adj.get(1).add(6);
    adj.get(6).add(1);

    solutionBipartiteBFS sol = new solutionBipartiteBFS();
    if (sol.checkBipartite(n, adj)) {
      System.out.println("The Graph is Bipartite");
    } else {
      System.out.println("The Graph is not Bipartite");
    }

  }

  static class solutionBipartiteBFS {
    boolean checkBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
      int color[] = new int[V];
      Arrays.fill(color, -1);

      for (int i = 0; i < V; i++) {
        if (color[i] == -1) {
          if (!checkBipartiteUtil(adj, i, color)) {
            return false;
          }
        }
      }
      return true;
    }

    boolean checkBipartiteUtil(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
      Queue<Integer> q = new LinkedList<>();
      q.add(node);
      color[node] = 1;

      while (!q.isEmpty()) {
        int v = q.poll();

        for (Integer it : adj.get(v)) {
          if (color[it] == -1) {
            color[it] = 1 - color[v];
            q.add(it);
          } else if (color[it] == color[v]) {
            return false;
          }
        }
      }
      return true;
    }
  }

}
