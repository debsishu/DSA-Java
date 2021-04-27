package recursionAndBacktracking;

import java.util.Arrays;

public class InsertionSortRecursive {
  public static void main(String[] args) {
    int arr[] = { 12, 11, 13, 5, 6 };
    insertionsort(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  static void insertionsort(int arr[], int n) {
    // this is the base case
    if (n <= 1) {
      return;
    }
    // iterating recursively
    insertionsort(arr, n - 1);

    // storing the last element for the future reference
    int last = arr[n - 1];
    int j = n - 2;

    // moving the remaining elements one position over
    while (j >= 0 && arr[j] > last) {
      arr[j + 1] = arr[j];
      j--;
    }
    // setting the largest element at the last
    arr[j + 1] = last;
  }
}
