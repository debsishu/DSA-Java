package dynamicProgramming;

public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "xycd";
		System.out.println(shortestCommonSupersequence(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
	}

	static int shortestCommonSupersequence(char str1[], char str2[], int n, int m) {
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

		return n + m - t[n][m];
	}
}
