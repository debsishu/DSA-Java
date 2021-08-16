package stringPractice;

import java.util.Arrays;

public class ValidShuffle {
	public static void main(String[] args) {
		String first = "XY";
		String second = "12";
		String res = "Y21X";

		System.out.println(checkShuffle(first, second, res));
	}

	static boolean checkShuffle(String first, String second, String result) {
		first = sortString(first);
		second = sortString(second);
		result = sortString(result);

		int i = 0, j = 0, k = 0;

		while (k != result.length()) {
			if (i < first.length() && first.charAt(i) == result.charAt(k)) {
				i++;
			} else if (j < second.length() && second.charAt(j) == result.charAt(k)) {
				j++;
			} else {
				return false;
			}
			k++;
		}

		if (i < first.length() || j < second.length()) {
			return false;
		}
		return true;
	}

	static String sortString(String str) {
		char arr[] = str.toCharArray();
		Arrays.sort(arr);
		str = String.valueOf(arr);
		return str;
	}
}
