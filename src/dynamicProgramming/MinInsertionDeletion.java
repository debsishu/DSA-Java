package dynamicProgramming;

public class MinInsertionDeletion {
	public static void main(String[] args) {
		String str1 = "heap", str2 = "pea";
		System.out.println(minInsertionOrDeletion(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
	}

	static int minInsertionOrDeletion(char str1[], char str2[], int n, int m) {
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

		return (m - t[n][m]) + (n - t[n][m]);
	}
}
