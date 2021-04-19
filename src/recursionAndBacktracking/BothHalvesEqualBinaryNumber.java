package recursionAndBacktracking;

public class BothHalvesEqualBinaryNumber {
  public static void main(String[] args) {
    generateStrings(4, "", "", 0);
  }

  static void generateStrings(int n, String left, String right, int difference) {
    if (n == 0) {
      if (difference == 0) {
        System.out.print(left + right + " ");
        return;
      }
    }
    if (n == 1) {
      if (difference == 0) {
        System.out.print(left + "0" + right + " ");
        System.out.print(left + "1" + right + " ");
        return;
      }
    }
    if (2 * Math.abs(difference) <= n) {
      generateStrings(n - 2, left + "0", right + "0", difference);
      generateStrings(n - 2, left + "0", right + "1", difference - 1);
      generateStrings(n - 2, left + "1", right + "0", difference + 1);
      generateStrings(n - 2, left + "1", right + "1", difference);
    }
  }
}
