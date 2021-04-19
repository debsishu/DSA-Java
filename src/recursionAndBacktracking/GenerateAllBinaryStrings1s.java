package recursionAndBacktracking;

public class GenerateAllBinaryStrings1s {
  public static void main(String[] args) {
    int n = 3;
    fun(n);
  }

  private static void fun(int n) {
    if (n <= 0) {
      return;
    }
    char[] ch = new char[n];

    ch[0] = '0';
    generate(n, ch, 1);

    ch[0] = '1';
    generate(n, ch, 1);
  }

  private static void generate(int n, char[] ch, int i) {
    if (i == n) {
      System.out.print(new String(ch) + " ");
      return;
    }

    if (ch[i - 1] == '0') {
      ch[i] = '0';
      generate(n, ch, i + 1);
      ch[i] = '1';
      generate(n, ch, i + 1);
    }

    if (ch[i - 1] == '1') {
      ch[i] = '0';
      generate(n, ch, i + 1);
    }
  }

  static void generateStrings(int n, String s) {
    if (n == 0) {
      System.out.print(s + " ");
      return;
    }
    if (s.charAt(s.length() - 1) == '0') {
      String str = s + "0";
      String str1 = s + "1";
      generateStrings(n - 1, str);
      generateStrings(n - 1, str1);
    }
    if (s.charAt(s.length() - 1) == '1') {
      String str = s;
      str = s + "0";
      generateStrings(n - 1, str);
    }
  }

  static void printStrings(int n) {
    String str = "0";
    generateStrings(n - 1, str);
    String str1 = "1";
    generateStrings(n - 1, str1);
  }
}
