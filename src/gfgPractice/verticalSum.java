package gfgPractice;
import java.util.*;
public class verticalSum {

  static class ListNode {
    int data;
    ListNode prev;
    ListNode next;
    ListNode(int data, ListNode prev, ListNode next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
  
  
  public static void main(String[] args) {
    Node<Integer> root = new Node<Integer>(1);
    root.left = new Node<Integer>(2);
    root.right = new Node<Integer>(3);
    root.left.left = new Node<Integer>(4);
    root.left.right = new Node<Integer>(5);
    root.right.left = new Node<Integer>(6);
    root.right.right = new Node<Integer>(7);
    ArrayList<Integer> verticalSum = printVericalSum(root);
    for(int i = 0;i < verticalSum.size(); i++) {
      System.out.print(verticalSum.get(i) + " ");
    }
  }

  public static ArrayList<Integer> printVericalSum(Node<Integer> root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    ListNode head = vertical(root);
    while(head != null && head.prev != null) {
      head = head.prev;
    }
    ListNode temp = head;
    while(temp != null) {
      res.add(temp.data);
      temp = temp.next;
    }
    return res;
  }

  public static void printSum(Node<Integer> root, ListNode curr) {
    if(root == null) {
      return;
    }
    curr.data += root.data;
    if(root.left != null && curr.prev == null) {
      curr.prev = new ListNode(0, null, curr);
    }
    if(root.right != null && curr.next == null) {
      curr.next = new ListNode(0, curr, null);
    }
    printSum(root.left, curr.prev);
    printSum(root.right, curr.next);
  }

  public static ListNode vertical(Node<Integer> root) {
    ListNode curr = new ListNode(0, null, null);
    printSum(root, curr);
    return curr;
  }

  
}

}
