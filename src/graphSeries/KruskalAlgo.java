package graphSeries;

import java.util.*;

public class KruskalAlgo {
  public static void main(String[] args) {
    int n = 5;
    ArrayList<Node> adj = new ArrayList<Node>();

    adj.add(new Node(0, 1, 2));
    adj.add(new Node(0, 3, 6));
    adj.add(new Node(1, 3, 8));
    adj.add(new Node(1, 2, 3));
    adj.add(new Node(1, 4, 5));
    adj.add(new Node(2, 4, 7));

    KruskalAlgo obj = new KruskalAlgo();
    obj.kruskalAlgo(adj, n);
  }

  private int findpar(int u, int parent[]) {
    if (u == parent[u]) {
      return u;
    }
    return parent[u] = findpar(parent[u], parent);
  }

  private void union(int u, int v, int parent[], int rank[]) {
    u = findpar(u, parent);
    v = findpar(v, parent);
    if (rank[u] < rank[v]) {
      parent[u] = v;
    } else if (rank[v] < rank[u]) {
      parent[v] = u;
    } else {
      parent[v] = u;
      rank[u]++;
    }
  }

  void kruskalAlgo(ArrayList<Node> adj, int N) {
    Collections.sort(adj, new SortComparator());
    int rank[] = new int[N];
    int parent[] = new int[N];

    for (int i = 0; i < N; i++) {
      parent[i] = i;
      rank[i] = 0;
    }

    int costMst = 0;
    ArrayList<Node> mst = new ArrayList<>();

    for (Node it : adj) {
      if (findpar(it.u, parent) != findpar(it.v, parent)) {
        costMst += it.weight;
        mst.add(it);
        union(it.u, it.v, parent, rank);
      }
    }

    System.out.println("Total cost of the mst is : " + costMst);
    for (Node it : mst) {
      System.out.println(it.u + " -- " + it.v);
    }
  }

  static class Node {
    int u;
    int v;
    int weight;

    Node() {
    }

    Node(int u, int v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }
  }

  class SortComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
      if (node1.weight < node2.weight) {
        return -1;
      }
      if (node1.weight > node2.weight) {
        return 1;
      }
      return 0;
    }
  }

}
