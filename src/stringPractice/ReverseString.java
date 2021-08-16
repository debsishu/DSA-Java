package stringPractice;

public class ReverseString {
	public static void main(String[] args) {
		String s = "Debsishu";
		char res[] = s.toCharArray();
		reverseString(res);
		for (char e : res) {
			System.out.print(e);
		}
		System.out.println();
	}

	private static void reverseString(char[] s) {
		if (s.length == 0 || s == null) {
			return;
		}
		int start = 0;
		int end = s.length - 1;
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

}
