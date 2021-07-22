package searching;

public class ArrayAdjDiffK {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 7, 7, 6 };
		System.out.println(search(arr, 2, 7));
	}

	// We know the element difference is k. so we traverse from left to right and we
	// jump to the next possible location using the difference
	static int search(int arr[], int k, int num) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] == num) {
				return i;
			}
			i += Math.max(1, Math.abs(arr[i] - num) / k);
		}
		return -1;
	}
}
