// This is a Dynamic Programming question
// This solution will give TLE

package backtracking;

// This is not a backtracking solution

public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    int arr[] = { 1, 5, 11, 5 };
    int n = arr.length;
    System.out.println(equalPartition(n, arr));
  }

  // helper function
  static boolean equalPartition(int n, int arr[]) {
    int total = 0;
    for (int e : arr) {
      total += e;
    }
    if (total % 2 != 0) {
      return false;
    }
    return isPossible(arr, 0, 0, total);
  }

  static boolean isPossible(int arr[], int index, int sum, int total) {
    // If we have to divide an array into two parts
    // the first part will always be the 2 multiply of the total
    if (sum * 2 == total) {
      return true;
    }
    // Base Case
    if (sum > total / 2 || index >= arr.length) {
      return false;
    }
    // Either we take the current element in the
    // sum or we dont take that in that sum
    return isPossible(arr, index + 1, sum, total) || isPossible(arr, index + 1, sum + arr[index], total);
  }
}
