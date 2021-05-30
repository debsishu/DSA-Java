package graphSeries;

import java.util.*;

public class KahnsAlgoTopologicalSort {
  public static void main(String[] args) {

  }

  static class solutionTopoSortKahnsAlgo {
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
      int topo[] = new int[V];
      int indegree[] = new int[V];

      // This is for filling up the indegree array
      for (int i = 0; i < V; i++) {
        for (Integer it : adj.get(i)) {
          indegree[it]++;
        }
      }

      Queue<Integer> q = new LinkedList<>();

      for (int i = 0; i < V; i++) {
        if (indegree[i] == 0) {
          q.add(i);
        }
      }

      int index = 0;
      while (!q.isEmpty()) {
        int node = q.poll();
        topo[index++] = node;
        for (Integer it : adj.get(node)) {
          indegree[it]--;
          if (indegree[it] == 0) {
            q.add(it);
          }
        }
      }
      return topo;
    }
  }

}
