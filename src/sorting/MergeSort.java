package sorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 12, 3, 1, 4, 2, 15 };
		mergeSort(arr, 0, arr.length - 1);
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	static void mergeSort(int arr[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			mergeArray(arr, low, mid, high);
		}
	}

	static void mergeArray(int arr[], int low, int mid, int high) {
		int leftSize = mid - low + 1;
		int rightSize = high - mid;

		int left[] = new int[leftSize];
		int right[] = new int[rightSize];

		for (int i = 0; i < leftSize; i++) {
			left[i] = arr[low + i];
		}
		for (int i = 0; i < rightSize; i++) {
			right[i] = arr[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = low;
		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < leftSize) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
}
