package recursionAndBacktracking;

public class ReverseString {
  public static void main(String[] args) {
    String s = "Debsishu";
    System.out.println(reverseS(s));
    System.out.println(s.length());
  }

  // Article link here : https://beginnersbook.com/2017/09/java-program-to-reverse-a-string-using-recursion/

  static void reverse(String s) {
    if (s == null || s.length() <= 1) {
      System.out.print(s);
    } else {
      System.out.print(s.charAt(s.length() - 1));
      reverse(s.substring(0, s.length() - 1));
    }
  }

  static String reverseS(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }
    return reverseS(s.substring(1, s.length())) + s.charAt(0);
  }

}
