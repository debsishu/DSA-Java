package searching;

public class SearchInRotatedArray {
	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(arr, 0));
	}

	// Simple binary search with little observation
	// If the array is sorted and rotated their will be a pivot element
	// before the pivot element the array should be sorted and after the pivot
	// element the array should be sorted
	static int search(int arr[], int target) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			// This means the left half is sorted
			if (arr[low] <= arr[mid]) {
				// check if the target is in the left half range
				if (target >= arr[low] && target <= arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				// Check if the target is in the right half range
				if (target >= arr[mid] && target <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
