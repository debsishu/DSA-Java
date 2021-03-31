package gfgPrac;

public class HeightOfTree {
  public static void main(String[] args) {
    HeightOfTree prog = new HeightOfTree();
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(3);
    root.left.right = new Node(4);
    root.left.left.left = new Node(5);
    root.right = new Node(6);
    System.out.println(prog.heightOf(root));
  }

  int heightOf(Node root) {
    if (root == null) {
      return 0;
    }
    int left = heightOf(root.left);
    int right = heightOf(root.right);
    if (left > right) {
      return left + 1;
    } else {
      return right + 1;
    }
  }

}

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = right = null;
  }
}