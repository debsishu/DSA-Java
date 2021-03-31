package binaryTree;

public class RangePrinter {
  public static void main(String[] args) {
    RangePrinter prog = new RangePrinter();
    Node root = new Node(4);
    root.prev = new Node(2);
    root.prev.prev = new Node(1);
    root.prev.next = new Node(3);
    root.next = new Node(6);
    root.next.prev = new Node(5);
    root.next.next = new Node(7);
    prog.printInRange(root, 3, 6);
  }

  void printInRange(Node root, int start, int end) {
    if (root == null) {
      return;
    }
    printInRange(root.prev, start, end);
    if (root.data > start && root.data < end) {
      System.out.println(root.data);
    }
    printInRange(root.next, start, end);
  }

}
