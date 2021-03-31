package gfgPractice;

import java.util.*;

public class ExpressionTreeFromPostfix {
  public static void main(String[] args) {
    char postFix[] = {'A', 'B', '+', 'C', 'D', '+', '*'};
    Node<Character> root = buildTheTree(postFix);
    printTheTree(root);
  }

  public static void printTheTree(Node<Character> root) {
    if(root == null) {
      return;
    }
    printTheTree(root.left);
    System.out.print(root.data + " ");
    printTheTree(root.right);
  }

  public static Node<Character> buildTheTree(char postFix[]) {
    Stack<Node<Character>> s = new Stack<>();
    Node<Character> t, t1, t2;
    for(int i = 0; i < postFix.length; i++) {
      if(!isOperator(postFix[i])) {
        t = new Node<>(postFix[i]);
        s.push(t);
      } else {
        t = new Node<>(postFix[i]);
        t1 = s.pop();
        t2 = s.pop();
        t.right = t1;
        t.left = t2;
        s.push(t);
      }
    }
    t = s.peek();
    s.pop();
    return t;
  }

  public static Node<Character> buildTheTree(char postFix[], int size) {
    Stack<Node<Character>> s = new Stack<>();
    for(int i = 0; i < size; i++) {
      if(!isOperator(postFix[i])) {
        Node<Character> temp = new Node<>(postFix[i]);
        s.push(temp);
      } else {
        Node<Character> t2 = s.pop();
        Node<Character> t1 = s.pop();
        Node<Character> temp = new Node<>(postFix[i]);
        temp.left = t1;
        temp.right = t2;
        s.push(temp);
      }
    }
    return s.peek();
  }

  public static boolean isOperator(char c) {
    if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
      return true;
    }
    return false;
  }
}
