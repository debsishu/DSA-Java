package binarySearchTree;

public class Test {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(10);
    root.left = new Node<>(6);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(9);
    root.left.right.left = new Node<>(7);
    root.right = new Node<>(16);
    root.right.left = new Node<>(13);
    inorderPrint(root);
  }

  public static void inorderPrint(Node<Integer> root) {
    if(root == null) {
      return;
    }
    inorderPrint(root.left);
    System.out.print(root.data + " ");
    inorderPrint(root.right);
  }
}
