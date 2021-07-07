package sorting;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 2, 8, 7, 1, 3, 5, 6, 4 };
		quickSort(arr, 0, arr.length - 1);
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	static void quickSort(int arr[], int low, int high) {
		if (high > low) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	static int partition(int arr[], int low, int high) {
		int left = low;
		int right = high;
		int pivot = arr[low];

		while (left < right) {
			while (arr[left] <= pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left < right) {
				swap(arr, left, right);
			}
		}
		arr[low] = arr[right];
		arr[right] = pivot;
		return right;
	}

	private static void swap(int arr[], int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

}
