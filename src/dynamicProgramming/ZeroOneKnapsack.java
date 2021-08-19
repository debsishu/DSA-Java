// This is DP + Memorization

package dynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsack {

	static int knapsackProfit(int weight[], int w, int values[], int n) {
		// The size is based on the constrains of the question
		int dp[][] = new int[1002][1002];
		for (int e[] : dp) {
			Arrays.fill(e, -1);
		}
		return knapsackProfitUtil(weight, w, values, n, dp);
	}

	static int knapsackProfitUtil(int[] weight, int w, int[] values, int n, int[][] dp) {
		if (w == 0 || n == 0) {
			return 0;
		}
		if (dp[n][w] != -1) {
			return dp[n][w];
		}
		if (weight[n - 1] <= w) {
			return dp[n][w] = Math.max((values[n - 1] + knapsackProfitUtil(weight, w - weight[n - 1], values, n - 1, dp)),
					knapsackProfitUtil(weight, w, values, n - 1, dp));
		} else if (weight[n - 1] > w) {
			return dp[n][w] = knapsackProfitUtil(weight, w, values, n - 1, dp);
		}
		return 0;
	}

	public static void main(String[] args) {
		int n = 3;
		int w = 4;
		int values[] = { 1, 2, 3 };
		int weight[] = { 4, 5, 1 };
		System.out.println(knapsackProfit(weight, w, values, n));
	}

}
