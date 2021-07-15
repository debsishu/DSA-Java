package searching;

public class InterpolationSearch {
	public static void main(String[] args) {
		int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };
		System.out.println(interpolationSearch(arr, 0, arr.length - 1, 18));
	}

	static int interpolationSearch(int arr[], int low, int high, int x) {
		if (low <= high && x >= arr[low] && x <= arr[high]) {
			// This is the formula
			int pos = low + (((high - low) / (arr[high] - arr[low])) * (x - arr[low]));

			if (arr[pos] == x) {
				return pos;
			}
			if (arr[pos] < x) {
				return interpolationSearch(arr, pos + 1, high, x);
			}
			if (arr[pos] > x) {
				return interpolationSearch(arr, low, pos - 1, x);
			}
		}
		return -1;
	}
}
