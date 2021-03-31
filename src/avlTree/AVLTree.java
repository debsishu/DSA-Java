package avlTree;

public class AVLTree {
  Node root;

  int height(Node n) {
    if (n == null) {
      return 0;
    }
    return n.height;
  }

  int max(int a, int b) {
    return Math.max(a, b);
  }

  int getBalance(Node root) {
    if (root == null) {
      return 0;
    }
    return height(root.left) - height(root.right);
  }

  void inOrder(Node root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  Node rightRotate(Node root) {
    Node newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;
    root.height = max(height(root.left), height(root.right));
    newRoot.height = max(height(newRoot.left), height(newRoot.right));
    return newRoot;
  }

  Node leftRotate(Node root) {
    Node newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;
    root.height = max(height(root.left), height(root.right));
    newRoot.height = max(height(newRoot.left), height(newRoot.right));
    return newRoot;
  }

  Node insert(Node root, int data) {

    // basic binary search tree addition
    if (root == null) {
      return (new Node(data));
    } else if (data < root.data) {
      root.left = insert(root.left, data);
    } else if(data > root.data) {
      root.right = insert(root.right, data);
    } else {
      return root;
    }

    root.height = 1 + max(height(root.left), height(root.right));
    int balance = getBalance(root);

    // Left Left case
    if (balance > 1 && data < root.left.data) {
      return rightRotate(root);
    }

    // Right Right Case
    if (balance < -1 && data > root.right.data) {
      return leftRotate(root);
    }

    // Left Right case
    if (balance > 1 && data > root.left.data) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    // Right Left Case
    if (balance < -1 && data < root.right.data) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }
    return root;
  }
}
