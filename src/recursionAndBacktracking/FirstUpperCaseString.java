package recursionAndBacktracking;

public class FirstUpperCaseString {
  public static void main(String[] args) {
    String s = "debSisHu";
    printFirstUpper(s, 0);
  }
  static void printFirstUpper(String s, int n) {
    if(n < s.length()) {
      if(Character.isUpperCase(s.charAt(n))) {
        System.out.println(s.charAt(n));
        return;
      }
      printFirstUpper(s, n + 1);
    }
  }
}
