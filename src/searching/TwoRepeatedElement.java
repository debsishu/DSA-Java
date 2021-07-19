package searching;

public class TwoRepeatedElement {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 3 };
		int res[] = twoRepeatedElement(arr);
		for (int e : res) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	static int[] twoRepeatedElement(int arr[]) {
		int count[] = new int[arr.length - 1];
		int res[] = new int[2];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
			if (count[arr[i]] == 2) {
				if (cnt > 1) {
					break;
				}
				res[cnt++] = arr[i];
			}
		}
		return res;
	}
}
