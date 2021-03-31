package gfgPrac;

import java.util.*;

public class BinarySearchBasics {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int t = sc.nextInt();

        while (t-- > 0) {

            int num = sc.nextInt();

            if (binarySearch(arr, 0, n - 1, num) == -1) {
                System.out.print("NO ");
            } else {
                System.out.print("YES ");
            }

            int lower = lowerBound(arr, 0, n - 1, num);

            if (lower < 0) {
                System.out.print("-1 ");
            } else {
                System.out.print(arr[lower] + " ");
            }

            int upper = upperBound(arr, 0, n - 1, num);

            if (upper < n) {
                System.out.print(arr[upper]);
            } else {
                System.out.print("-1");
            }
            System.out.println();

        }
        sc.close();

    }

    public static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - 1) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static int lowerBound(int arr[], int low, int high, int X) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] >= X) {
            return lowerBound(arr, low, mid - 1, X);
        }
        return lowerBound(arr, mid + 1, high, X);
    }

    public static int upperBound(int arr[], int low, int high, int X) {
        if (low > high)
            return low;
        int mid = low + (high - low) / 2;
        if (arr[mid] <= X) {
            return upperBound(arr, mid + 1, high, X);
        }
        return upperBound(arr, low, mid - 1, X);
    }

}
