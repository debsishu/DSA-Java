package graphSeries;

import java.util.*;

public class ShortestPathDAG {
  public static void main(String[] args) {
    int n = 6;
    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Pair>());
    }

    adj.get(0).add(new Pair(1, 2));
    adj.get(0).add(new Pair(4, 1));
    adj.get(1).add(new Pair(2, 3));
    adj.get(2).add(new Pair(3, 6));
    adj.get(4).add(new Pair(2, 2));
    adj.get(4).add(new Pair(5, 4));
    adj.get(5).add(new Pair(3, 1));

    ShortestPathDAG obj = new ShortestPathDAG();
    obj.shortestPathDAG(n, adj, 0);
  }

  void shortestPathDAG(int V, ArrayList<ArrayList<Pair>> adj, int src) {
    Stack<Integer> stack = new Stack<>();
    boolean visited[] = new boolean[V];
    int distance[] = new int[V];
    Arrays.fill(visited, false);
    Arrays.fill(distance, Integer.MAX_VALUE);

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        topologicalSort(i, visited, stack, adj);
      }
    }

    distance[src] = 0;

    while (!stack.isEmpty()) {
      int node = stack.pop();

      // IF THAT NODE HAS BEEN REACHED PREVIOUSLY
      // If we have never reached that node how we can calculate the distance of the
      // adjacent nodes
      if (distance[node] != Integer.MAX_VALUE) {
        for (Pair it : adj.get(node)) {
          if (distance[node] + it.weight < distance[it.v]) {
            distance[it.v] = distance[node] + it.weight;
          }
        }
      }
    }

    for (int i = 0; i < V; i++) {
      if (distance[i] == Integer.MAX_VALUE) {
        System.out.print("Not Reachable ");
      } else {
        System.out.print(distance[i] + " ");
      }
    }
    System.out.println();

  }

  void topologicalSort(int node, boolean visited[], Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj) {
    visited[node] = true;

    for (Pair it : adj.get(node)) {
      if (!visited[it.v]) {
        topologicalSort(it.v, visited, stack, adj);
      }
    }
    stack.push(node);
  }

  static class Pair {
    int v;
    int weight;

    Pair(int v, int weight) {
      this.v = v;
      this.weight = weight;
    }
  }
}
