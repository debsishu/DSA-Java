package recursionAndBacktracking;

import java.util.*;

public class PrintPatternRec {
  public static void main(String[] args) {
    // printPatternMy(16, 5);
    printPattern(16, 16, true, 5);
  }

  // this is my solution
  static ArrayList<Integer> arr = new ArrayList<>();

  static void printPatternMy(int n, int k) {
    printTIllZero(n, k);
    printAfterZero(arr.get(arr.size() - 1) + k, n, k);
    System.out.println(arr);
  }

  static void printTIllZero(int n, int k) {
    arr.add(n);
    if (n > 0) {
      printTIllZero(n - k, k);
    }
    if (n < 0) {
      return;
    }
  }

  static void printAfterZero(int current, int n, int k) {
    arr.add(current);
    if (current < n) {
      printAfterZero(current + k, n, k);
    }
    if (current > n) {
      return;
    }
    // my solution ends here
  }

  static void printPattern(int limit, int current, boolean flag, int k) {

    // Here flag false means we are adding k
    // if flag is true means we are subtracting k

    // Print the current element
    System.out.print(current + " ");
    // If we are addint k and we get to the end of the series which is n
    if (flag == false && limit == current) {
      return;
    }
    if (flag) {
      // if the current element is greater than zero
      if (current - k > 0) {
        printPattern(limit, current - 5, true, k);
      } else {
        printPattern(limit, current - 5, false, k);
      }
    } else {
      printPattern(limit, current + 5, false, k);
    }
  }

}
