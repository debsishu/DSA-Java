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
    if (current == n) {
      if (sofar == k) {
        boolean check = true;
        for (int j = 0; j < k - 1; j++) {
          if (subsetSum[j] != subsetSum[j + 1]) {
            check = false;
            break;
          }
        }
        if (check) {
          flag = true;
        }
      }
      return;
    }

    for (int j = 0; j < k; j++) {
      if (subsetSum[j] > 0) {
        subsetSum[j] += arr[current];
        solve(arr, current + 1, n, k, subsetSum, sofar);
        subsetSum[j] -= arr[current];
      } else {
        subsetSum[j] += arr[current];
        solve(arr, current + 1, n, k, subsetSum, sofar + 1);
        subsetSum[j] -= arr[current];
        break;
      }
    }
  }

}
