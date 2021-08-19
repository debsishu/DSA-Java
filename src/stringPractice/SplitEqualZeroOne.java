// Given a binary string str of length N, the task is to find 
// the maximum count of *consecutive* substrings str can be divided 
// into such that all the substrings are balanced i.e. they have 
// equal number of 0s and 1s. If it is not possible to split str 
// satisfying the conditions then print -1.

package stringPractice;

public class SplitEqualZeroOne {
	public static void main(String[] args) {
		String s = "0100011";
		System.out.println(printEqualZeroOne(s));
	}

	static int printEqualZeroOne(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int count = 0;
		int zero = 0;
		int one = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zero++;
			} else if (s.charAt(i) == '1') {
				one++;
			}
			if (zero == one) {
				count++;
			}
		}
		return count == 0 ? -1 : count;
	}

}
