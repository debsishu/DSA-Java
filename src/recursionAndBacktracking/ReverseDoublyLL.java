package recursionAndBacktracking;

public class ReverseDoublyLL {

  static class DoublyLinkedList {

    Node head;
    Node tail;
    int length;

    void print() {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
      System.out.println();
    }

    void add(int data) {
      Node toAdd = new Node(data);
      if (head == null) {
        head = toAdd;
        tail = head;
        length++;
        return;
      }
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = toAdd;
      toAdd.prev = temp;
      tail = toAdd;
      length++;
    }

  }

  public static void main(String[] args) {
    DoublyLinkedList ll = new DoublyLinkedList();
    ll.add(3);
    ll.add(4);
    ll.add(5);
    ll.add(1);
    ll.add(6);
    ll.print();
    Node head = ll.head;
    ll.head = reverse(head);
    ll.print();
  }

  static Node reverse(Node node) {
    if (node == null)
      return null;
    Node temp = node.next;
    node.next = node.prev;
    node.prev = temp;
    if (node.prev == null) {
      return node;
    }
    return reverse(node.prev);
  }

  static class Node {
    int data;
    Node next;
    Node prev;

    protected Node(int data) {
      this.data = data;
      next = prev = null;
    }
  }

}
