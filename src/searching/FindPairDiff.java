package searching;

import java.util.Arrays;

public class FindPairDiff {
	public static void main(String[] args) {
		int arr[] = { 5, 20, 3, 2, 5, 80 };
		System.out.println(pairDifference(arr, 78));
	}

	// This is two pointer algorithm with little modification
	static boolean pairDifference(int arr[], int num) {
		Arrays.sort(arr);
		int low = 0;
		int high = 1;
		while (low <= high && high < arr.length) {
			if (arr[high] - arr[low] == num) {
				return true;
			} else if (arr[high] - arr[low] < num) {
				high++;
			} else if (arr[high] - arr[low] > num) {
				low++;
			}
		}
		return false;
	}
}
