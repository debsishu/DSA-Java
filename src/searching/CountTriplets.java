// Given an array arr[] of distinct integers of size
// N and a sum value X, the task is to find count of
// triplets with the sum smaller than the given sum value X.

package searching;

import java.util.Arrays;

public class CountTriplets {
	public static void main(String[] args) {
		int arr[] = { -2, 0, 1, 3 };
		System.out.println(countTriplets(arr, arr.length, 2));
	}

	static int countTriplets(int arr[], int n, int num) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < n - 2; i++) {
			int target = num - arr[i];
			int low = i + 1;
			int high = n - 1;
			while (low < high) {
				if (arr[low] + arr[high] > target) {
					high--;
				} else {
					count = count + (high - low);
					low++;
				}
			}
		}
		return count;
	}
}
