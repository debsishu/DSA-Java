package binaryTree;

import java.util.*;

public class SinglyLinkedListToBST {
  public static void main(String[] args) {
    ArrayToBST arr = new ArrayToBST();
    SinglyLinkedListToBST met = new SinglyLinkedListToBST();
    LinkedList<Integer> ll = new LinkedList<>();
    ll.add(1);
    ll.add(2);
    ll.add(3);
    ll.add(4);
    ll.add(5);
    ll.add(6);
    ll.add(7);
    ll.add(8);
    int n = ll.size();
    // TreeNode root = met.ListToBST(ll, 0, n - 1);
    TreeNode root = met.SortedListToBST(ll, 0, n - 1);
    arr.inOrder(root);
    System.out.println();
    arr.preOrder(root);
  }

  TreeNode ListToBST(LinkedList<Integer> ll, int start, int end) {
    TreeNode root;
    if (start > end) {
      return null;
    }
    if (start == end) {
      root = new TreeNode(ll.get(start));
    } else {
      int mid = start + (end - start) / 2;
      root = new TreeNode(ll.get(mid));
      root.left = ListToBST(ll, start, mid - 1);
      root.right = ListToBST(ll, mid + 1, end);
    }
    return root;
  }

  TreeNode SortedListToBST(LinkedList<Integer> ll, int start, int end) {
    if(start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode left = SortedListToBST(ll, start, mid - 1);
    TreeNode parent = new TreeNode(ll.getFirst());
    parent.left = left;
    ll.removeFirst();
    parent.right = SortedListToBST(ll, mid + 1, end);
    return parent;
  }

}
