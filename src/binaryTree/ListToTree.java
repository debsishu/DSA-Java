package binaryTree;

public class ListToTree {

  Node head;

  void inOrder(Node root) {
    if (root == null) {
      return;
    }
    inOrder(root.prev);
    System.out.print(root.data + " ");
    inOrder(root.next);
  }

  void preOrder(Node root) {
    if(root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.prev);
    preOrder(root.next);
  }

  int lengthOfList(Node head) {
    Node temp = head;
    int length = 0;
    while (temp != null) {
      length++;
      temp = temp.next;
    }
    return length;
  }

  void push(int new_data) {
    Node new_node = new Node(new_data);
    new_node.prev = null;
    new_node.next = head;
    if (head != null) {
      head.prev = new_node;
    }
    head = new_node;
  }

  Node ListToBSTBalanced() {
    int n = lengthOfList(head);
    return convertList(n);
  }

  private Node convertList(int n) {
    if (n <= 0) {
      return null;
    }
    Node left = convertList(n / 2);
    Node root = head;
    root.prev = left;
    head = head.next;
    root.next = convertList(n - n / 2 - 1);
    return root;
  }

  void printList() {
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    ListToTree ll = new ListToTree();
    ll.push(7);
    ll.push(6);
    ll.push(5);
    ll.push(4);
    ll.push(3);
    ll.push(2);
    ll.push(1);
    ll.printList();
    System.out.println();
    Node root = ll.ListToBSTBalanced();
    ll.inOrder(root);
    System.out.println();
    ll.preOrder(root);
  }
}
