package dynamicProgramming;

public class UnboundedKnapsack {
	public static void main(String[] args) {
		int N = 2, W = 3;
		int val[] = { 1, 1 };
		int wt[] = { 2, 1 };
		System.out.println(unboundedKnapsack(N, W, val, wt));
	}

	static int unboundedKnapsack(int n, int w, int value[], int weight[]) {
		int t[][] = new int[n + 1][w + 1];
		// No need of initialization because default value of array is zero
		// 0 0 0 0 0 0
		// 0 X X X X X
		// 0 X X X X X
		// 0 X X X X X

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (weight[i - 1] <= j) {
					// Here we are taking the choice of picking an element as much as we want
					// t[i][j - weight[i - 1]]
					t[i][j] = Math.max((value[i - 1] + t[i][j - weight[i - 1]]), t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][w];
	}
}
