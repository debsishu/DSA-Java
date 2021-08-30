package dynamicProgramming;

import java.util.Arrays;

public class EggDropping {
	public static void main(String[] args) {
		int floor = 7;
		int egg = 3;
		System.out.println(minAttempts(floor, egg));
	}

	static int minAttempts(int floor, int egg) {
		int t[][] = new int[floor + 1][egg + 1];
		for (int[] i : t) {
			Arrays.fill(i, -1);
		}
		return solve(floor, egg, t);
	}

	static int solve(int floor, int egg, int t[][]) {
		if (floor == 0 || floor == 1) {
			return floor;
		}
		if (egg == 0) {
			return 0;
		}
		if (egg == 1) {
			return floor;
		}
		if (t[floor][egg] != -1) {
			return t[floor][egg];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= floor; i++) {
			int temp = Math.max(solve(i - 1, egg - 1, t), solve(floor - i, egg, t)) + 1;
			if (temp < min) {
				min = temp;
			}
		}
		return t[floor][egg] = min;
	}
}
