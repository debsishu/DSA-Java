package dynamicProgramming;

import java.util.HashMap;

public class BooleanParenthesizationMem {
	public static void main(String[] args) {
		String s = "T|T&F^T";
		System.out.println(numberOfWays(s));
	}

	static int numberOfWays(String s) {
		HashMap<String, Integer> t = new HashMap<>();
		s = s.toUpperCase();
		return solve(s.toCharArray(), 0, s.length() - 1, true, t);
	}

	// Your task is to complete the function countWays() which takes N and S as
	// input parameters and returns number of possible ways modulo 1003.

	private static int solve(char[] arr, int i, int j, boolean isTrue, HashMap<String, Integer> t) {
		if (i > j) {
			return 0;
		}
		String s = Integer.toString(i) + Integer.toString(j) + Boolean.toString(isTrue);

		if (t.containsKey(s)) {
			return t.get(s) % 1003;
		}

		if (i == j) {
			if (isTrue) {
				if (arr[i] == 'T') {
					return 1;
				}
			} else {
				if (arr[i] == 'F') {
					return 1;
				}
			}
		}

		int ans = 0;

		for (int k = i + 1; k <= j - 1; k += 2) {
			int lT = solve(arr, i, k - 1, true, t);
			int lF = solve(arr, i, k - 1, false, t);
			int rT = solve(arr, k + 1, j, true, t);
			int rF = solve(arr, k + 1, j, false, t);

			if (arr[k] == '&') {
				if (isTrue) {
					ans += (lT * rT);
				} else {
					ans += ((lT * rF) + (lF * rT) + (lF * rF));
				}
			} else if (arr[k] == '|') {
				if (isTrue) {
					ans += ((lT * rT) + (lT * rF) + (lF * rT));
				} else {
					ans += (lF * rF);
				}
			} else if (arr[k] == '^') {
				if (isTrue) {
					ans += ((lT * rF) + (lF * rT));
				} else {
					ans += ((lT * rT) + (lF * rF));
				}
			}
		}

		t.put(s, ans);
		return ans % 1003;
	}
}
