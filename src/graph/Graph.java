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
      if (visited[i] == false) {
        topologicalSortUtil(i, visited, stack);
      }
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }

  public boolean isCycleUndirected() {
    boolean visited[] = new boolean[this.v];
    for (int i = 0; i < this.v; i++) {
      if (visited[i] == false) {
        if (checkCycleDFSUndirected(i, -1, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean checkCycleDFSUndirected(int s, int p, boolean[] visited) {
    visited[s] = true;
    Iterator<Integer> it = adj[s].iterator();
    while (it.hasNext()) {
      int i = it.next();
      if (visited[i] == false) {
        if (checkCycleDFSUndirected(i, s, visited) == true) {
          return true;
        }
      } else if (i != p || i == s) {
        return true;
      }
    }
    return false;
  }

  public boolean isCycleDirected() {
    boolean visited[] = new boolean[this.v];
    // this keeps a track of if the vertice is already in the recursive call stack
    // or not
    boolean isRecur[] = new boolean[this.v];
    for (int i = 0; i < this.v; i++) {
      if (visited[i] == false) {
        if (checkCycleDFSDirected(i, visited, isRecur)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean checkCycleDFSDirected(int s, boolean[] visited, boolean[] isRecur) {
    visited[s] = true;
    isRecur[s] = true;
    Iterator<Integer> it = adj[s].iterator();
    while (it.hasNext()) {
      int i = it.next();
      if (visited[i] == false && checkCycleDFSDirected(i, visited, isRecur)) {
        return true;
      } else if (isRecur[i] == true && i == s) {
        return true;
      }
    }
    // this keeps track of the elements which are removed from the call stack
    isRecur[s] = false;
    return false;
  }

  public void topoLogicalSortKahnAlgo() {
    int indegree[] = new int[this.v];
    for (int i = 0; i < this.v; i++) {
      Iterator<Integer> it = adj[i].iterator();
      while (it.hasNext()) {
        int u = it.next();
        indegree[u]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < this.v; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int count = 0;

    ArrayList<Integer> topOrder = new ArrayList<>();
    while (!q.isEmpty()) {
      int u = q.poll();
      topOrder.add(u);
      Iterator<Integer> it = adj[u].iterator();
      while (it.hasNext()) {
        int i = it.next();
        if (--indegree[i] == 0) {
          q.add(i);
        }
      }
      count++;
    }

    if (count != this.v) {
      System.out.println("Their exists a cycle in the graph");
      return;
    }
    for (int e : topOrder) {
      System.out.print(e + " ");
    }
    System.out.println();
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
    // Dank Mono, Fira Code, Inconsolata
    g.topoLogicalSortKahnAlgo();
  }
}
