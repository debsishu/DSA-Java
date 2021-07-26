package searching;

import java.util.Arrays;

public class SortSetBits {
	public static void main(String[] args) {
		int arr[] = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };
		sortBySetBit(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static int countBits(int a) {
		int count = 0;
		while (a > 0) {
			if ((a & 1) > 0) {
				count++;
			}
			a = a >> 1;
		}
		return count;
	}

	// This si Brian Kernighan's Algorithm
	static int countBitsMod(int n) {
		int count = 0;
		while (n > 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	static void insertionSort(int arr[], int aux[], int n) {
		// Simple insertion sort
		// Sort the original array according to the auxilary (aux) array
		for (int i = 1; i < n; i++) {
			int key1 = aux[i];
			int key2 = arr[i];
			int j = i - 1;

			while (j >= 0 && aux[j] < key1) {
				aux[j + 1] = aux[j];
				arr[j + 1] = arr[j];
				j--;
			}
			aux[j + 1] = key1;
			arr[j + 1] = key2;
		}
	}

	static void sortBySetBit(int arr[], int n) {
		int aux[] = new int[n];
		for (int i = 0; i < n; i++) {
			aux[i] = countBitsMod(arr[i]);
		}
		insertionSort(arr, aux, n);
	}
}
