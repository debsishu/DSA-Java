package recursionAndBacktracking;

public class StringCombinations {
  public static void main(String[] args) {
    String input = "12345";
    allCombinations(input, 0, "");
  }

  static void allCombinations(String input, int length, String output) {
    if (length >= input.length()) {
      System.out.println(output);
      return;
    } else {
      allCombinations(input, length + 1, output + input.charAt(length) + " ");
      // if the next digit exists make a call without the space
      if (input.length() != length + 1)
        allCombinations(input, length + 1, output + input.charAt(length));
    }
  }

}
