package recursionAndBacktracking;

public class LengthOfStringRecursion {
  public static void main(String[] args) {
    String s = "GEEKSFORGEEKS";
    System.out.println(count(s));
  }

  static int count(String s, int n) {
    if (n == 1) {
      return 1;
    }
    return count(s, n - 1) + 1;
  }

  static int count(String s) {
    if (s.equals("")) {
      return 0;
    } else {
      return count(s.substring(1)) + 1;
    }
  }
}
