package recursionAndBacktracking;

import java.util.*;

public class SubsetSums {
  public static void main(String[] args) {
    int arr[] = { 2, 3 };
    // subsetSums(arr, 0, arr.length - 1, 0);
    subsetSumsIter(arr);
  }

  // Recursive approach
  static void subsetSums(int arr[], int left, int right, int sum) {
    // Print the current subset
    if (left > right) {
      System.out.print(sum + " ");
      return;
    }
    // sum including the array element
    subsetSums(arr, left + 1, right, sum + arr[left]);
    // sum excluding the array element
    subsetSums(arr, left + 1, right, sum);
  }

  // Iterative approach
  static void subsetSumsIter(int arr[]) {
    int n = arr.length;
    int total = 0;
    Set<Integer> set = new HashSet<>();
    set.add(0);
    for (int i = 0; i <= n - 1; i++) {
      set.add(arr[i]);
      total = total + arr[i];
      for(int j = i; j <= n - 1; j++) {
        if(i != j) {
          set.add(arr[i] + arr[j]);
        }
      }
    }
    set.add(total);
    System.out.println(set);
  }

}
