package dynamicProgramming;

public class TargetSum {
	public static void main(String[] args) {
		int arr[] = { 1, 0 };
		int target = 1;
		System.out.println(countSubsets(arr, arr.length, target));
	}

	static int countSubsets(int arr[], int n, int target) {
		int arrSum = 0;
		for (int e : arr) {
			arrSum += e;
		}
		// Math.abs because if the target value is greater than the total sum but
		// negative
		if ((arrSum - target) % 2 == 1 || (Math.abs(target) > arrSum)) {
			return 0;
		}
		int sum = (arrSum + target) / 2;
		return subsetSumCount(arr, n, sum);
	}

	private static int subsetSumCount(int[] arr, int n, int sum) {
		int t[][] = new int[n + 1][sum + 1];

		// Initialization
		for (int i = 0; i <= n; i++) {
			t[i][0] = 1;
		}

		// Choice Diagram
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] > j || arr[i - 1] == 0) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				}
			}
		}

		int count = 0;
		for (int e : arr) {
			if (e == 0) {
				count++;
			}
		}
		// 2 ^ count because if their is zero thein can be 2^n number of possibilities
		return (int) (Math.pow(2, count)) * t[n][sum];
	}
}
