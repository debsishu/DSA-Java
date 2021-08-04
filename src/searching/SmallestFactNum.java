package searching;

public class SmallestFactNum {
	public static void main(String[] args) {
		System.out.println(findNum(6));
	}

	static int findNum(int n) {
		// Base case
		if (n == 1) {
			return 5;
		}
		int low = 0;
		// Why 5 * n (check GFG article)
		// https://www.geeksforgeeks.org/smallest-number-least-n-trailing-zeroes-factorial/#:~:text=We%20can%20notice%20that%2C%20the%20maximum%20value%20whose%20factorial%20contain%20n%20trailing%20zeroes%20is%205*n.
		int high = 5 * n;

		while (low < high) {
			int mid = (low + high) / 2;

			if (check(mid, n)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	static boolean check(int p, int num) {
		int temp = p;
		int count = 0;
		int f = 5;
		while (f <= temp) {
			count += temp / f;
			f *= 5;
		}
		return (count >= num);
	}
}
