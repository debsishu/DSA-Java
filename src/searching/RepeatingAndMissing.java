package searching;

import java.util.HashSet;

public class RepeatingAndMissing {
	public static void main(String[] args) {
		int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
		int res[] = repeatingAndMissingMod(arr, arr.length);
		System.out.println(res[0] + " " + res[1]);
	}

	// This is O(n) solution with O(n) space complexity
	static int[] repeatingAndMissing(int arr[], int size) {
		int res[] = new int[2];

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < size; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
			} else {
				res[0] = arr[i];
			}
		}

		for (int i = 1; i <= size; i++) {
			if (!set.contains(i)) {
				res[1] = i;
				break;
			}
		}
		return res;
	}

	// This is O(n) solution but we need to modify the source array
	static int[] repeatingAndMissingMod(int arr[], int n) {
		int res[] = new int[2];

		for (int i = 0; i < n; i++) {
			int abs = Math.abs(arr[i]);
			if (arr[abs - 1] > 0) {
				arr[abs - 1] = -arr[abs - 1];
			} else {
				res[0] = abs;
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				res[1] = i + 1;
			}
		}
		return res;
	}
}
