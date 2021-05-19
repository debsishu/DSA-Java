package backtracking;

public class PartitionArrayKSubsetsGFG {

  public static void main(String[] args) {
    int arr[] = { 2, 1, 4, 5, 6 };
    int k = 3;
    int n = arr.length;
    System.out.println(isKPartitionPossible(arr, n, k));
  }

  static boolean flag;

  static boolean isKPartitionPossible(int arr[], int n, int k) {
    if (n < k || n == 0 || k == 0) {
      return false;
    }
    if (k == 1) {
      return true;
    }
    flag = false;
    int subsetSum[] = new int[k];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }
    if (sum % k > 0) {
      return false;
    } else {
      solve(arr, 0, n, k, subsetSum, 0);
      return flag;
    }
  }

  static void solve(int arr[], int current, int n, int k, int subsetSum[], int sofar) {

    // Base case
    if (current == n) {
      // If we have filled up all the K subsets
      if (sofar == k) {
        boolean check = true;
        // Checking for the values of the subsets
        // if they are same or not
        for (int j = 0; j < k - 1; j++) {
          if (subsetSum[j] != subsetSum[j + 1]) {
            check = false;
            break;
          }
        }
        // If yes make flag true
        if (check) {
          flag = true;
        }
      }
      return;
    }

    for (int j = 0; j < k; j++) {
      // If we are adding to an already filled subset
      if (subsetSum[j] > 0) {
        subsetSum[j] += arr[current];
        // We only increase the current index
        solve(arr, current + 1, n, k, subsetSum, sofar);
        // BACKTRACKING
        subsetSum[j] -= arr[current];
      } else {
        // If we are adding it to an new empty subset
        subsetSum[j] += arr[current];
        // We increment both the current and sofar
        solve(arr, current + 1, n, k, subsetSum, sofar + 1);
        // BACKTRACKING
        subsetSum[j] -= arr[current];
        break;
      }
    }
  }

}
