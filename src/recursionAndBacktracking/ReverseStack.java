package recursionAndBacktracking;

import java.util.*;

public class ReverseStack {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    reverse(s);
    System.out.println(s);
  }

  static void reverse(Stack<Integer> s) {
    if (s.size() > 1) {
      int temp = s.pop();
      reverse(s);
      insertAtBottom(s, temp);
    }
  }

  private static void insertAtBottom(Stack<Integer> s, int temp) {
    if (s.isEmpty()) {
      s.push(temp);
    } else {
      int item = s.pop();
      insertAtBottom(s, temp);
      s.push(item);
    }
  }

}
