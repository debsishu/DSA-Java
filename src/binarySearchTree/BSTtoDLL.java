package binarySearchTree;

public class BSTtoDLL {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(6);
    root.left = new Node<>(2);
    root.left.left = new Node<>(1);
    root.left.right = new Node<>(4);
    root.left.right.left = new Node<>(3);
    root.right = new Node<>(8);
  }

}
