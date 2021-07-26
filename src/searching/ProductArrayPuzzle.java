// Given an array nums[] of size n, construct a Product Array P 
// (of same size n) such that P[i] is equal to the product of 
// all the elements of nums except nums[i].

// Watch TECH DOSE video
package searching;

import java.util.Arrays;

public class ProductArrayPuzzle {
	public static void main(String[] args) {
		int arr[] = { 10, 3, 5, 6, 2 };
		int res[] = productArray(arr, arr.length);
		System.out.println(Arrays.toString(res));
	}

	static int[] productArray(int arr[], int n) {
		int res[] = new int[n];
		int product = 1;
		for (int i = 0; i < n; i++) {
			product *= arr[i];
			res[i] = product;
		}
		product = 1;
		for (int i = n - 1; i > 0; i--) {
			res[i] = res[i - 1] * product;
			product *= arr[i];
		}
		res[0] = product;
		return res;
	}
}
