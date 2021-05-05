package recursionAndBacktracking;

public class LargestNumberInKSwaps {
  public static void main(String[] args) {
    String s = "1234567";
    int k = 4;
    findMaximumNumUtil(s, k);
    System.out.println(max);
  }

  static String max = String.valueOf(Integer.MIN_VALUE);

  static void findMaximumNumUtil(String str, int k) {

    if (Integer.parseInt(str) > Integer.parseInt(max)) {
      max = str;
    }
    if (k == 0) {
      return;
    }
    for (int i = 0; i < str.length() - 1; i++) {
      for (int j = i + 1; j < str.length(); j++) {
        if (str.charAt(j) > str.charAt(i)) {
          str = swap(str, i, j);
          findMaximumNumUtil(str, k - 1);
          str = swap(str, i, j);
        }
      }
    }
  }

  static String swap(String s, int i, int j) {
    // char arr[] = s.toCharArray();
    // char temp = arr[i];
    // arr[i] = arr[j];
    // arr[j] = temp;
    // return String.valueOf(arr);

    // Another approach without using
    // extra space for the char array
    char ith = s.charAt(i);
    char jth = s.charAt(j);
    String left = s.substring(0, i);
    String middle = s.substring(i + 1, j);
    String right = s.substring(j + 1);
    return left + jth + middle + ith + right;
  }

}
