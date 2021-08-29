package dynamicProgramming;

import java.util.HashMap;

public class ScrambleString {
	public static void main(String[] args) {
		System.out.println(isScrambled("great", "eatrg"));
	}

	static boolean isScrambled(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		if (a == "" && b == "") {
			return true;
		}
		HashMap<String, Boolean> map = new HashMap<>();
		return solve(a, b, map);
	}

	private static boolean solve(String a, String b, HashMap<String, Boolean> map) {
		if (a.equals(b)) {
			return true;
		}
		if (a.length() <= 1) {
			return false;
		}
		String key = a + " " + b;
		if (map.containsKey(key)) {
			return map.get(key);
		}

		int n = a.length();
		boolean flag = false;

		for (int i = 1; i <= n - 1; i++) {
			if (solve(a.substring(0, i), b.substring(0, i), map) && solve(a.substring(i), b.substring(i), map)) {
				flag = true;
				break;
			} else if (solve(a.substring(0, i), b.substring(n - i), map)
					&& solve(a.substring(i), b.substring(0, n - i), map)) {
				flag = true;
				break;
			}
		}

		map.put(key, flag);

		return flag;
	}
}
