package misc;

import java.util.*;

public class TicketCounter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      // sc.close();
      Deque<Integer> q = new ArrayDeque<>();
      for (int i = 1; i <= n; i++) {
        q.addLast(i);
      }
      while (q.size() != 1) {
        int i = k;
        while (i-- > 0 && q.size() != 1) {
          q.pollFirst();
        }
        if(q.size() == 1) {
          break;
        }
        i = k;
        while(i-- > 0 && q.size() != 1) {
          q.pollLast();
        }
        if(q.size() == 1) {
          break;
        }
      }
      System.out.println(q.peekFirst());
      q.pollFirst();
    }
    sc.close();
  }
}
