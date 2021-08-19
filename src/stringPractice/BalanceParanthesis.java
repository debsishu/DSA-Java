package stringPractice;

import java.util.Stack;

public class BalanceParanthesis {
	public static void main(String[] args) {
		String s = "[{()}][";
		System.out.println(isBalanced(s));
	}

	static boolean isBalanced(String s) {
		char arr[] = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				stack.push(arr[i]);
			} else {
				if (arr[i] == ']' && stack.peek() == '[') {
					stack.pop();
				} else if (arr[i] == '}' && stack.peek() == '{') {
					stack.pop();
				} else if (arr[i] == ')' && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(arr[i]);
				}
			}
		}
		return stack.isEmpty();
	}
}
