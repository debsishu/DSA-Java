package string;

public class KMPAlgo {
	public static void main(String[] args) {
		String str = "abcxadbdabcdabcy";
		String subString = "abcdabcy";
		System.out.println(KMP(str.toCharArray(), subString.toCharArray()));
	}

	// Watch Tushar Roy video

	static boolean KMP(char text[], char pattern[]) {
		int lps[] = computeTempArray(pattern);
		int i = 0;
		int j = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pattern.length) {
			return true;
		}
		return false;
	}

	static int[] computeTempArray(char pattern[]) {
		int lps[] = new int[pattern.length];
		int j = 0;
		int i = 1;
		while (i < pattern.length) {
			if (pattern[i] == pattern[j]) {
				lps[i] = j + 1;
				j++;
				i++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
}
