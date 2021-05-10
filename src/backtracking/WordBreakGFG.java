package backtracking;

import java.util.*;

public class WordBreakGFG {

  static List<String> wordBreak(int dictLength, List<String> dict, String str) {
    List<String> result = new ArrayList<>();
    int stringLength = str.length();
    wordBreakUtil(dictLength, dict, str, stringLength, result, "");
    return result;
  }

  private static void wordBreakUtil(int dictLength, List<String> dict, String s, int stringLength,
      List<String> resultList, String result) {
    for (int i = 1; i <= stringLength; i++) {
      if (contains(dict, s.substring(0, i))) {
        if (i == stringLength) {
          result += s.substring(0, i);
          resultList.add(result);
          return;
        }
        wordBreakUtil(dictLength, dict, s.substring(i, stringLength), stringLength - i, resultList,
            result + s.substring(0, i) + " ");
      }
    }
  }

  private static boolean contains(List<String> dict, String str) {
    int m = dict.size();
    for (int i = 0; i < m; i++) {
      if (dict.get(i).equals(str)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String dictionary[] = { "cats", "cat", "and", "sand", "dog" };
    String str = "catsanddog";
    List<String> dict = Arrays.asList(dictionary);
    List<String> ll = wordBreak(5, dict, str);
    System.out.println(ll);
  }

}
