package searching;

import java.util.Arrays;

public class EKO {
	public static void main(String[] args) {
		int arr[] = { 4, 42, 40, 26, 46 };
		System.out.println(cutTrees(arr, 5, 20));
	}

	static int cutTrees(int arr[], int n, int height) {
		Arrays.sort(arr);
		int low = 0;
		int high = arr[n - 1];
		int res = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isPossible(arr, height, mid)) {
				res = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return res;
	}

	static boolean isPossible(int arr[], int height, int res) {
		int tillNow = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < res) {
				continue;
			} else {
				tillNow += arr[i] - res;
			}
		}
		return tillNow >= height;
	}
}
