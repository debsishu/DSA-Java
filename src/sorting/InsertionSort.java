package sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		insertionSort(arr);
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
