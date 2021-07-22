// Stickler the thief wants to loot money from a society 
// having n houses in a single line. He is a weird person 
// and follows a certain rule when looting the houses. 
// According to the rule, he will never loot two consecutive 
// houses. At the same time, he wants to maximize the amount 
// he loots. The thief knows which house has what amount of 
// money but is unable to come up with an optimal looting 
// strategy. He asks for your help to find the maximum money 
// he can get if he strictly follows the rule. Each house 
// has a[i] amount of money present in it

// WATCH THIS VIDEO
// https://youtu.be/VT4bZV24QNo
package searching;

public class SticklerTheif {
	public static void main(String[] args) {
		int arr[] = { 5, 5, 10, 100, 10, 5 };
		System.out.println(maxAmount(arr));
	}

	static int maxAmount(int[] arr) {
		int include = arr[0];
		int exclude = 0;

		for (int i = 1; i < arr.length; i++) {
			int newInclude = exclude + arr[i];
			int newExclude = Math.max(include, exclude);

			include = newInclude;
			exclude = newExclude;
		}
		return Math.max(include, exclude);
	}
}
