package searching;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void main(String[] args) {
		int[] X = { 1, 4, 7, 8, 10 };
		int[] Y = { 2, 3, 9 };
		merge(X, Y);
		System.out.println(Arrays.toString(X) + " " + Arrays.toString(Y));
	}

	static void merge(int x[], int y[]) {
		int m = x.length;
		int n = y.length;

		for (int i = 0; i < m; i++) {
			if (x[i] > y[0]) {
				int temp = x[i];
				x[i] = y[0];
				y[0] = temp;

				int first = y[0];

				// This is just insertion sort logic
				int k;
				for (k = 1; k < n && y[k] < first; k++) {
					y[k - 1] = y[k];
				}
				y[k - 1] = first;
			}
		}
	}
}
