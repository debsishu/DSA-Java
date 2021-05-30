package graphSeries;

import java.util.*;

public class BipartiteGraphDFS {
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

    solutionBipartiteDFS sol = new solutionBipartiteDFS();
    if (sol.checkBipartite(n, adj)) {
      System.out.println("Bipartite");
    } else {
      System.out.println("Not Bipartite");
    }

  }

  static class solutionBipartiteDFS {
    boolean checkBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
      int color[] = new int[v];
      Arrays.fill(color, -1);

      for (int i = 0; i < v; i++) {
        if (color[i] == -1) {
          if (!checkBipartiteUtil(i, adj, color)) {
            return false;
          }
        }
      }
      return true;
    }

    boolean checkBipartiteUtil(int node, ArrayList<ArrayList<Integer>> adj, int color[]) {
      if (color[node] == -1) {
        color[node] = 1;
      }

      for (Integer it : adj.get(node)) {
        if (color[it] == -1) {
          color[it] = 1 - color[node];
          if (!checkBipartiteUtil(it, adj, color)) {
            return false;
          }
        } else if (color[it] == color[node]) {
          return false;
        }
      }
      return true;

    }
  }
}
