package dynamicProgramming;

public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String s = "axxxy";
		System.out.println(longestRepeatingSubsequence(s));
	}

	static int longestRepeatingSubsequence(String s) {
		return LCSMod(s.toCharArray(), s.toCharArray(), s.length(), s.length());
	}

	static int LCSMod(char str1[], char str2[], int n, int m) {
		int t[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1[i - 1] == str2[j - 1] && i != j) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}

		return t[n][m];
	}
}
