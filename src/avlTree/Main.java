package avlTree;

public class Main {
  public static void main(String[] args) {
    AVLTree tree = new AVLTree();

    tree.root = tree.insert(tree.root, 10);
    tree.root = tree.insert(tree.root, 20);
    tree.root = tree.insert(tree.root, 30);
    tree.root = tree.insert(tree.root, 40);
    tree.root = tree.insert(tree.root, 50);
    tree.root = tree.insert(tree.root, 60);
    tree.root = tree.insert(tree.root, 70);
    tree.root = tree.insert(tree.root, 80);

    System.out.println("Inorder Treaversal of this tree is : ");
    tree.inOrder(tree.root);
  }
}
