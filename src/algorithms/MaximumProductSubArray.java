package algorithms;

public class MaximumProductSubArray {
  public static void main(String[] args) {
    int arr[] = {6, -3, -10, 0, 2};
    System.out.println(maxProduct(arr));
  }

  public static int maxProduct(int arr[]) {
    int currMax = arr[0];
    int prevMax = arr[0];
    int prevMin = arr[0];
    int sum = arr[0];
    for(int i = 1; i < arr.length; i++) {
      currMax = Math.max(prevMax * arr[i], Math.max(prevMin * arr[i], arr[i]));
      int currMin = Math.min(prevMax * arr[i], Math.min(prevMin * arr[i], arr[i]));
      sum = Math.max(sum, currMax);
      prevMax = currMax;
      prevMin = currMin;
    }
    return sum;
  }
}
