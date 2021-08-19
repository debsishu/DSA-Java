// Count subset sum with given difference

package dynamicProgramming;

public class CountSubsetSumDiff {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 3 };
		System.out.println(countSubsets(arr, arr.length, 1));
	}

	static int countSubsets(int arr[], int n, int diff) {
		int arrSum = 0;
		for (int e : arr) {
			arrSum += e;
		}
		int sum = (arrSum + diff) / 2;
		return subsetSumCount(arr, n, sum);
	}

	static int subsetSumCount(int arr[], int n, int sum) {
		int t[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			t[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][sum];
	}
}
