package dynamicProgramming;

public class CoinChangeTwo {
	public static void main(String[] args) {
		int coin[] = { 25, 10, 5 };
		int sum = 30;
		System.out.println(minimumNumberOfCoins(coin, coin.length, sum));
	}

	static int minimumNumberOfCoins(int coin[], int n, int sum) {
		int t[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			t[0][i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i <= sum; i++) {
			if (i % coin[0] == 0) {
				t[1][i] = i / coin[0];
			} else {
				t[1][i] = Integer.MAX_VALUE - 1;
			}
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coin[i - 1] <= j) {
					t[i][j] = Math.min((1 + t[i][j - coin[i - 1]]), t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][sum] == Integer.MAX_VALUE - 1 ? -1 : t[n][sum];
	}

}
