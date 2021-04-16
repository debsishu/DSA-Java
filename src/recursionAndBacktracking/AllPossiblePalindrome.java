package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class AllPossiblePalindrome {
  public static void main(String[] args) {
    String s = "nitin";
    allPartitions(s);
  }

  static void allPartitions(String s) {
    int n = s.length();
    ArrayList<ArrayList<String>> allPart = new ArrayList<>();
    Deque<String> currPart = new LinkedList<>();
    allPartitionsUtil(allPart, currPart, 0, n, s);
    for (int i = 0; i < allPart.size(); i++) {
      for (int j = 0; j < allPart.get(i).size(); j++) {
        System.out.print(allPart.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  private static void allPartitionsUtil(ArrayList<ArrayList<String>> allPart, Deque<String> currPart, int start, int n,
      String s) {
    if (start >= n) {
      allPart.add(new ArrayList<>(currPart));
      return;
    }
    for (int i = start; i < n; i++) {
      if (isPalindrome(s, start, i)) {
        currPart.addLast(s.substring(start, i + 1));
        allPartitionsUtil(allPart, currPart, i + 1, n, s);
        currPart.removeLast();
      }
    }
  }

  private static boolean isPalindrome(String s, int start, int i) {
    while (start < i) {
      if (s.charAt(start++) != s.charAt(i--)) {
        return false;
      }
    }
    return true;
  }
}
