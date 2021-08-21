package dynamicProgramming;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		String str1 = "ABCDGH";
		String str2 = "ACDGHR";
		System.out.println(longestCommonSubstring(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
	}

	static int longestCommonSubstring(char str1[], char str2[], int n, int m) {
		int t[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = 0;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int[] i : t) {
			for (int e : i) {
				if (e > max) {
					max = e;
				}
			}
		}
		return max;
	}
}
