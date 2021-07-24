// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#

package searching;

import java.util.HashMap;

public class LargestSubarrayZeroSum {
	public static void main(String[] args) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println(largestSubarray(arr, arr.length));
	}

	static int largestSubarray(int arr[], int n) {
		// Map of sum and it's index
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int sum = 0;
		map.put(0, -1);
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			} else {
				int length = i - map.get(sum);
				max = Math.max(length, max);
			}
		}
		return max;
	}
}
