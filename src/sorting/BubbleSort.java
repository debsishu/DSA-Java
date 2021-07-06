package sorting;

public class BubbleSort {
  
  // TIME : O(N2)
  public static void main(String[] args) {
    int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    bubbleSort(arr);
    for (int e : arr) {
      System.out.print(e + " ");
    }
    System.out.println();
  }

  public static void bubbleSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swapped = true;
          swap(arr, j, j + 1);
        }
      }
      if (!swapped) {
        break;
      }
    }
  }

  private static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
