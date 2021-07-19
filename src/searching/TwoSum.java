package searching;

import java.util.*;

public class TwoSum {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 2, 6, 9 };
		twoSum2(arr, 7);
	}

	// This is the general two sum problem solution
	// In this case array needed to be sorted
	// O(nlogn)
	static void twoSum1(int arr[], int k) {
		int i = 0;
		int j = arr.length - 1;
		Arrays.sort(arr);
		for (i = 0; i < arr.length; i++) {
			int temp = arr[i] + arr[j];
			if (temp == k) {
				System.out.println(arr[i] + " " + i + " " + arr[j] + " " + j);
				break;
			} else if (temp < k) {
				i++;
			} else {
				j--;
			}
		}
	}

	// This representation is of HashMap
	// This is a O(n) solution with o(n) space complexity
	static void twoSum2(int arr[], int k) {
		if (arr.length == 2) {
			return;
		}
		// HashMap<Value, Index>
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				System.out.println(map.get(arr[i]) + 1 + " " + (i + 1));
				break;
			} else {
				map.put(k - arr[i], i);
			}
		}
	}
}
