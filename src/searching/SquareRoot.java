package searching;

public class SquareRoot {
	public static void main(String[] args) {
		System.out.println(squareRoot(11));
	}

	// https://youtu.be/fItuKa_tIpY
	static int squareRoot(int num) {
		// Base case
		if (num == 0 || num == 1) {
			return num;
		}
		int low = 1;
		int high = num;
		int ans = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid * mid == num) {
				ans = (int) mid;
			}
			if (mid * mid < num) {
				low = mid + 1;
				ans = mid;
			} else {
				high = mid - 1;
			}
		}
		return (int) ans;
	}
}
