package gfgPractice;

import java.util.*;

public class PrintZigZag {

  public static void main(String[] args) {
    Node<Integer> root = new Node<Integer>(1);
    root.left = new Node<Integer>(2);
    root.right = new Node<Integer>(3);
    root.left.left = new Node<Integer>(4);
    root.left.right = new Node<Integer>(5);
    root.right.left = new Node<Integer>(6);
    root.right.right = new Node<Integer>(7);
    ArrayList<Integer> res = ZigZagLevel(root);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i) + " ");
    }
  }

  public static ArrayList<Integer> ZigZagLevel(Node<Integer> root) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<Node<Integer>> q = new LinkedList<>();
    q.offer(root);
    q.offer(null);
    boolean leftToRight = true;
    ArrayList<Integer> curr = new ArrayList<>();
    while (!q.isEmpty()) {
      Node<Integer> temp = q.poll();
      if (temp != null) {
        curr.add(temp.data);
        if (temp.left != null) {
          q.offer(temp.left);
        }
        if (temp.right != null) {
          q.offer(temp.right);
        }
      } else {
        if (leftToRight) {
          res.addAll(curr);
          curr.clear();
        } else {
          Stack<Integer> s = new Stack<>();
          s.addAll(curr);
          while (!s.isEmpty()) {
            res.add(s.pop());
          }
          curr.clear();
        }
        if (!q.isEmpty()) {
          q.offer(null);
          leftToRight = !leftToRight;
        }
      }
    }
    return res;
  }

}
