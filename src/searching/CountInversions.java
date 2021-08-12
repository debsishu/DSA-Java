package searching;

public class CountInversions {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 1, 3, 5 };
		int temp[] = new int[arr.length];
		int ans = mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println(ans);
	}

	static int mergeSort(int[] arr, int left, int right, int temp[]) {
		int count = 0;
		if (right > left) {
			int mid = (right + left) / 2;
			count += mergeSort(arr, left, mid, temp);
			count += mergeSort(arr, mid + 1, right, temp);

			count += merge(arr, left, mid + 1, right, temp);
		}
		return count;
	}

	static int merge(int[] arr, int left, int mid, int right, int temp[]) {
		int count = 0;
		int i = left;
		int j = mid;
		int k = left;
		while (i <= mid - 1 && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				count += (mid - i);
			}
		}
		while (i <= mid - 1) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		for (i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
		return count;
	}

}
