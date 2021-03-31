package misc;

import java.util.*;

public class Something {
  public static void main(String[] args) {
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    System.out.println("its clearly working");
    q.add(12);
    q.add(13);
    q.add(42);
    q.add(14);
    while(!q.isEmpty()) {
      System.out.println(q.peek());
      q.poll();
    }
  }
}
