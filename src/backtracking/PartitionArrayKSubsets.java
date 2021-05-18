package backtracking;

import java.util.ArrayList;

public class PartitionArrayKSubsets {

  public static void main(String[] args) {
    int arr[] = { 2, 1, 4, 5, 6 };
    int k = 3;
    int n = arr.length;
    partitons(arr, k, n);
  }

  static void partitons(int arr[], int k, int n) {
    if (k == 1) {
      System.out.print("[");
      for (int e : arr) {
        System.out.print(e + ", ");
      }
      System.out.println("]");
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    if (k > n || sum % k != 0) {
      System.out.println("Partitons is not possible");
      return;
    }

    int subsetSum[] = new int[k];
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ans.add(new ArrayList<>());
    }
    partitonsUtil(arr, 0, n, k, subsetSum, 0, ans);

  }

  static void partitonsUtil(int arr[], int vidx, int n, int k, int subsetSum[], int sofar,
      ArrayList<ArrayList<Integer>> ans) {
    if (vidx == arr.length) {
      if (sofar == k) {
        boolean flag = true;
        for (int i = 0; i < subsetSum.length - 1; i++) {
          if (subsetSum[i] != subsetSum[i + 1]) {
            flag = false;
            break;
          }
        }
        if (flag) {
          for (ArrayList<Integer> partiton : ans) {
            System.out.print(partiton + " ");
          }
        }
      }
      return;
    }

    for (int i = 0; i < ans.size(); i++) {
      if (ans.get(i).size() > 0) {
        ans.get(i).add(arr[vidx]);
        subsetSum[i] += arr[vidx];
        partitonsUtil(arr, vidx + 1, n, k, subsetSum, sofar, ans);
        subsetSum[i] -= arr[vidx];
        ans.get(i).remove(ans.get(i).size() - 1);
      } else {
        ans.get(i).add(arr[vidx]);
        subsetSum[i] += arr[vidx];
        partitonsUtil(arr, vidx + 1, n, k, subsetSum, sofar + 1, ans);
        subsetSum[i] -= arr[vidx];
        ans.get(i).remove(ans.get(i).size() - 1);
        break;
      }
    }
  }

}
