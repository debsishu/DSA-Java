package searching;

public class MaxBookAllocation {
	public static void main(String[] args) {

	}

	static int allocateBooks(int arr[], int n, int students) {
		if (students > n) {
			return -1;
		}
		int low = arr[0];
		int high = 0;
		for (int i = 0; i < n; i++) {
			high += arr[i];
			low = Math.min(low, arr[i]);
		}

		int res = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isPossible(arr, mid, students)) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	static boolean isPossible(int arr[], int pages, int m) {
		int count = 0;
		int sumAllocated = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sumAllocated + arr[i] > pages) {
				count++;
				sumAllocated = arr[i];
				if (sumAllocated > pages) {
					return false;
				}
			} else {
				sumAllocated += arr[i];
			}
		}
		if (count < m) {
			return true;
		}
		return false;
	}
}
