package binaryTree;

public class FloorAndCeiling {
  public static void main(String[] args) {
    FloorAndCeiling prog = new FloorAndCeiling();
    Node root = new Node(10);
    root.prev = new Node(8);
    root.prev.prev = new Node(1);
    root.prev.next = new Node(2);
    root.next = new Node(12);
    root.next.prev = new Node(11);
    root.next.next = new Node(19);
    Node prev = null;
    System.out.println(prog.FloorInBST(root, prev, 18).data);
    System.out.println(prog.CeilingInBST(root, 18));
  }


  Node FloorInBST(Node root, Node prev, int data) {
    if(root == null) {
      return null;
    }
    FloorInBST(root.prev, prev, data);
    if(root.data == data) {
      return root;
    }
    if(root.data > data) {
      return prev;
    }
    prev = root;
    return FloorInBST(root.next, prev, data);
  }

  int CeilingInBST(Node node, int input) {
    if(node == null) {
      return -1;
    }
    if(node.data == input) {
      return node.data;
    }
    if(node.data < input) {
      return CeilingInBST(node.next, input);
    }
    int ceil = CeilingInBST(node.prev, input);
    if(ceil >= input) {
      return ceil;
    } else {
      return node.data;
    }
  }

}
