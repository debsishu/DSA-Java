package gfgPractice;

import java.util.*;

public class ExpressionTreeFromPrefix {

    static class ENode {
        char data;
        ENode left;
        ENode right;

        ENode(char data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        // *+AB-CD
        char prefix[] = { '*', '+', 'A', 'B', '-', 'C', 'D' };
        ENode root = buildTree(prefix);
        printTree(root);
    }

    public static ENode buildTree(char prefix[]) {
        Stack<ENode> s = new Stack<>(); // created a stack
        for (int i = prefix.length - 1; i >= 0; i--) { // traversing the array from right to left
            if (!isOperator(prefix[i])) { // if the element is not an operator we push it onto the stack
                ENode temp = new ENode(prefix[i]);
                s.push(temp);
            } else {
                ENode t2 = s.pop();
                ENode t1 = s.pop();
                ENode temp = new ENode(prefix[i]);
                temp.left = t2;
                temp.right = t1;
                s.push(temp);
            }
        }
        return s.peek();
    }

    public static void printTree(ENode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

}
