package binarySearchTree;

import java.util.Stack;

public class BinarySearchTree {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(6);
    root.left = new Node<>(2);
    root.left.left = new Node<>(1);
    root.left.right = new Node<>(4);
    root.left.right.left = new Node<>(3);
    root.right = new Node<>(8);
    System.out.println(LCA(root, 4, 8).data);
    System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    System.out.println(isBSTIterative(root));
  }

  public static void printTreeInorder(Node<Integer> root) {
    if (root == null) {
      return;
    }
    printTreeInorder(root.left);
    System.out.print(root.data + " ");
    printTreeInorder(root.right);
  }

  public static Node<Integer> insert(Node<Integer> root, int data) {
    if (root == null) {
      root = new Node<>(data);
    } else {
      if (data < root.data) {
        root.left = insert(root.left, data);
      } else if (data > root.data) {
        root.right = insert(root.right, data);
      }
    }
    return root;
  }

  public static Node<Integer> delete(Node<Integer> root, int data) {
    if (root == null) {
      return root;
    } else if (data < root.data) {
      delete(root.left, data);
    } else if (data > root.data) {
      delete(root.right, data);
    } else {
      if (root.left == null && root.right == null) {
        root = null;
      } else if (root.left == null) {
        root = root.right;
      } else if (root.right == null) {
        root = root.left;
      } else {
        Node<Integer> temp = findMin(root.right);
        root.data = temp.data;
        root.right = delete(root.right, temp.data);
      }
    }
    return root;
  }

  public static Node<Integer> LCA(Node<Integer> root, int a, int b) {

    /*
     * Create a recursive function that takes a node and the two values n1 and n2.
     * 
     * If the value of the current node is less than both n1 and n2, then LCA lies
     * in the right subtree. Call the recursive function for the right subtree.
     * 
     * If the value of the current node is greater than both n1 and n2, then LCA lies
     * in the left subtree. Call the recursive function for the left subtree.
     * 
     * If both the above cases are false then return the current node as LCA.
     */
    if (root == null) {
      return root;
    }
    if (root.data > a && root.data > b) {
      return LCA(root.left, a, b);
    }
    if (root.data < a && root.data < b) {
      return LCA(root.right, a, b);
    }
    return root;
  }

  public static Node<Integer> findMax(Node<Integer> root) {
    if (root == null) {
      return null;
    }
    while (root.right != null) {
      root = root.right;
    }
    return root;
  }

  public static Node<Integer> findMin(Node<Integer> root) {
    if (root == null) {
      return null;
    }
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  //initialize max and min with Integer.MAX_VALUE and Integer.MIN_VALUE 
  public static boolean isBST(Node<Integer> root, int min, int max) {
    if(root == null) {
      return true;
    }
    if(root.data < min || root.data > max) {
      return false;
    }
    return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
  }

  public static boolean isBSTIterative(Node<Integer> root) {
    if(root == null) {
      return true;
    }
    Stack<Node<Integer>> stack = new Stack<>();
    Node<Integer> node = root;
    int prev = Integer.MIN_VALUE;
    int current;
    while(true) {
      if(node != null) {
        stack.push(node);
        node = node.left;
      } else {
        if(stack.isEmpty()) {
          break;
        } 
        node = stack.pop();
        current = node.data;
        if(current < prev) {
          return false;
        }
        prev = current;
        node = node.right;
      }
    }
    return true;
  }
  
}
