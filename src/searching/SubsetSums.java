package searching;

public class SubsetSums {
	public static void main(String[] args) {
		int n = 3;
		int A = -1;
		int B = 2;
		int arr[] = { 1, -2, 3 };
		System.out.println(subsetSums(arr, n, A, B));
	}

	static int res = 0;

	static int subsetSums(int arr[], int n, int A, int B) {
		calculate(0, 0, arr, n, A, B);
		return res;
	}

	static void calculate(int i, int sum, int arr[], int n, int A, int B) {
		if (i == n) {
			if (sum >= A && sum <= B)
				res++;
			return;
		}
		calculate(i + 1, sum + arr[i], arr, n, A, B);
		calculate(i + 1, sum, arr, n, A, B);
	}
}
