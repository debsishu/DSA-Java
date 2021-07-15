package searching;

public class DuplicateElements {
	public static void main(String[] args) {
		// int arr[] = { 3, 3, 1, 2, 2, 3 };
		// checkDuplicates(arr);
		System.out.println(6 % 7);
	}

	static void checkDuplicates(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] < 0) {
				System.out.println("Duplicate element found : " + arr[i]);
				return;
			} else {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
		}
		System.out.println("No duplicates found in the given array");
	}
}
