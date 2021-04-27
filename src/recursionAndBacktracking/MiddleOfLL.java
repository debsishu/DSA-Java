package recursionAndBacktracking;

public class MiddleOfLL {
  public static void main(String[] args) {

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    System.out.println(getMiddle(head, head));
    System.out.println(getMiddle(head));

  }

  // this is similar to the two pointer algo.
  // We are using recursion instead of while loop

  static int getMiddle(Node fast, Node slow) {
    if (fast.next == null) {
      return slow.data;
    }
    if (fast.next.next == null) {
      fast = fast.next;
    } else {
      fast = fast.next.next;
    }
    return getMiddle(fast, slow.next);
  }

  // This is the iterative technique
  static int getMiddle(Node head) {
    if (head == null) {
      return 0;
    }
    Node fast = head;
    Node slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.data;
  }

  static class Node {
    int data;
    Node next;

    protected Node(int data) {
      this.data = data;
      next = null;
    }
  }
}
