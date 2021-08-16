package stringPractice;

public class PalindromeString {
	public static void main(String[] args) {
		String s = "abba";
		System.out.println(isPalindrome(s));
	}

	static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
