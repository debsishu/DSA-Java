package graph;

import java.util.Arrays;

public class BellmanFordGraph {

  class Edge {
    int src, dest, weight;

    Edge() {
      src = dest = weight = 0;
    }
  }

  int V, E;
  Edge edge[];

  BellmanFordGraph(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[e];
    for (int i = 0; i < e; i++) {
      edge[i] = new Edge();
    }
  }

  public void BellmanFord(int src) {
    int v = this.V;
    int e = this.E;
    int dist[] = new int[v];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    for (int i = 0; i < v; i++) {
      for (int j = 0; j < e; j++) {
        int U = edge[j].src;
        int V = edge[j].dest;
        int weight = edge[j].weight;
        if (dist[U] != Integer.MAX_VALUE && dist[U] + weight < dist[V]) {
          dist[V] = dist[U] + weight;
        }
      }
    }

    for (int j = 0; j < e; j++) {
      int U = edge[j].src;
      int V = edge[j].dest;
      int weight = edge[j].weight;
      if (dist[U] != Integer.MAX_VALUE && dist[U] + weight < dist[V]) {
        System.out.println("Graph contains negative weight");
        return;
      }
    }
    printArr(dist, V);
  }

  public void printArr(int dist[], int V) {
    System.out.println("Vertex Distance from Source");
    for (int i = 0; i < V; i++) {
      System.out.println(i + "\t\t" + dist[i]);
    }
  }

  public static void main(String[] args) {
    int V = 5;
    int E = 8;
    BellmanFordGraph graph = new BellmanFordGraph(V, E);
    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    graph.edge[0].weight = -1;

    // add edge 0-2 (or A-C in above figure)
    graph.edge[1].src = 0;
    graph.edge[1].dest = 2;
    graph.edge[1].weight = 4;

    // add edge 1-2 (or B-C in above figure)
    graph.edge[2].src = 1;
    graph.edge[2].dest = 2;
    graph.edge[2].weight = 3;

    // add edge 1-3 (or B-D in above figure)
    graph.edge[3].src = 1;
    graph.edge[3].dest = 3;
    graph.edge[3].weight = 2;

    // add edge 1-4 (or A-E in above figure)
    graph.edge[4].src = 1;
    graph.edge[4].dest = 4;
    graph.edge[4].weight = 2;

    // add edge 3-2 (or D-C in above figure)
    graph.edge[5].src = 3;
    graph.edge[5].dest = 2;
    graph.edge[5].weight = 5;

    // add edge 3-1 (or D-B in above figure)
    graph.edge[6].src = 3;
    graph.edge[6].dest = 1;
    graph.edge[6].weight = 1;

    // add edge 4-3 (or E-D in above figure)
    graph.edge[7].src = 4;
    graph.edge[7].dest = 3;
    graph.edge[7].weight = -3;

    graph.BellmanFord(0);
  }
}