package searching;

import java.util.*;

public class FourSum {
	public static void main(String[] args) {

	}

	List<List<Integer>> fourSumMod(int nums[], int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return res;
		}
		int n = nums.length;

		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int target2 = target - nums[i] - nums[j];

				int front = j + 1;
				int back = n - 1;

				while (front < back) {
					int twoSum = nums[front] + nums[back];

					if (twoSum < target2) {
						front++;
					} else if (twoSum > target2) {
						back--;
					} else {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[front]);
						list.add(nums[back]);
						res.add(list);

						while (front < back && nums[front] == list.get(2)) {
							++front;
						}

						while (front < back && nums[back] == list.get(3)) {
							--back;
						}
					}
				}
				while (j + 1 < n && nums[j + 1] == nums[j]) {
					++j;
				}
			}
			while (i + 1 < n && nums[i + 1] == nums[i]) {
				++i;
			}
		}
		return res;
	}

}
