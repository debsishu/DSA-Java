package searching;

public class MaxOccurance {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 5, 5, 6 };
		System.out.println(maxOccurance(arr));
	}

	static int maxOccurance(int arr[]) {
		int max = 0, maxIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % arr.length] += arr.length;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] / arr.length > max) {
				max = arr[i] / arr.length;
				maxIndex = i;
			}
		}

		return maxIndex;
	}
}
