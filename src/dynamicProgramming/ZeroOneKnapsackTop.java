// This is the TOP-DOWN approach

package dynamicProgramming;

public class ZeroOneKnapsackTop {

	static int knapsackProfit(int weight[], int w, int values[], int n) {
		int dp[][] = new int[n + 1][w + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < w; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (weight[i - 1] <= j) {
					dp[i][j] = Math.max((values[i - 1] + dp[i - 1][j - weight[i - 1]]), dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][w];
	}

	public static void main(String[] args) {
		int n = 3;
		int w = 4;
		int values[] = { 1, 2, 3 };
		int weight[] = { 4, 5, 1 };
		System.out.println(knapsackProfit(weight, w, values, n));
	}

}
