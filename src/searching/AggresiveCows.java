package searching;

import java.util.*;

public class AggresiveCows {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int cows = sc.nextInt();

			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			sc.close();

			Arrays.sort(arr);

			int low = 1;
			// Making a assumption as the question states that their will always be 2 cows
			int high = arr[n - 1] - arr[0];

			// Simple binary search
			while (low <= high) {
				int mid = (low + high) / 2;

				if (isPossible(arr, n, cows, mid)) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			System.out.println(high);
		}
	}

	private static boolean isPossible(int[] arr, int n, int cows, int minDist) {
		int countCows = 1;
		int lastPlacedCow = arr[0];
		// Follows a greedy algo and always place the first cow at the first position
		for (int i = 1; i < n; i++) {
			if (arr[i] - lastPlacedCow >= minDist) {
				countCows++;
				lastPlacedCow = arr[i];
			}
		}
		if (countCows >= cows) {
			return true;
		}
		return false;
	}

}
