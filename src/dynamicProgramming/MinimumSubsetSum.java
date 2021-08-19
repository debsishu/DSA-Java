package dynamicProgramming;

public class MinimumSubsetSum {

	public static void main(String[] args) {
		int arr[] = { 1, 6, 11, 5 };
		System.out.println(minSubsetSum(arr, arr.length));
	}

	static int minSubsetSum(int arr[], int n) {
		int range = 0;
		for (int e : arr) {
			range += e;
		}
		boolean rangeArray[] = subsetSum(arr, n, range);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < rangeArray.length; i++) {
			if (rangeArray[i]) {
				min = Math.min(min, range - 2 * i);
			}
		}
		return min;
	}

	static boolean[] subsetSum(int arr[], int n, int sum) {
		boolean t[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		boolean ans[] = new boolean[(sum / 2) + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = t[arr.length][i];
		}
		return ans;
	}

}
