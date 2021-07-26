package searching;

import java.util.HashMap;

public class SubarraySumK {
	public static void main(String[] args) {
		int arr[] = { 10, 2, -2, -20, 10 };
		System.out.println(findSubArraySum(arr, arr.length, -10));
	}

	static int findSubArraySum(int arr[], int n, int target) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int res = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			int remSum = sum - target;
			if (map.containsKey(remSum)) {
				res += map.get(remSum);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
}
