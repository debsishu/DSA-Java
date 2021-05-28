package backtracking;

import java.util.*;

public class TugOfWar {
  public static void main(String[] args) {
    int arr[] = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
    solveTugOfWar(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
    System.out.println(ans);
  }

  static int minDiff = Integer.MAX_VALUE;
  static String ans = "";

  static void solveTugOfWar(int arr[], int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
      int soset2) {

    if (vidx == arr.length) {
      int temp = Math.abs(soset1 - soset2);
      if (temp < minDiff) {
        minDiff = temp;
        ans = set1 + " " + set2;
      }
      return;
    }

    if (set1.size() < (arr.length + 1) / 2) {
      set1.add(arr[vidx]);
      solveTugOfWar(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2);
      set1.remove(set1.size() - 1);
    }

    if (set2.size() < (arr.length + 1) / 2) {
      set2.add(arr[vidx]);
      solveTugOfWar(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]);
      set2.remove(set2.size() - 1);
    }
  }
}
