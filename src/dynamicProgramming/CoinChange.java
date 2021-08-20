// Coin change : maximum number of ways 

package dynamicProgramming;

public class CoinChange {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 3, 6 };
		int sum = 10;
		System.out.println(maximumWaysCoin(arr, arr.length, sum));
	}

	static int maximumWaysCoin(int arr[], int n, int sum) {
		int t[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			t[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i][j - arr[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][sum];
	}
}
