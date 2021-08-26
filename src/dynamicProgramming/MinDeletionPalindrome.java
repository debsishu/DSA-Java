package dynamicProgramming;

public class MinDeletionPalindrome {
	public static void main(String[] args) {
		String s = "aebcbda";
		System.out.println(minimumNumberOfDeletions(s));
	}

	static int minimumNumberOfDeletions(String s) {
		StringBuilder sb = new StringBuilder();
		String rev = sb.append(s).reverse().toString();
		return LCS(s.toCharArray(), rev.toCharArray(), s.length(), s.length());
	}

	static int LCS(char str1[], char str2[], int n, int m) {
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

		return n - t[n][m];
	}
}
