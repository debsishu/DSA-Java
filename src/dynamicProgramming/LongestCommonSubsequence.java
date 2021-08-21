package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "abdefg";

		System.out.println(getLcsDP(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
		// System.out.println(getLcsMem(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length(), dp));
	}

	// This is the recursive solution
	static int getLcs(char str1[], char str2[], int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}

		if (str1[n - 1] == str2[m - 1]) {
			return getLcs(str1, str2, n - 1, m - 1) + 1;
		} else {
			return Math.max(getLcs(str1, str2, n - 1, m), getLcs(str1, str2, n, m - 1));
		}
	}

	// This is the recursive memorized version
	static int getLcsMem(char str1[], char str2[], int n, int m) {
		int dp[][] = new int[n + 1][m + 1];
		for (int[] i : dp) {
			Arrays.fill(i, -1);
		}
		return getLcsMemUtil(str1, str2, n, m, dp);
	}

	static int getLcsMemUtil(char str1[], char str2[], int n, int m, int dp[][]) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (dp[n][m] != -1) {
			return dp[n][m];
		}
		if (str1[n - 1] == str2[m - 1]) {
			return dp[n][m] = getLcsMemUtil(str1, str2, n - 1, m - 1, dp) + 1;
		} else {
			return dp[n][m] = Math.max(getLcsMemUtil(str1, str2, n - 1, m, dp), getLcsMemUtil(str1, str2, n, m - 1, dp));
		}
	}
	
	// This is the Top-Down approach
	static int getLcsDP(char str1[], char str2[], int n, int m) {
		int t[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}

		return t[n][m];
	}

}
