package recursionAndBacktracking;

import java.util.Arrays;

public class PowerSetLexicographic {

  // this question is not clear 
  public static void main(String[] args) {
    // String str = "cab";
    // powerSet(str);
    String str = "abc";
    int len = str.length();
    int newStr[] = new int[len];
    powerSet1(str, newStr, len, 0);

  }

  static void powerSet(String str) {
    char arr[] = str.toCharArray();
    Arrays.sort(arr);
    permuteRec(new String(arr), str.length(), -1, "");
  }

  static void permuteRec(String str, int n, int index, String curr) {
    if (index == n) {
      return;
    }
    System.out.print(curr + " ");
    for (int i = index + 1; i < n; i++) {
      curr += str.charAt(i);
      permuteRec(str, n, i, curr);
      curr = curr.substring(0, curr.length() - 1);
    }
    return;
  }

  static void powerSet1(String str, int newStr[], int len, int k) {
    if(k == len) {
      for(int i = 0; i < len; i++) {
        if(newStr[i] != 1) {
          System.out.print(str.charAt(i));
        }
      }
      System.out.print(" ");
      return;
    } else {
      for(int choice = 0; choice <= 1; choice++) {
        newStr[k] = choice;
        powerSet1(str, newStr, len, k + 1);
      }
      return;
    }
  }

}
