package searching;

import java.util.Arrays;

public class JobSequencing {
	public static void main(String[] args) {

	}

	static class Job {
		int id, profit, deadline;

		Job(int id, int profit, int deadline) {
			this.id = id;
			this.profit = profit;
			this.deadline = deadline;
		}
	}

	int[] jobSequencing(Job arr[], int n) {
		// This is just lambda operator
		// Simple comparator for sorting based on profit
		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
		int maxi = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].deadline > maxi) {
				maxi = arr[i].deadline;
			}
		}

		int result[] = new int[maxi + 1];
		Arrays.fill(result, -1);

		int countJobs = 0;
		int jobsProfit = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline; j > 0; j--) {
				if (result[j] == -1) {
					result[j] = i;
					countJobs++;
					jobsProfit += arr[i].profit;
					break;
				}
			}
		}

		int ans[] = new int[2];
		ans[0] = countJobs;
		ans[1] = jobsProfit;
		return ans;
	}
}
