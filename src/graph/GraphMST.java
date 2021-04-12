package graph;

public class GraphMST {

  int v;

  int minKey(int key[], boolean mstSet[]) {
    int min = Integer.MAX_VALUE;
    int min_index = -1;
    for (int i = 0; i < this.v; i++) {
      if (mstSet[i] == false && key[i] < min) {
        min = key[i];
        min_index = i;
      }
    }
    return min_index;
  }

  void printMST(int parent[], int graph[][]) {
    System.out.println("Edge \tWeight");
    int weight = 0;
    for (int i = 1; i < this.v; i++) {
      System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
      weight += graph[i][parent[i]];
    }
    System.out.println("The minimum weight is : " + weight);
  }

  void primsMST(int graph[][]) {
    int parent[] = new int[this.v];
    int key[] = new int[this.v];
    boolean mstSet[] = new boolean[this.v];
    for (int i = 0; i < this.v; i++) {
      key[i] = Integer.MAX_VALUE;
      mstSet[i] = false;
    }
    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < this.v - 1; count++) {
      int u = minKey(key, mstSet);
      mstSet[u] = true;

      for (int i = 0; i < this.v; i++) {
        if (graph[u][i] != 0 && mstSet[i] == false && graph[u][i] < key[i]) {
          key[i] = graph[u][i];
          parent[i] = u;
        }
      }
    }

    printMST(parent, graph);
  }

  public static void main(String[] args) {
    GraphMST g = new GraphMST();
    int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
        { 0, 5, 7, 9, 0 } };
    g.v = 5;
    g.primsMST(graph);
  }
}
