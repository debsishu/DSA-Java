package dynamicProgramming;

public class PrintSCS {
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(printSCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
	}

	static String printSCS(char str1[], char str2[], int n, int m) {
		int t[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}

		int i = n;
		int j = m;
		StringBuilder sb = new StringBuilder();

		while (i > 0 && j > 0) {
			if (str1[i - 1] == str2[j - 1]) {
				sb.append(str1[i - 1]);
				i--;
				j--;
			} else {
				if (t[i - 1][j] > t[i][j - 1]) {
					sb.append(str1[i - 1]);
					i--;
				} else {
					sb.append(str2[j - 1]);
					j--;
				}
			}
		}

		while (i > 0) {
			sb.append(str1[i - 1]);
			i--;
		}
		while (j > 0) {
			sb.append(str2[j - 1]);
			j--;
		}

		return sb.reverse().toString();
	}
}
