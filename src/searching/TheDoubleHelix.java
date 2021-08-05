package searching;

public class TheDoubleHelix {
	public static void main(String[] args) {
		int a[] = { 3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62 };
		int b[] = { 1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100 };
		System.out.println(doubleHelix(a, 13, b, 11));
	}

	static int doubleHelix(int arr1[], int n, int arr2[], int m) {
		int i = 0, j = 0;
		int sum1 = 0, sum2 = 0;
		int sum = 0;
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				sum1 += arr1[i++];
			} else if (arr2[j] < arr1[i]) {
				sum2 += arr2[j++];
			} else {
				sum += Math.max(sum1, sum2) + arr1[i];
				sum1 = sum2 = 0;
				i++;
				j++;
			}

		}
		while (i < n) {
			sum1 += arr1[i++];
		}
		while (j < m) {
			sum2 += arr2[j++];
		}
		sum += Math.max(sum1, sum2);
		return sum;
	}
}
