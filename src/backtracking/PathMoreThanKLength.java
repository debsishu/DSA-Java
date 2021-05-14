package backtracking;

import java.util.*;

public class PathMoreThanKLength {

  static class Node {
    int v;
    int weight;

    Node(int v, int weight) {
      this.v = v;
      this.weight = weight;
    }

    int getV() {
      return v;
    }

    int getWeight() {
      return weight;
    }
  }

  static class Graph {
    int V;
    ArrayList<ArrayList<Node>> adj;

    Graph(int V) {
      this.V = V;
      adj = new ArrayList<ArrayList<Node>>(V);

      for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<Node>());
      }
    }

    void addEdge(int u, int v, int weight) {
      Node node1 = new Node(v, weight);
      adj.get(u).add(node1);
      Node node2 = new Node(u, weight);
      adj.get(v).add(node2);
    }

    boolean pathMoreThanK(int src, int k) {
      boolean path[] = new boolean[V];
      Arrays.fill(path, false);
      path[src] = true;
      return pathMoreThanKUtil(src, k, path);
    }

    @SuppressWarnings("unused")
    private boolean pathMoreThanKUtil(int src, int k, boolean[] path) {
      // Base case : if k is less than equal to 0 return true
      if (k <= 0) {
        return true;
      }

      int index = 0;
      for (int i = 0; i < adj.get(src).size(); i++) {
        Node vertex = adj.get(src).get(i);
        int v = vertex.v;
        int w = vertex.weight;
        index++;

        // If vertex v is already there in path,
        // then there is a cycle
        // So ignore this edge
        if (path[v] == true) {
          continue;
        }

        if (w >= k) {
          return true;
        }

        // Add this vertex to the path
        path[v] = true;

        // If this adjacent can provide a path
        // longer than k, return true
        if (pathMoreThanKUtil(v, k - w, path)) {
          return true;
        }
        // Backtracking here
        path[v] = false;
      }
      // If not adjacent could produce longer path
      // return false
      return false;
    }
  }

  public static void main(String[] args) {
    int V = 9;
    Graph g = new Graph(V);

    g.addEdge(0, 1, 4);
    g.addEdge(0, 7, 8);
    g.addEdge(1, 2, 8);
    g.addEdge(1, 7, 11);
    g.addEdge(2, 3, 7);
    g.addEdge(2, 8, 2);
    g.addEdge(2, 5, 4);
    g.addEdge(3, 4, 9);
    g.addEdge(3, 5, 14);
    g.addEdge(4, 5, 10);
    g.addEdge(5, 6, 2);
    g.addEdge(6, 7, 1);
    g.addEdge(6, 8, 6);
    g.addEdge(7, 8, 7);

    int src = 0;
    int k = 62;

    if (g.pathMoreThanK(src, k)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

    k = 60;
    if (g.pathMoreThanK(src, k)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

}
