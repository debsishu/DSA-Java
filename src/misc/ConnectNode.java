package misc;
import java.util.*;
public class ConnectNode {
  
  public static void main(String[] args) {
    ADNode root = new ADNode(4);
    root.left = new ADNode(2);
    root.left.left = new ADNode(1);
    root.left.right = new ADNode(3);
    root.right = new ADNode(6);
    root.right.left = new ADNode(5);
    root.right.right = new ADNode(7);
    linkLevelNodes(root);

    ADNode temp = root;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public static void linkLevelNodes(ADNode root) {
    Queue<ADNode> q = new LinkedList<>();
    ADNode prev;
    ADNode temp;
    int currentLevelNodeCount;
    int nextLevelNodeCount;
    if(root == null) {
      return;
    }
    q.offer(root);
    currentLevelNodeCount = 1;
    nextLevelNodeCount = 0;
    prev = null;
    while(!q.isEmpty()) {
      temp = q.poll();
      if(temp.left != null) {
        q.offer(temp.left);
        nextLevelNodeCount++;
      }
      if(temp.right != null) {
        q.offer((temp.right));
        nextLevelNodeCount++;
      }
      if(prev != null) {
        prev.next = temp;
        prev = temp;
        currentLevelNodeCount--;
        if(currentLevelNodeCount == 0) {
          currentLevelNodeCount = nextLevelNodeCount;
          nextLevelNodeCount = 0;
          prev = null;
        }
      }
    } 
  }

}


class ADNode {
  int data;
  ADNode left;
  ADNode right;
  ADNode next;
  ADNode (int data) {
    this.data = data;
    left = right = next = null;
  }
  ADNode() {

  }
}