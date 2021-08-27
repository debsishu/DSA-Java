package dynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		int arr[] = { 40, 20, 30, 10, 30 };
		System.out.println(determineCost(arr));
	}

	static int determineCost(int arr[]) {
		// 1. Find i and j
		int t[][] = new int[arr.length][arr.length];
		for (int[] i : t) {
			Arrays.fill(i, -1);
		}
		return solve(arr, 1, arr.length - 1, t);
	}

	static int solve(int arr[], int i, int j, int t[][]) {
		// 2. base condition
		if (i >= j) {
			return 0;
		}

		if (t[i][j] != -1) {
			return t[i][j];
		}
		int min = Integer.MAX_VALUE;
		// 3. Finding the right scheme for loop
		for (int k = i; k <= j - 1; k++) {
			int tempAns = solve(arr, i, k, t) + solve(arr, k + 1, j, t) + (arr[i - 1] * arr[k] * arr[j]);
			// 4. updating the right answer
			if (tempAns < min) {
				min = tempAns;
			}
		}
		// This is memorization
		return t[i][j] = min;
	}
}
