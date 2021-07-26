package searching;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumSwaps {
	public static void main(String[] args) {
		int arr[] = { 10, 19, 6, 3, 5 };
		System.out.println(minNumSwaps(arr, arr.length));
	}

	static class sortComp implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {
			if (o1.first > o2.first) {
				return 1;
			} else if (o1.first < o2.first) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	static int minNumSwaps(int arr[], int n) {
		int count = 0;
		Pair temp[] = new Pair[n];
		for (int i = 0; i < n; i++) {
			Pair obj = new Pair(arr[i], i);
			temp[i] = obj;
		}

		Arrays.sort(temp, new sortComp());

		for (int i = 0; i < n; i++) {
			if (temp[i].second == i) {
				continue;
			} else {
				count++;
				swap(temp, temp[i].second, temp[temp[i].second].second);
				i--;
			}
		}
		return count;
	}

	private static void swap(Pair[] arr, int i, int j) {
		Pair temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static class Pair {
		int first;
		int second;

		Pair() {
		}

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}
