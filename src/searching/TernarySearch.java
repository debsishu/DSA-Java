package searching;

public class TernarySearch {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(ternarySearchIter(0, arr.length - 1, 5, arr));
	}

	// Ternary search is similar to binary search
	// Difference is in binary search we divide the array into two parts but in
	// ternary search we divide the array in three parts

	static int ternarySearch(int low, int high, int key, int arr[]) {
		if (high >= low) {
			int mid1 = low + (high - low) / 3;
			int mid2 = high - (high - low) / 3;

			if (arr[mid1] == key) {
				return mid1;
			}
			if (arr[mid2] == key) {
				return mid2;
			}

			if (key < arr[mid1]) {
				return ternarySearch(low, mid1 - 1, key, arr);
			} else if (key > arr[mid2]) {
				return ternarySearch(mid2 + 1, high, key, arr);
			} else {
				return ternarySearch(mid1 + 1, mid2 - 1, key, arr);
			}
		}
		return -1;
	}

	static int ternarySearchIter(int low, int high, int key, int arr[]) {
		while (low <= high) {
			int mid1 = low + (high - low) / 3;
			int mid2 = high - (high - low) / 3;

			if (arr[mid1] == key) {
				return mid1;
			}
			if (arr[mid2] == key) {
				return mid2;
			}

			if (key < arr[mid1]) {
				high = mid1 - 1;
			} else if (key > arr[mid2]) {
				low = mid2 + 1;
			} else {
				low = mid1 + 1;
				high = mid2 - 1;
			}
		}
		return -1;
	}
}
