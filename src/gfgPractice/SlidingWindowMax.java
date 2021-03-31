package gfgPractice;

import java.util.*;

public class SlidingWindowMax {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    ArrayList<Integer> result = slidingWindow(arr, 3);
    for(int e : result) {
      System.out.println(e);
    }
  }

  public static ArrayList<Integer> slidingWindow(int arr[], int k) {
    ArrayList<Integer> res = new ArrayList<>();
    Deque<Integer> q = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
        q.pollLast();
      }
      q.addLast(i);
    }
    for (int i = k; i < arr.length; i++) {
      res.add(arr[q.peekFirst()]);
      while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
        q.pollLast();
      }
      while(!q.isEmpty() && q.peekFirst() <= i - k) {
        q.pollFirst();
      }
      q.addLast(i);
    }
    res.add(arr[q.peekFirst()]);
    return res;
  }
}
