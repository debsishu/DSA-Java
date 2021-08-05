package searching;

public class RotiParata {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		System.out.println(numOfMinutes(arr, 10, 4));
	}

	static int numOfMinutes(int arr[], int paratas, int chefs) {
		int low = 0;
		// Why 10 ^ 8
		// because max paratas could be 1000(constrains) and worst chef 8(constrains)
		// in worst case all 1000 paratas will be made by 8th ranked chef
		// in that case time is R * (n *(n + 1)) / 2 == 10^8 | R = 8, n = 1000
		int high = (int) 1e8;
		int ans = 0;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (isPossible(arr, paratas, chefs, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	static boolean isPossible(int arr[], int paratas, int chefs, int mid) {
		int parata = 0;
		int time = 0;
		for (int i = 0; i < arr.length; i++) {
			time = arr[i];
			int j = 2;
			while (time <= mid) {
				parata++;
				time += (arr[i] * j++);
			}
			if (parata >= paratas) {
				return true;
			}
		}
		return false;
	}

}
