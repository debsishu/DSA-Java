package binaryTree;

public class ArrayToBST {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println("The array is");
    for(int e : arr) {
      System.out.print(e + " ");
    }
    ArrayToBST met = new ArrayToBST();
    TreeNode root = buildTree(arr, 0, arr.length - 1);
    System.out.println();
    System.out.println("The Inorder Traversal is : ");
    met.inOrder(root);
    System.out.println();
    System.out.println("The PreOrder Traversal is : ");
    met.preOrder(root);
  }

  public void inOrder(TreeNode root) {
    if(root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public void preOrder(TreeNode root) {
    if(root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  private static TreeNode buildTree(int[] arr, int left, int right) {
    TreeNode newNode;
    if(left > right) {
      return null;
    }
    if(left == right) {
      newNode = new TreeNode(arr[left]);
    } else {
      int mid = left + (right - left) / 2;
      newNode = new TreeNode(arr[mid]);
      newNode.left = buildTree(arr, left, mid - 1);
      newNode.right = buildTree(arr, mid + 1, right);
    }
    return newNode;
  }
}

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int data) {
    this.data = data;
    left = right = null;
  }
}
