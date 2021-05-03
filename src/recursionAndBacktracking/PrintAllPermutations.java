package recursionAndBacktracking;

public class PrintAllPermutations {
  public static void main(String[] args) {
    String str = "ABC";
    int n = str.length();
    permute(str, 0, n - 1);
  }

  static void permute(String str, int l, int r) {
    if (l == r) {
      System.out.print(str + " ");
    } else {
      for (int i = l; i <= r; i++) {
        str = swap(str, l, i);
        permute(str, l + 1, r);
        str = swap(str, l, i);
      }
    }
  }

  static String swap(String s, int i, int j) {
    char temp;
    char[] charArray = s.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
}
