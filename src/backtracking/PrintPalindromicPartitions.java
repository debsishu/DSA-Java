// THIS IS NOT A BACKTRACKING QUESTION, THIS IS A RECURSION QUESTION

package backtracking;

import java.util.*;

public class PrintPalindromicPartitions {

  // This is the GFG code
  static boolean checkPalindrome(String str) {
    int len = str.length();
    len--;
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) != str.charAt(len)) {
        return false;
      }
      len--;
    }
    return true;
  }

  static void printSolution(ArrayList<ArrayList<String>> partitions) {
    for (ArrayList<String> i : partitions) {
      for (String j : i) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  static ArrayList<ArrayList<String>> addStrings(ArrayList<ArrayList<String>> v, String s, ArrayList<String> temp,
      int index) {
    int len = s.length();
    String str = "";
    ArrayList<String> current = new ArrayList<>(temp);

    if (index == 0) {
      temp.clear();
    }

    for (int i = index; i < len; i++) {
      str = str + s.charAt(i);

      if (checkPalindrome(str)) {
        temp.add(str);
        if (i + 1 < len) {
          v = addStrings(v, s, temp, i + 1);
        } else {
          v.add(temp);
        }
        temp = new ArrayList<>(current);
      }
    }
    return v;
  }

  static void partition(String s, ArrayList<ArrayList<String>> v) {
    ArrayList<String> temp = new ArrayList<>();
    v = addStrings(v, s, temp, 0);
    printSolution(v);
  }

  public static void main(String[] args) {
    String s = "geeks";
    // ArrayList<ArrayList<String>> partitons = new ArrayList<>();
    // partition(s, partitons);
    palindrome(s, "");
  }

  // This is the easier version
  static void palindrome(String str, String sofar) {
    if (str.length() == 0) {
      System.out.println(sofar);
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      String prefix = str.substring(0, i + 1);
      String rest = str.substring(i + 1);
      if (isPalindrome(prefix)) {
        palindrome(rest, sofar + prefix + " ");
      }
    }
  }

  public static boolean isPalindrome(String str) {
    int li = 0;
    int ri = str.length() - 1;
    while (li < ri) {
      char left = str.charAt(li);
      char right = str.charAt(ri);
      if (left != right) {
        return false;
      }
      li++;
      ri--;
    }
    return true;
  }

}
