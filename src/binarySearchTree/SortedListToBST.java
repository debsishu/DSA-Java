package binarySearchTree;
public class SortedListToBST {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.prev = head;
    head.next.next = new ListNode(3);
    head.next.next.prev = head.next;
    head.next.next.next = new ListNode(4);
    head.next.next.next.prev = head.next.next;
    Node<Integer> treeRoot = sortedListToBST(head);
    BinarySearchTree.printTreeInorder(treeRoot);
  }

  public static Node<Integer> sortedListToBST(ListNode head) {
    int length = 0;
    ListNode temp = head;
    while(temp != null) {
      length++;
      temp = temp.next;
    }
    return constructTree(head, 0, length - 1);
  }

  private static Node<Integer> constructTree(ListNode head, int start, int end) {
    if(start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    Node<Integer> left = constructTree(head, start, mid - 1);
    Node<Integer> root = new Node<>(head.data);
    root.left = left;
    if(head.next != null) {
      head.data = head.next.data;
      head.next = head.next.next;
    }
    root.right = constructTree(head, mid + 1, end);
    return root;
  }


}

class ListNode {
  int data;
  ListNode prev;
  ListNode next;
  ListNode(int data) {
    this.data = data;
    prev = next = null;
  }
}
