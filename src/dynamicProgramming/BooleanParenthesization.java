package dynamicProgramming;

public class BooleanParenthesization {
	public static void main(String[] args) {
		String s = "T|T&F^T";
		System.out.println(numberOfWays(s));
	}

	static int numberOfWays(String s) {
		s = s.toUpperCase();
		return solve(s.toCharArray(), 0, s.length() - 1, true);
	}

	private static int solve(char[] arr, int i, int j, boolean isTrue) {
		if (i > j) {
			return 0;
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
			int lT = solve(arr, i, k - 1, true);
			int lF = solve(arr, i, k - 1, false);
			int rT = solve(arr, k + 1, j, true);
			int rF = solve(arr, k + 1, j, false);

			if (arr[k] == '|') {
				if (isTrue) {
					ans += ((lT * rF) + (rT * lF) + (lT * rT));
				} else {
					ans += rF * lF;
				}
			} else if (arr[k] == '&') {
				if (isTrue) {
					ans += (lT * rT);
				} else {
					ans += ((lF * rT) + (rF * lT) + (lF * rF));
				}
			} else if (arr[k] == '^') {
				if (isTrue) {
					ans += ((lT * rF) + (lF * rT));
				} else {
					ans += ((lT * rT) + (lF * rF));
				}
			}
		}

		return ans;
	}
}
