package dynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioningOpt {
	public static void main(String[] args) {
		String s = "ababbbabbababa";
		System.out.println(minPartition(s));
	}

	static int minPartition(String s) {
		int t[][] = new int[s.length()][s.length()];
		for (int[] i : t) {
			Arrays.fill(i, -1);
		}
		return solve(s.toCharArray(), 0, s.length() - 1, t);
	}

	static int solve(char arr[], int i, int j, int t[][]) {
		if (i >= j) {
			return 0;
		}

		if (t[i][j] != -1) {
			return t[i][j];
		}
		
		if (isPalindrome(arr, i, j)) {
			t[i][j] = 0;
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			if (isPalindrome(arr, i, k)) {
				min = Math.min(min, 1 + solve(arr, k + 1, j, t));
			}
		}
		return t[i][j] = min;
	}

	private static boolean isPalindrome(char[] arr, int i, int j) {
		int start = i;
		int end = j;
		while (start < end) {
			if (arr[start] != arr[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
