package searching;

import java.util.*;

public class BishuSoldiers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int prefixSum[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
		}

		int k = sc.nextInt();

		while (k-- > 0) {
			int power = sc.nextInt();
			int ans = bs(arr, n, power);
			int r = ans > 0 ? prefixSum[ans] : 0;
			System.out.println(ans + " " + r);
		}
		sc.close();
	}

	static int bs(int arr[], int n, int power) {
		// BASE CASES
		if (arr[n - 1] <= power) {
			return n;
		}
		if (arr[0] > power) {
			return 0;
		}

		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] == power && arr[mid + 1] > power) {
				return mid + 1;
			}
			if (arr[mid] <= power) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return 0;
	}
}
