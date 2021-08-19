package dynamicProgramming;

public class EqualSumPartition {

	static boolean isEqualSumPossible(int arr[], int n) {
		int sum = 0;
		for (int e : arr) {
			sum += e;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int subsetSum = sum / 2;

		boolean t[][] = new boolean[n + 1][subsetSum + 1];
		// Initialization
		for (int i = 0; i <= n; i++) {
			t[i][0] = true;
		}
		// Choice diagram
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= subsetSum; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][subsetSum];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 11, 5 };
		System.out.println(isEqualSumPossible(arr, arr.length));
	}

}
