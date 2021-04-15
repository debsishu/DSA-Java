package graph;

public class GraphKruskal {

  int v = 5;
  int parent[] = new int[this.v];

  int find(int i) {
    while (parent[i] != i) {
      i = parent[i];
    }
    return i;
  }

  void union(int i, int j) {
    int a = find(i);
    int b = find(j);
    parent[a] = b;
  }

  void kruskalMST(int cost[][]) {
    int mincost = 0;
    for (int i = 0; i < this.v; i++) {
      parent[i] = i;
    }
    int edge_count = 0;
    while (edge_count < this.v - 1) {
      int min = Integer.MAX_VALUE;
      int a = -1;
      int b = -1;
      for (int i = 0; i < this.v; i++) {
        for (int j = 0; j < this.v; j++) {
          if (find(i) != find(j) && cost[i][j] < min) {
            min = cost[i][j];
            a = i;
            b = j;
          }
        }
      }
      union(a, b);
      System.out.println("Edge " + edge_count++ + ":(" + a + "," + b + ") cost : " + min);
      mincost += min;
    }
    System.out.println("Minimum cost = " + mincost);
  }

  public static void main(String[] args) {
    GraphKruskal g = new GraphKruskal();
    g.v = 5;
    int INF = Integer.MAX_VALUE;
    int cost[][] = { { INF, 2, INF, 6, INF }, 
                      { 2, INF, 3, 8, 5 }, 
                      { INF, 3, INF, INF, 7 }, 
                      { 6, 8, INF, INF, 9 },
                      { INF, 5, 7, 9, INF }, };
    g.kruskalMST(cost);
  }
}
