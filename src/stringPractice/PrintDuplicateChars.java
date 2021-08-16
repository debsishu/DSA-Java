package stringPractice;

public class PrintDuplicateChars {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		printDuplicateCharacters(s);
	}

	private static void printDuplicateCharacters(String s) {
		int hash[] = new int[256];
		for (int i = 0; i < s.length(); i++) {
			hash[s.charAt(i)]++;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > 1) {
				System.out.println((char) i + " -> " + hash[i]);
			}
		}
	}
}
