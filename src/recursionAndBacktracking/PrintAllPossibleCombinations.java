package recursionAndBacktracking;

import java.util.*;

public class PrintAllPossibleCombinations {
  public static void main(String[] args) {

    int arr[] = { 1, 2, 3, 4 };
    int r = 3;
    printAllComb(arr, r);

  }

  // check out this solution

  static void printAllComb(int arr[], int r) {
    ArrayList<Integer> ll = new ArrayList<>();
    printAllCombUtil(arr, r, ll, 0);
  }

  static void printAllCombUtil(int arr[], int r, ArrayList<Integer> ll, int start) {
    if (ll.size() >= r) {
      System.out.println(ll);
      return;
    }
    for (int i = start; i < arr.length; i++) {
      ll.add(arr[i]);
      printAllCombUtil(arr, r, ll, i + 1);
      ll.remove(ll.size() - 1);
    }
  }

  // Not understood correctly in this implementation

  static void printCombination(int arr[], int n, int r) {
    int data[] = new int[r];
    combinationUtil(arr, data, 0, n - 1, 0, r);
  }

  static void combinationUtil(int[] arr, int[] data, int start, int end, int index, int r) {
    if (index == r) {
      for (int j = 0; j < r; j++) {
        System.out.print(data[j] + " ");
      }
      System.out.println();
      return;
    }
    for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
      data[index] = arr[i];
      combinationUtil(arr, data, i + 1, end, index + 1, r);
    }
  }

}
