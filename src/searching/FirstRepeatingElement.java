package searching;

import java.util.HashSet;

public class FirstRepeatingElement {
	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 3, 5, 6 };
		// The function returns 1 based indexing
		System.out.println("First repeating element is at index : " + firstRepeatingElement(arr));
	}

	static int firstRepeatingElement(int arr[]) {
		int n = arr.length;
		int min = -1;
		HashSet<Integer> hs = new HashSet<>();
		for (int i = n - 1; i >= 0; i--) {
			if (hs.contains(arr[i])) {
				min = i;
			} else {
				hs.add(arr[i]);
			}
		}
		return min == -1 ? -1 : min + 1;
	}
}
