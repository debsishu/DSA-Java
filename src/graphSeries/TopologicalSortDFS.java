package graphSeries;

import java.util.*;

public class TopologicalSortDFS {
  public static void main(String[] args) {

  }
}

class solutionTopologicalSortDFS {
  int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    Stack<Integer> stk = new Stack<>();
    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        findTopologicalSortDFS(i, adj, stk, visited);
      }
    }

    int res[] = new int[V];
    int index = 0;
    while (!stk.isEmpty()) {
      res[index] = stk.pop();
      index++;
    }
    return res;
  }

  void findTopologicalSortDFS(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk, boolean visited[]) {
    visited[node] = true;

    for (Integer it : adj.get(node)) {
      if (!visited[it]) {
        findTopologicalSortDFS(it, adj, stk, visited);
      }
    }
    stk.push(node);
  }
}
