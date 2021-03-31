package gfgPractice;

public class HeightOfTree {
  public static void main(String[] args) {
    int arr[] = {-1, 0, 1, 6, 6, 0, 0, 2, 7};
    System.out.println(findDepth(arr));
  }

  public static int findDepth(int arr[]) {
    int maxDepth = -1;
    int currDepth = -1;
    int j;
    for(int i = 0; i<arr.length; i++) {
      currDepth = 0;
      j = i;
      while(arr[j] != -1) {
        currDepth++;
        j = arr[j];
      }
      if(currDepth > maxDepth) {
        maxDepth = currDepth;
      }
    }
    return maxDepth;
  }

}
