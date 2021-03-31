package gfgPractice;

public class QuasiIsomorphic {
  public static void main(String[] args) {

    //tree 1
    Node<Integer> root1 = new Node<Integer>(1);
    root1.left = new Node<Integer>(2);
    root1.right = new Node<Integer>(3);
    root1.left.left = new Node<Integer>(4);
    root1.left.right = new Node<Integer>(5);
    root1.left.right.left = new Node<Integer>(7);
    root1.right.left = new Node<Integer>(6);
    root1.right.left.left = new Node<Integer>(8);

    //tree 2
    Node<Integer> root2 = new Node<Integer>(1);
    root2.left = new Node<Integer>(5);
    root2.left.left = new Node<Integer>(3);
    root2.left.left.right = new Node<Integer>(7);
    root2.right = new Node<Integer>(6);
    root2.right.left = new Node<Integer>(8);
    root2.right.left.left = new Node<Integer>(4);
    root2.right.right = new Node<Integer>(2);

    System.out.println(isQuasiIsomorphic(root1, root2));
  }

  public static boolean isQuasiIsomorphic(Node<Integer> root1, Node<Integer> root2) {
    if(root1 == null && root2 == null) {
      return true;
    }
    if(root1 == null || root2 == null) {
      return false;
    }
    return ((isQuasiIsomorphic(root1.left, root2.left) && isQuasiIsomorphic(root1.right, root2.right)) 
    || (isQuasiIsomorphic(root1.left, root2.right) && isQuasiIsomorphic(root1.right, root2.left)));
  }
}
