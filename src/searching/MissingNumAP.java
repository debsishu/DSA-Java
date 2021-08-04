package searching;

public class MissingNumAP {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 8, 10, 12, 14 };
		System.out.println(missingNum(arr));
	}

	static int missingNum(int arr[]) {
		int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
		return findMissingUtil(arr, 0, arr.length - 1, diff);
	}

	private static int findMissingUtil(int[] arr, int low, int high, int diff) {
		// Their must be two elements for finding the missing element
		if (high <= low) {
			return Integer.MAX_VALUE;
		}

		int mid = low + (high - low) / 2;

		// If the missing element is the element after the mid
		if (arr[mid + 1] - arr[mid] != diff) {
			return (arr[mid] + diff);
		}

		// If the missing element is the element before the middle element
		if (mid > 0 && arr[mid] - arr[mid - 1] != diff) {
			return (arr[mid - 1] + diff);
		}

		// If all the elements before mid are following the AP then the missing element
		// is in the right part
		if (arr[mid] == arr[0] + mid * diff) {
			return findMissingUtil(arr, mid + 1, high, diff);
		}
		// else it is in the left part
		return findMissingUtil(arr, low, mid - 1, diff);
	}
}
