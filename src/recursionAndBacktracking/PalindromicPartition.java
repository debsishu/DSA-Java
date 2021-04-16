package recursionAndBacktracking;

import java.util.*;

public class PalindromicPartition {
  public static void main(String[] args) {
    String s = "nitin";
    allPartitions(s);
  }

  static void allPossibles(String s) {
    for (int i = 0; i <= s.length(); i++) {
      for (int j = i; j <= s.length(); j++) {
        String subString = s.substring(i, j);
        if (isPalindrome(subString)) {
          System.out.print(subString + " ");
        }
      }
      System.out.println();
    }
  }

  // always use equals() method for comparing strings
  static boolean isPalindrome(String s) {
    String rev = reverseString(s);
    if (rev.equals(s)) {
      return true;
    }
    return false;
  }

  static String reverseString(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }
    return reverseString(s.substring(1, s.length())) + s.charAt(0);
  }

  // @SuppressWarnings("unused")
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
      if (isPalindrome(s.substring(start, i + 1))) {

        currPart.addLast(s.substring(start, i + 1));

        allPartitionsUtil(allPart, currPart, i + 1, n, s);

        currPart.removeLast();
      }
    }
  }

}
