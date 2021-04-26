package recursionAndBacktracking;

public class CountConsonents {
  public static void main(String[] args) {
    String s = "abc de";
    System.out.println(count(s, s.length()));
  }

  static boolean isConsonent(char ch) {
    ch = Character.toUpperCase(ch);
    return !(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') && ch >= 65 && ch <= 90;
  }

  static int countConsonents(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (isConsonent(s.charAt(i))) {
        count++;
      }
    }
    return count;
  }

  static int count(String s, int n) {
    if (n == 1) {
      if (isConsonent(s.charAt(0))) {
        return 1;
      } else {
        return 0;
      }
    }
    if (isConsonent(s.charAt(n - 1))) {
      return count(s, n - 1) + 1;
    } else {
      return count(s, n - 1);
    }
  }

}
