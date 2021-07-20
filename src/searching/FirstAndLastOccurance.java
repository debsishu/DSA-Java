package searching;

public class FirstAndLastOccurance {
	public static void main(String[] args) {
		int arr[] = { 5, 7, 7, 8, 8, 10 };
		int res[] = searchRange(arr, 8);
		System.out.println(res[0] + " " + res[1]);
	}

	static int[] searchRange(int[] arr, int target) {
		int res[] = new int[2];
		// Here the false and true mark is for the first and the last occurance
		// first determine the first occurance in the array using binary search
		res[0] = binarySearch(arr, arr.length, target, false);
		// second determine the last occurance in the array using binary search with the
		// flag indicating that
		res[1] = binarySearch(arr, arr.length, target, true);
		return res;
	}

	private static int binarySearch(int arr[], int n, int target, boolean flag) {
		int start = 0;
		int end = n - 1;
		int res = -1;

		// Same binary search with modifications
		// Modifications are that we do not call off the binary search even if we found
		// the element. If we are searching for the first element we shrink the search
		// space to the left and if we are searcing for the last element we shrink the
		// search space to the right
		// flag == false indicating search for the first element
		// flag == true indicating search for the second element
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target && flag == false) {
				res = mid;
				end = mid - 1;
			} else if (arr[mid] == target && flag == true) {
				res = mid;
				start = mid + 1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return res;
	}
}
