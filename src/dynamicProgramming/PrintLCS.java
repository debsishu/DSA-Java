package dynamicProgramming;

public class PrintLCS {
	public static void main(String[] args) {
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		System.out.println(printLCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
	}

	static String printLCS(char str1[], char str2[], int n, int m) {
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

		int i = n;
		int j = m;
		StringBuilder s = new StringBuilder();
		while (i > 0 && j > 0) {
			if (str1[i - 1] == str2[j - 1]) {
				s.append(str1[i - 1]);
				i--;
				j--;
			} else {
				if (t[i - 1][j] > t[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return s.reverse().toString();
	}

}
