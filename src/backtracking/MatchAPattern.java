package backtracking;

import java.util.*;

public class MatchAPattern {

  // Watch PEPCODING video
  // Also refer from this link :
  // https://github.com/neerajjain92/data-structures/blob/master/src/com/leetcode/year_2020/backtracking/MatchAPatternAndStringWithoutRegularExpression.java
  public static void main(String[] args) {
    // String str = "GeeksForGeeks";
    String str = "GRAPHGRAPHGRAPH";
    // String pattern = "GfG";
    String pattern = "ABA";
    HashMap<Character, String> map = new HashMap<>();
    matchPattern(str, pattern, map);
  }

  private static void matchPattern(String str, String pattern, HashMap<Character, String> map) {
    // If we scanned all the pattern (Base Case)
    if (pattern.length() == 0) {
      // If the string is also finished we print the graph
      if (str.length() == 0) {
        System.out.println(map);
      }
      return;
    }
    // Get the current pattern character
    char ch = pattern.charAt(0);
    // Stores the rest of the pattern for the next call
    String rest = pattern.substring(1);

    if (map.containsKey(ch)) {
      // get the string from the map
      String previousMapping = map.get(ch);
      if (str.length() >= previousMapping.length()) {
        String left = str.substring(0, previousMapping.length());
        String right = str.substring(previousMapping.length());
        if (previousMapping.equals(left)) {
          matchPattern(right, rest, map);
        }
      }
    } else {
      for (int i = 0; i < str.length(); i++) {
        String left = str.substring(0, i + 1);
        String right = str.substring(i + 1);
        map.put(ch, left);
        matchPattern(right, rest, map);
        map.remove(ch); // Backtracking
      }
    }
  }
}
