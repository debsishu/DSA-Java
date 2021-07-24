package searching;

import java.util.HashMap;

public class ZeroSumSubarrays {
	public static void main(String[] args) {
		int arr[] = { 0, 0, 5, 5, 0, 0 };
		int arr2[] = { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		System.out.println(zeroSumSubarray(arr, arr.length));
		System.out.println(zeroSumSubarray(arr2, arr2.length));
	}

	static int zeroSumSubarray(int arr[], int n) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (!map.containsKey(sum)) {
				map.put(sum, 1);
			} else {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			}
		}
		return count;
	}
}
