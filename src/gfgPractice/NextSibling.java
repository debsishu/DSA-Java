package gfgPractice;
import java.util.*;

public class NextSibling {

  public static void provideSiblings(TreeNode root) {
    TreeNode temp = null;
    if(root == null) {
      return;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    q.offer(null);
    while(!q.isEmpty()) {
      temp = q.poll();
      if(temp != null) {
        temp.nextSibling = q.peek();
        if(temp.left != null) {
          q.offer(temp.left);
        }
        if(temp.right != null) {
          q.offer(temp.right);
        }
      } else {
        if(!q.isEmpty()) {
          q.offer(null);
        }
      }
    }
  }

  public static TreeNode provideSiblingsRecursive(TreeNode root) {
    if(root != null) {
      if(root.left != null) {
        root.left.nextSibling = root.right;
      }
      if(root.right != null) {
        if(root.nextSibling != null) {
          root.right.nextSibling = root.nextSibling.left;
        }
      }
      provideSiblingsRecursive(root.left);
      provideSiblingsRecursive(root.right);
      return root;
    }
    return null;
  }

  public static void printLevel(TreeNode n) {
    while(n != null) {
      System.out.print(n.data + " ");
      n = n.nextSibling;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    // provideSiblings(root);
    TreeNode i = provideSiblingsRecursive(root);
    printLevel(i);
    System.out.println();
    printLevel(i.left);
    System.out.println();
    printLevel(i.left.left);
  }

}

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode nextSibling;
  TreeNode(int data) {
    this.data = data;
    left = right = nextSibling = null;
  }
}
