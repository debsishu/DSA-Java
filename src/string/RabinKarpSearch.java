package string;

public class RabinKarpSearch {

	private static int prime = 101;

	static int patternSearch(char text[], char[] pattern) {
		int m = pattern.length;
		int n = text.length;
		long patternHash = createHash(pattern, m - 1);
		// This generates the first patternlength hash
		long textHash = createHash(text, m - 1);
		for (int i = 1; i <= n - m + 1; i++) {
			if (patternHash == textHash && checkEqual(text, i - 1, i + m - 2, pattern, 0, m - 1)) {
				return i - 1;
			}
			if (i < n - m + 1) {
				textHash = recalculateHash(text, i - 1, i + m - 1, textHash, m);
			}
		}
		return -1;
	}

	private static long recalculateHash(char[] text, int oldIndex, int newIndex, long oldHash, int patternLen) {
		long newHash = oldHash - text[oldIndex];
		newHash = newHash / prime;
		newHash += text[newIndex] * Math.pow(prime, patternLen - 1);
		return newHash;
	}

	private static boolean checkEqual(char[] text, int start1, int end1, char[] pattern, int start2, int end2) {
		if (end1 - start1 != end2 - start2) {
			return false;
		}
		while (start1 <= end1 && start2 <= end2) {
			if (text[start1] != pattern[start2]) {
				return false;
			}
			start1++;
			start2++;
		}
		return true;
	}

	private static long createHash(char[] pattern, int n) {
		long hash = 0;
		for (int i = 0; i <= n; i++) {
			hash += pattern[i] * Math.pow(prime, i);
		}
		return hash;
	}

	public static void main(String[] args) {
		String text = "THIS IS JUST A DUMMY TEXT";
		System.out.println(patternSearch(text.toCharArray(), "DUMMY".toCharArray()));
	}
}
