package stringPractice;

import java.util.*;

public class PrintAllPermutations {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		// List<List<Integer>> res = permute(arr);
		List<List<Integer>> res = permuteMod(arr);
		for (List<Integer> e : res) {
			System.out.println(e);
		}
	}

	static List<List<Integer>> permute(int arr[]) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean freq[] = new boolean[arr.length];
		permuteUtil(arr, freq, res, ds);
		return res;
	}

	static void permuteUtil(int[] arr, boolean[] freq, List<List<Integer>> res, List<Integer> ds) {
		if (ds.size() == arr.length) {
			res.add(new ArrayList<>(ds));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!freq[i]) {
				ds.add(arr[i]);
				freq[i] = true;
				permuteUtil(arr, freq, res, ds);
				// Backtracking
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}
		}
	}

	// This is the efficient approach
	static List<List<Integer>> permuteMod(int arr[]) {
		List<List<Integer>> res = new ArrayList<>();
		permuteUtilMod(0, arr, res);
		return res;
	}

	static void permuteUtilMod(int index, int arr[], List<List<Integer>> res) {
		if (index == arr.length) {
			List<Integer> ds = new ArrayList<>();
			for (int e : arr) {
				ds.add(e);
			}
			res.add(ds);
		}
		for (int i = index; i < arr.length; i++) {
			swap(i, index, arr);
			permuteUtilMod(index + 1, arr, res);
			// Backtracking
			swap(i, index, arr);
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
