package misc;
import java.util.*;
public class MinimumJumps {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();
    System.out.println(getSteps(arr));
  }

  public static int getSteps(int arr[]) {
    int n = arr.length;
    int jump = 0;
    int farthest = 0;
    int currEnd = 0;
    for(int i = 0; i < n; i++) {
      farthest = Math.max(farthest, arr[i] + i);
      if(farthest >= n - 1) {
        return 1 + jump;
      }
      if(i == farthest) {
        return -1;
      }
      if(i == currEnd) {
        jump++;
        currEnd = farthest;
      }
    }
    return jump;
  }
}


// int minJumps(int arr[], int n){
//     int jumps = 0, farthest = 0, currEnd = 0;
//     for(int i=0;i<n-1;i++)
//     {
//         farthest = max(farthest, i + arr[i]);
//         if(farthest >= n-1)
//             return 1 + jumps;
        
//         if(i == farthest)
//             return -1;
        
//         if(i == currEnd)
//         {
//             jumps++;
//             currEnd = farthest;
//         }
//     }
//     return jumps;
// }