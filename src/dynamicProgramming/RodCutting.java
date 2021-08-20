package dynamicProgramming;

public class RodCutting {
	public static void main(String[] args) {
		int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = 8;
		System.out.println(maximumProfit(price, n));
	}

	static int maximumProfit(int price[], int n) {
		int length[] = new int[n];
		for (int i = 0; i < n; i++) {
			length[i] = i + 1;
		}
		int t[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (length[i - 1] <= j) {
					t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][n];
	}
}
