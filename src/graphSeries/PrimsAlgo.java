package graphSeries;

import java.util.*;

public class PrimsAlgo {
  public static void main(String[] args) {
    int n = 5;
    ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<Node>());

    adj.get(0).add(new Node(1, 2));
    adj.get(1).add(new Node(0, 2));

    adj.get(1).add(new Node(2, 3));
    adj.get(2).add(new Node(1, 3));

    adj.get(0).add(new Node(3, 6));
    adj.get(3).add(new Node(0, 6));

    adj.get(1).add(new Node(3, 8));
    adj.get(3).add(new Node(1, 8));

    adj.get(1).add(new Node(4, 5));
    adj.get(4).add(new Node(1, 5));

    adj.get(2).add(new Node(4, 7));
    adj.get(4).add(new Node(2, 7));

    PrimsAlgo obj = new PrimsAlgo();
    obj.primsAlgoOptimized(adj, n);

  }

  void primsAlgo(ArrayList<ArrayList<Node>> adj, int N) {
    int key[] = new int[N];
    boolean mstSet[] = new boolean[N];
    int parent[] = new int[N];
    Arrays.fill(key, Integer.MAX_VALUE);
    Arrays.fill(mstSet, false);
    Arrays.fill(parent, -1);

    // Starting with the first node in the graph
    key[0] = 0;
    parent[0] = -1;

    // In a Minimum Spanning Tree there could only be N - 1 edges
    for (int i = 0; i < N - 1; i++) {
      int min = Integer.MAX_VALUE;
      int u = 0;

      // select the minimum weight edge from the key array
      for (int v = 0; v < N; v++) {
        if (!mstSet[v] && key[v] < min) {
          min = key[v];
          u = v;
        }
      }

      // Add it to the MST
      mstSet[u] = true;

      // Iterate through the adjacent nodes
      for (Node it : adj.get(u)) {
        // If the weight of is smaller than the already existing weight update it
        if (!mstSet[it.v] && it.weight < key[it.v]) {
          // Update the parent and key value
          parent[it.v] = u;
          key[it.v] = it.weight;
        }
      }
    }

    for (int i = 1; i < N; i++) {
      System.out.println(parent[i] + " -- " + i);
    }
  }

  void primsAlgoOptimized(ArrayList<ArrayList<Node>> adj, int N) {
    int key[] = new int[N];
    int parent[] = new int[N];
    boolean mstSet[] = new boolean[N];
    Arrays.fill(key, Integer.MAX_VALUE);
    Arrays.fill(parent, -1);
    Arrays.fill(mstSet, false);

    // Here we are taking a priority queue so we don't have to search through the
    // array for the smallest element
    PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());

    key[0] = 0;
    pq.add(new Node(key[0], 0));

    while (!pq.isEmpty()) {
      int u = pq.poll().v;
      mstSet[u] = true;

      for (Node it : adj.get(u)) {
        if (!mstSet[it.v] && it.weight < key[it.v]) {
          parent[it.v] = u;
          key[it.v] = it.weight;
          pq.add(new Node(it.v, key[it.v]));
        }
      }
    }

    for (int i = 1; i < N; i++) {
      System.out.println(parent[i] + " -- " + i);
    }
  }

  static class Node implements Comparator<Node> {
    int v;
    int weight;

    Node() {
    }

    Node(int v, int weight) {
      this.v = v;
      this.weight = weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
      if (node1.weight < node2.weight) {
        return -1;
      } else if (node1.weight > node2.weight) {
        return 1;
      }
      return 0;
    }
  }
}
