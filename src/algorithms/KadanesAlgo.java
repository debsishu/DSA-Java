package algorithms;

public class KadanesAlgo {
  public static void main(String[] args) {
    int arr[] = { 5, -4, -2, 6, 1 };
    System.out.println(maxSumSubarray(arr));
    maxSubarraySum(arr, arr.length);
  }

  //this is the case when the whole array is with negetive values;
  private static int maxSubarraySum(int arr[], int n) {

    int max = arr[0];
    int curr = arr[0];

    for (int i = 1; i < n; i++) {
      curr = Math.max(arr[i], curr + arr[i]);
      max = Math.max(max, curr);
    }

    return max;

  }

  private static int maxSumSubarray(int arr[]) {
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for (int i = 0; i < arr.length; i++) {
      currentSum += arr[i];
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
      if (currentSum < 0) {
        currentSum = 0;
      }
    }
    return maxSum;
  }
}
