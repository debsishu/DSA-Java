package recursionAndBacktracking;

import java.util.*;

public class PrintAllPermutations {
  // This is a geeksforgeeks problem
  public static void main(String[] args) {
    String str = "ABC";
    int n = str.length();
    permute(str, 0, n - 1);
    Collections.sort(ll);
    System.out.println(ll);
  }

  static ArrayList<String> ll = new ArrayList<>();

  static void permute(String str, int l, int r) {
    // Base case
    if (l == r) {
      ll.add(str);
    } else {
      for (int i = l; i <= r; i++) {
        str = swap(str, l, i);
        permute(str, l + 1, r);
        str = swap(str, l, i);
      }
    }
  }

  // This is for swapping the character positions
  static String swap(String s, int i, int j) {
    char temp;
    char[] charArray = s.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
}
