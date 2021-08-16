// This approach is kinda confusing
// Follow the RabinKarpSearch.java code

package string;

class RabinKarp {

	// Number of characters in input alphabet
	final static int d = 256;

	static void search(String pat, String text, int q) {
		int m = pat.length();
		int n = text.length();
		int p = 0;
		int t = 0;
		int h = 1;

		for (int i = 0; i < m - 1; i++) {
			h = (h * d) % q;
		}

		for (int i = 0; i < m; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}
		int j;
		for (int i = 0; i <= n - m; i++) {
			if (p == t) {
				for (j = 0; j < m; j++) {
					if (text.charAt(i + j) != pat.charAt(j)) {
						break;
					}
				}
				if (j == m) {
					System.out.println("Pattern found at index " + i);
				}
			}
			if (i < n - m) {
				t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
				if (t < 0) {
					t = (t + q);
				}
			}
		}
	}

	public static void main(String[] args) {
		String text = "THIS IS JUST A DUMMY TEXT";
		String pat = "DUMMY";
		int q = 101;
		search(pat, text, q);
	}

}