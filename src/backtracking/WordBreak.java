package backtracking;

import java.util.*;

public class WordBreak {

  public static void main(String[] args) {
    String dictionary[] = { "cats", "cat", "and", "sand", "dog" };
    HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
    String str = "catsanddog";
    wordBreak(str, "", dict);
    System.out.println(res);
  }

  static List<String> res = new ArrayList<>();

  static void wordBreak(String str, String result, HashSet<String> dict) {
    if (str.length() == 0) {
      res.add(result);
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      String left = str.substring(0, i + 1);
      if (dict.contains(left)) {
        String right = str.substring(i + 1);
        wordBreak(right, result + left + " ", dict);
      }
    }
  }

}
