package searching;

public class ThePaintersPartition {
	public static void main(String[] args) {
		int arr[] = { 5, 10, 30, 20, 15 };
		int k = 3;
		int n = 5;
		System.out.println(midTime(arr, n, k));
	}

	static int midTime(int arr[], int n, int k) {
		int low = 0;
		int high = 1;

		for (int e : arr) {
			low = Math.max(low, e);
			high += e;
		}

		int ans = 0;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (isPrintPossible(arr, n, mid, k)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean isPrintPossible(int[] arr, int n, int mid, int k) {
		int count = 1;
		int sum = arr[0];
		for (int i = 1; i < n; i++) {
			if (sum + arr[i] <= mid) {
				sum += arr[i];
			} else {
				count++;
				sum = arr[i];
			}
		}
		if (count > k) {
			return false;
		} else {
			return true;
		}
	}

}
