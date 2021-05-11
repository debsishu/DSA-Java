package backtracking;

import java.util.*;

public class RemoveInvalidParentheses {

  // Checks if character in parenthersis or not
  static boolean isParenthesis(char c) {
    return ((c == '(') || (c == ')'));
  }

  // Checks is a string has a valid parenthesis or not
  static boolean isValidString(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        count++;
      } else if (str.charAt(i) == ')') {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return (count == 0);
  }

  // Method to remove invalid parenthesis
  static void removeInvalidParentheses(String str) {
    if (str.isEmpty()) {
      return;
    }
    // Visit set to ignore already visited set
    HashSet<String> visit = new HashSet<>();

    // Queue to maintain BFS
    Queue<String> q = new LinkedList<>();

    String temp;
    boolean level = false;

    q.add(str);
    visit.add(str);
    while (!q.isEmpty()) {
      str = q.poll();
      if (isValidString(str)) {
        System.out.println(str);
        // If answer if found, make level true
        // so that valid string of only that level are
        // processed
        level = true;
      }
      if (level) {
        continue;
      }
      for (int i = 0; i < str.length(); i++) {
        if (!isParenthesis(str.charAt(i))) {
          continue;
        }
        // Removing the parenthesis from the string
        // and pushing into queue if not visited already
        temp = str.substring(0, i) + str.substring(i + 1);
        if (!visit.contains(temp)) {
          q.add(temp);
          visit.add(temp);
        }
      }
    }

  }

  public static void main(String[] args) {
    String expression = "(a)())()";
    removeInvalidParentheses(expression);
  }

}
