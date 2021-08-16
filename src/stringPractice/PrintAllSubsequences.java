package stringPractice;

public class PrintAllSubsequences {
	public static void main(String[] args) {
		String s = "abc";
		printAllSubsequencesRec(s, "");
	}

	static void printAllSubsequences(String s) {
		int n = s.length();
		int size = (int) Math.pow(2, n);
		for (int i = 0; i < size; i++) {
			String sub = "";
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sub += s.charAt(j);
				}
			}
			System.err.println(sub);
		}
	}

	// This is the recursive solution
	static void printAllSubsequencesRec(String s, String output) {
		if (s.length() == 0) {
			System.out.println(output);
			return;
		}
		printAllSubsequencesRec(s.substring(1), output);
		printAllSubsequencesRec(s.substring(1), output + s.charAt(0));
	}
}
