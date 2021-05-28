package graphSeries;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class GraphRepAdj {
  public static void main(String[] args) {
    int n = 3;
    int m = 3;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<Integer>());
    }

    // Edge between 1 and 2
    adj.get(1).add(2);
    adj.get(2).add(1);

    // Edge between 2 and 3
    adj.get(2).add(3);
    adj.get(3).add(2);

    // Edge between 1 and 3
    adj.get(1).add(3);
    adj.get(3).add(1);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(adj.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}
