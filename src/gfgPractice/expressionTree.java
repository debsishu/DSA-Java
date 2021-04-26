package gfgPractice;
import java.util.*;
public class expressionTree {

  static class nodeTree {
    char data;
    nodeTree left;
    nodeTree right;
    nodeTree(char data) {
      this.data = data;
      left = right = null;
    }
  }
  public static void main(String[] args) {
    char postFix[] = {'A', 'B', '+', 'C', 'D', '+', '*'};
    nodeTree root = buildExpressionTree(postFix);
    printTree(root);
  }

  public static void printTree(nodeTree root) {
    if(root == null) {
      return;
    }
    printTree(root.left);
    System.out.print(root.data + " ");
    printTree(root.right);
  }

  public static nodeTree buildExpressionTree(char postFix[]) {
    Stack<nodeTree> s = new Stack<nodeTree>();
    nodeTree t, t1, t2;
    for(int i = 0; i < postFix.length; i++) {
      if(!isOperator(postFix[i])) {
        t = new nodeTree(postFix[i]);
        s.push(t);
      } else {
        t = new nodeTree(postFix[i]);
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

  public static boolean isOperator(char c) {
    if(c == '+' || c == '-' || c == '*' || c == '/') {
      return true;
    }
    return false;
  }
}


