package misc;

public class HBgenerate {
  static int count;
  public static void main(String[] args) {
    BSTNode root = buildHBO(3);
    inOrder(root);
  }

  public static void inOrder(BSTNode root) {
    if(root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }
  public static BSTNode buildHBO(int h) {
    BSTNode temp;
    if(h == 0) {
      return null;
    }
    temp = new BSTNode();
    temp.left = buildHBO(h-1);
    temp.data = count++;
    temp.right = buildHBO(h-1);
    return temp;
  }
}

class BSTNode {
  int data;
  BSTNode left;
  BSTNode right;
}
