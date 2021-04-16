package recursionAndBacktracking;

public class CheckPalindrome {
  public static void main(String[] args) {
    int number = 145412;
    System.out.println(isPalindrome(number));
  }

  static boolean isPalindrome(int number) {
    int temp = reverseNumber(number, 0);
    if(number == temp) {
      return true;
    }
    return false;
  }

  static int reverseNumber(int n, int temp) {
    if(n == 0) {
      return temp;
    }
    // n % 10 gives the last digit of the number
    // n / 10 gives the number without the last digit
    temp = (temp * 10) + (n % 10);
    return reverseNumber(n / 10, temp);
  }
}
