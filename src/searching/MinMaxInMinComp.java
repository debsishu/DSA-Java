// Maximum and minimum of an array using minimum number of comparisons

package searching;

public class MinMaxInMinComp {
	public static void main(String[] args) {
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
		Pair res = getMinMax(arr, 0, arr.length - 1);
		System.out.println(res.min + " " + res.max);
	}

	static class Pair {
		int min;
		int max;
	}

	static Pair getMinMax(int arr[], int low, int high) {
		Pair minMax = new Pair();
		Pair mml = new Pair();
		Pair mmr = new Pair();

		if (low == high) {
			minMax.max = arr[low];
			minMax.min = arr[low];
			return minMax;
		}

		if (high == low + 1) {
			if (arr[low] > arr[high]) {
				minMax.max = arr[low];
				minMax.min = arr[high];
			} else {
				minMax.max = arr[high];
				minMax.min = arr[low];
			}
			return minMax;
		}

		int mid = low + (high - low) / 2;
		mml = getMinMax(arr, low, mid);
		mmr = getMinMax(arr, mid + 1, high);
		if (mml.min < mmr.min) {
			minMax.min = mml.min;
		} else {
			minMax.min = mmr.min;
		}

		if (mml.max > mmr.max) {
			minMax.max = mml.max;
		} else {
			minMax.max = mmr.max;
		}
		return minMax;
	}

}
