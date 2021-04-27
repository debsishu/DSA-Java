package recursionAndBacktracking;

public class PrintLeafNodes {
  public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(8);
    root.right.left.left = new Node(6);
    root.right.left.right = new Node(7);
    root.right.right.left = new Node(9);
    root.right.right.right = new Node(10);
    printLeafs(root);
  }

  static void printLeafs(Node root) {
    if (root == null) {
      return;
    }
    printLeafs(root.left);
    if (root.left == null && root.right == null) {
      System.out.print(root.data + " ");
    }
    printLeafs(root.right);
  }

  static class Node {
    int data;
    Node left;
    Node right;

    protected Node(int data) {
      this.data = data;
      left = right = null;
    }
  }
}
