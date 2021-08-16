package stringPractice;

public class CheckStringRotate {
	public static void main(String[] args) {
		String s = "abcde";
		String goal = "cdeab";
		System.out.println(isRotated(s, goal));
	}

	private static boolean isRotated(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		String temp = s + s;
		return temp.indexOf(goal) != -1;
	}
}
