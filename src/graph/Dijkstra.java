package graph;

public class Dijkstra {

  int v;

  public void dijkstra(int graph[][], int src) {
    // for adjacency list representation check the GFG practice problem
    // https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1#
    int distance[] = new int[this.v];
    boolean sptSet[] = new boolean[this.v];
    for (int i = 0; i < this.v; i++) {
      distance[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }
    distance[src] = 0;

    for (int count = 0; count < this.v - 1; count++) {
      int u = minDistance(distance, sptSet);
      System.out.print(u + " ");
      sptSet[u] = true;
      for (int i = 0; i < this.v; i++) {
        if (!sptSet[i] && graph[u][i] != 0 && 
        distance[u] != Integer.MAX_VALUE && 
        distance[u] + graph[u][i] < distance[i]) {
          distance[i] = distance[u] + graph[u][i];
        }
      }
    }
    System.out.println();
    printSolution(distance);
  }

  private void printSolution(int[] distance) {
    System.out.println("Vertex \t\t Distance from source");
    for(int i = 0; i < this.v; i++) {
      System.out.println(i + " \t\t " + distance[i]);
    }
  }

  private int minDistance(int[] distance, boolean[] sptSet) {
    int min = Integer.MAX_VALUE;
    int min_index = -1;
    for(int i = 0; i < this.v; i++) {
      if(sptSet[i] == false && distance[i] <= min) {
        min = distance[i];
        min_index = i;
      }
    }
    return min_index;
  }


  public static void main(String[] args) {
    Dijkstra d = new Dijkstra();
    d.v = 9;
    int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    d.dijkstra(graph, 0);
  }

}
