package gfgPractice;

public class AddOne {
  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(4);
    head.next.next = new Node(3);
    Node newHead = addOne(head);
    while (newHead != null) {
      System.out.print(newHead.data);
    }
    System.out.println();
  }

  public static Node addOne(Node head) {
    Node revHead = reverseList(head);
    Node curr = revHead;
    int carry = 0;
    int sum = 0;
    Node prev = null;
    boolean first = true;
    while (curr != null) {
      prev = curr;
      sum = carry;
      sum += curr.data;
      if (first) {
        sum++;
        first = false;
      }
      curr.data = sum % 10;
      carry = sum / 10;
      curr = curr.next;
    }
    if (carry != 0) {
      Node newNode = new Node(carry);
      prev.next = newNode;
    }
    return reverseList(revHead);
  }

  public static Node reverseList(Node head) {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    next = null;
  }
}
