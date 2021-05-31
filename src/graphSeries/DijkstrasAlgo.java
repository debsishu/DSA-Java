package graphSeries;

import java.util.*;

public class DijkstrasAlgo {
  public static void main(String[] args) {

    int n = 5;
    ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Node>());
    }

    adj.get(0).add(new Node(1, 2));
    adj.get(1).add(new Node(0, 2));
    adj.get(1).add(new Node(2, 4));
    adj.get(2).add(new Node(1, 4));
    adj.get(0).add(new Node(3, 1));
    adj.get(3).add(new Node(0, 1));
    adj.get(3).add(new Node(2, 3));
    adj.get(2).add(new Node(3, 3));
    adj.get(1).add(new Node(4, 5));
    adj.get(4).add(new Node(1, 5));
    adj.get(2).add(new Node(4, 1));
    adj.get(4).add(new Node(2, 1));

    DijkstrasAlgo obj = new DijkstrasAlgo();
    obj.shortestPathDijkstra(0, adj, n);

  }

  void shortestPathDijkstra(int src, ArrayList<ArrayList<Node>> adj, int N) {
    int distance[] = new int[N];
    Arrays.fill(distance, Integer.MAX_VALUE);

    distance[src] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
    pq.add(new Node(src, 0));

    while (pq.size() > 0) {
      Node node = pq.poll();

      for (Node it : adj.get(node.v)) {
        if (distance[node.v] + it.weight < distance[it.v]) {
          distance[it.v] = distance[node.v] + it.weight;
          pq.add(new Node(it.v, distance[it.v]));
        }
      }
    }

    for (int e : distance) {
      System.out.print(e + " ");
    }
    System.out.println();
  }

  static class Node implements Comparator<Node> {
    int v;
    int weight;

    // Default constructor
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
      }
      if (node1.weight > node2.weight) {
        return 1;
      }
      return 0;
    }
  }
}
