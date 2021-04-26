package recursionAndBacktracking;

public class MinMaxOfArray {
  public static void main(String[] args) {
    int arr[] = { 12, 1234, 45, 67, 1 };
    System.out.println(arr.length);
    System.out.println(getMax(arr, 0, arr.length));
    System.out.println(getMin(arr, 0, arr.length));
  }

  static int getMin(int arr[], int i, int n) {
    if (n == 1) {
      return arr[i];
    }
    return Math.min(arr[i], getMin(arr, i + 1, n - 1));
  }

  static int getMax(int arr[], int i, int n) {
    if (n == 1) {
      return arr[i];
    }
    return Math.max(arr[i], getMax(arr, i + 1, n - 1));
  }

}
