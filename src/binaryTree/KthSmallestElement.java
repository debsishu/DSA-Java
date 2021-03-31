package binaryTree;

public class KthSmallestElement {
  public static void main(String[] args) {
    KthSmallestElement func = new KthSmallestElement();
    Node root = new Node(4);
    root.prev = new Node(2);
    root.prev.prev = new Node(1);
    root.prev.next = new Node(3);
    root.next = new Node(6);
    root.next.prev = new Node(5);
    root.next.next = new Node(7);
    func.traverse(root, 5);
    System.out.println(func.number);
    func.printTree(root);
  }

  void printTree(Node root) {
    if(root == null) {
      return;
    }
    printTree(root.prev);
    System.out.print(root.data + " ");
    printTree(root.next);
  }

  int count = 0;

  Node KthSmallest(Node root, int k) {
    if (root == null) {
      return null;
    }
    Node left = KthSmallest(root.prev, k);
    if(left != null) {
      return left;
    }
    if (++count == k) {
      return root;
    }
    return KthSmallest(root.next, k);
  }
  int number = -1;
  void traverse(Node root, int k) {
    if(root.prev != null) {
      traverse(root.prev, k);
    }
    count++;
    if(count == k) {
      number = root.data;
      return;
    }
    if(root.next != null) {
      traverse(root.next, k);
    }
  }
}
