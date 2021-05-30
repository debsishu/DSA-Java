package graphSeries;

import java.util.*;

public class DetectCycleBFS {
  public static void main(String[] args) {

  }

  static class solutionDetectCycleBFS {
    static class Node {
      int first;
      int second;

      Node(int first, int second) {
        this.first = first;
        this.second = second;
      }
    }

    boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean visited[] = new boolean[V + 1];

      for (int i = 0; i <= V; i++) {
        if (!visited[i]) {
          if (checkCycleBFS(adj, i, visited)) {
            return true;
          }
        }
      }
      return false;
    }

    boolean checkCycleBFS(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]) {
      Queue<Node> q = new LinkedList<>();
      q.add(new Node(s, -1));
      visited[s] = true;

      while (!q.isEmpty()) {
        int node = q.peek().first;
        int parent = q.peek().second;
        q.remove();

        for (Integer it : adj.get(node)) {
          if (!visited[it]) {
            q.add(new Node(it, node));
            visited[it] = true;
          } else if (parent != it) {
            return true;
          }
        }
      }
      return false;
    }
  }

}
