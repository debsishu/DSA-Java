package sorting;

public class SelectionSort {

	// In-place sorting algorithm
	// TIME : O(N2)
	public static void main(String[] args) {
		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		selectionSort(arr);
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(arr, min, i);
			}
		}
	}

	private static void swap(int arr[], int min, int i) {
		int temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;
	}
}
