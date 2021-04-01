package graph;

import java.util.*;

public class Graph {

  private int v; // v is the number of vertices

  private LinkedList<Integer> adj[];

  @SuppressWarnings("unchecked")
  public Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public void DFSUntil(int v, boolean visited[]) {
    visited[v] = true;
    System.out.print(v + " ");
    // System.out.println("\n" + v + " ");
    Iterator<Integer> i = adj[v].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      // System.out.print("v = " + v + " n = " + n + "\n");
      if (!visited[n]) {
        DFSUntil(n, visited);
      }
    }
  }

  public void DFS(int v) {
    boolean visited[] = new boolean[this.v];
    // this is the case if the graph is disconnected
    for (int i = 0; i < this.v; i++) {
      if (visited[i] == false) {
        DFSUntil(i, visited);
      }
    }
  }

  public void BFS(int s) {
    boolean visited[] = new boolean[this.v];
    Queue<Integer> queue = new LinkedList<>();
    visited[s] = true;
    queue.add(s);
    while (queue.size() != 0) {
      s = queue.poll();
      System.out.print(s + " ");
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  public void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
    visited[v] = true;
    Integer i;
    Iterator<Integer> it = adj[v].iterator();
    while (it.hasNext()) {
      i = it.next();
      if (!visited[i]) {
        topologicalSortUtil(i, visited, stack);
      }
    }
    stack.push(v);
  }

  public void topologicalSort() {
    Stack<Integer> stack = new Stack<>();
    boolean visited[] = new boolean[this.v];
    for (int i = 0; i < this.v; i++) {
      visited[i] = false;
    }
    for (int i = 0; i < this.v; i++) {
      if(visited[i] == false) {
        topologicalSortUtil(i, visited, stack);
      }
    }
    while(!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph(6);
    // g.addEdge(0, 1);
    // g.addEdge(0, 2);
    // g.addEdge(1, 2);
    // g.addEdge(2, 0);
    // g.addEdge(2, 3);
    // g.addEdge(3, 3);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    // System.out.println("DFS of this graph is");
    // g.DFS(3);
    // System.out.println();
    // g.BFS(2);
    g.topologicalSort();
  }
}
