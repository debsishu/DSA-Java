// Given an array Arr of N positive integers. 
// Your task is to find the elements whose value is equal to that of its index value.

package searching;

public class FindFixedPoint {
	public static void main(String[] args) {
		int arr[] = { -10, -1, 0, 3, 10, 11, 30, 50, 100 };
		System.out.println(findFixedPoint(arr));
	}

	// We can do thing question with simple linear search o(n)
	// This is the binary search solution with o(logn) complexity
	// But this requires the array to be sorted
	static int findFixedPoint(int arr[]) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == mid) {
				return mid;
			} else if (arr[mid] < mid) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
