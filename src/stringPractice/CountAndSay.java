package stringPractice;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSayMod(4));
	}

	static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		if (n == 2) {
			return "11";
		}
		String s = "11";
		for (int i = 3; i <= n; i++) {
			String t = "";
			// Not sure why add this at the last of the string
			s = s + "&";
			int count = 1;
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j) != s.charAt(j - 1)) {
					t = t + Integer.toString(count);
					t = t + s.charAt(j - 1);
					count = 1;
				} else {
					count++;
				}
			}
			s = t;
		}
		return s;
	}

	static String countAndSayMod(int n) {
		String s = "1";
		for (int i = 1; i < n; i++) {
			s = countIndex(s);
		}
		return s;
	}

	static String countIndex(String s) {
		char c = s.charAt(0);
		int count = 1;
		String sb = "";
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count++;
			} else {
				sb += Integer.toString(count);
				sb += c;
				c = s.charAt(i);
				count = 1;
			}
		}
		sb += Integer.toString(count);
		sb += c;
		return sb;
	}
}
