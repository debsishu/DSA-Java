package searching;

public class KthElementTwoSortedArray {
	public static void main(String[] args) {

	}

	static int kthElement(int arr1[], int arr2[], int n, int m, int k) {
		if (n > m) {
			return kthElement(arr2, arr1, m, n, k);
		}
		// These are the edge cases
		// If the second array is smaller than the K then we have to take some element
		// from the first array
		int low = Math.max(0, k - m);
		// If the K is smaller than the first array then we can't take all the elements
		// from the first array
		int high = Math.min(k, n);

		while (low <= high) {
			int cut1 = (low + high) / 2;
			int cut2 = k - cut1;

			int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
			int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

			int right1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
			int right2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

			if (left1 <= right2 && left2 <= right1) {
				return Math.max(left1, left2);
			} else if (left1 > right2) {
				high = cut1 - 1;
			} else {
				low = cut1 + 1;
			}
		}
		return 1;
	}

}
