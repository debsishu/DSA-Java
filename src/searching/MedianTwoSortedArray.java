package searching;

public class MedianTwoSortedArray {
	public static void main(String[] args) {
		int arr1[] = { 1, 5, 9 };
		int arr2[] = { 2, 3, 6, 7 };
		System.out.println(findMedian(arr1, arr2));
		// int arr1[] = { 4, 6 };
		// int arr2[] = { 1, 2, 3, 5 };
		// System.out.println(findMedian(arr1, arr2));
	}

	static double findMedian(int nums1[], int nums2[]) {
		// This always ensures that the smaller array is the first array
		// This is because it reduces the search space to the time complexity is
		// O(log(min(n, m)))
		if (nums2.length < nums1.length) {
			return findMedian(nums2, nums1);
		}

		int n1 = nums1.length;
		int n2 = nums2.length;

		// We can take all the elements from the first array in the partition
		int low = 0;
		int high = n1;

		// Binary Search
		while (low <= high) {
			int cut1 = (low + high) / 2;
			int cut2 = (n1 + n2 + 1) / 2 - cut1;

			// If we don't take anything fromthe first half initialize it with MINVALUE
			int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
			int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

			// If we don't take anything fromthe second half initialize it with MAXVALUE
			int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
			int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

			// This means we found that correct partition
			if (left1 <= right2 && left2 <= right1) {
				// If the merged array is even size
				if ((n1 + n2) % 2 == 0) {
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				} else {
					// If the merged array is odd size
					return Math.max(left1, left2);
				}
			} else if (left1 > right2) {
				high = cut1 - 1;
			} else {
				low = cut1 + 1;
			}
		}
		return 0.0;
	}
}
