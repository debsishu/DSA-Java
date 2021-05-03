package recursionAndBacktracking;

import java.util.*;

public class PrintAllSubsequnces {
  public static void main(String[] args) {
    String s = "abcd";
    printAll(s, "");
    System.out.println(al);
  }

  static ArrayList<String> al = new ArrayList<>();

  static void printAll(String s, String ans) {
    if (s.length() == 0) {
      al.add(ans);
      return;
    }
    printAll(s.substring(1), ans + s.charAt(0));
    printAll(s.substring(1), ans);
  }
}
