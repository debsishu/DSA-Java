package graphSeries;

import java.util.*;

public class KosarajusAlgo {
  public static void main(String[] args) {
    int n = 5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(0).add(1);
    adj.get(1).add(2);
    adj.get(2).add(0);
    adj.get(1).add(3);
    adj.get(3).add(4);
    KosarajusAlgo obj = new KosarajusAlgo();
    obj.kosaraju(adj, n);

  }

  void kosaraju(ArrayList<ArrayList<Integer>> adj, int n) {
    boolean vis[] = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        topoSort(i, stack, adj, vis);
      }
    }

    ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      transpose.add(new ArrayList<Integer>());
    }
    Arrays.fill(vis, false);

    // This is for transposing the matrix
    for (int i = 0; i < n; i++) {
      for (Integer it : adj.get(i)) {
        transpose.get(it).add(i);
      }
    }

    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (!vis[node]) {
        System.out.print("SCC : ");
        revDFS(node, transpose, vis);
        System.out.println();
      }
    }
  }

  private void topoSort(int node, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
    visited[node] = true;
    for (Integer it : adj.get(node)) {
      if (!visited[it]) {
        topoSort(it, stack, adj, visited);
      }
    }
    stack.push(node);
  }

  private void revDFS(int node, ArrayList<ArrayList<Integer>> transpose, boolean visited[]) {
    visited[node] = true;
    System.out.print(node + " ");
    for (Integer it : transpose.get(node)) {
      if (!visited[it]) {
        revDFS(it, transpose, visited);
      }
    }
  }

}
