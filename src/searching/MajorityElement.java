package searching;

public class MajorityElement {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 3, 3, 2 };
		System.out.println(isMajority(arr));
	}

	// MOORE'S VOTING ALGORITHM
	// This solution makes an assumption that their will always be a majority
	// element
	// Majority elements means that element appears more than N/2 times
	static int majorityElement(int arr[]) {
		int count = 0;
		int candidate = 0;
		for (int num : arr) {
			if (count == 0) {
				candidate = num;
			}
			if (candidate == num) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}

	static int isMajority(int arr[]) {
		int cand = majorityElement(arr);
		int count = 0;
		for (int num : arr) {
			if (num == cand) {
				count++;
			}
		}
		if (count > arr.length / 2) {
			return cand;
		} else {
			return -1;
		}
	}
}
