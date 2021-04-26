package recursionAndBacktracking;

public class DeleteKthNode {

  static class Node {
    int data;
    Node next;
  
    protected Node(int data) {
      this.data = data;
      next = null;
    }
  }

  public static void main(String[] args) {

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    Node temp = deleteAt(head, 3);
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }

  }

  static Node deleteAt(Node node, int k) {
    if (k < 1) {
      return node;
    }
    if (node == null) {
      return null;
    }
    if (k == 1) {
      Node temp = node.next;
      return temp;
    }
    node.next = deleteAt(node.next, k - 1);
    return node;
  }

}



