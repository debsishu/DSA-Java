package dynamicProgramming;

import java.util.Arrays;

public class EggDroppingOptimized {
	public static void main(String[] args) {
		System.out.println(minAttempts(3, 7));
	}

	// This uses the same concept but used binary traversal(binary search) instead
	// of linear traversal

	static int minAttempts(int egg, int floor) {
		int t[][] = new int[egg + 1][floor + 1];
		for (int[] i : t) {
			Arrays.fill(i, -1);
		}
		return solve(egg, floor, t);
	}

	private static int solve(int egg, int floor, int[][] t) {
		if (floor == 0 || floor == 1) {
			return floor;
		}
		if (egg == 1) {
			return floor;
		}

		if (t[egg][floor] != -1) {
			return t[egg][floor];
		}

		int min = Integer.MAX_VALUE;
		int low = 1;
		int high = floor;
		while (low <= high) {
			int mid = (low + high) / 2;

			int left = solve(egg - 1, mid - 1, t);
			int right = solve(egg, floor - mid, t);

			int temp = 1 + Math.max(left, right);
			if (left < right) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			if (temp < min) {
				min = temp;
			}
		}
		return t[egg][floor] = min;
	}
}
