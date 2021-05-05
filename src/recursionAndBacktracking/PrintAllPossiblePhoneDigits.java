package recursionAndBacktracking;

import java.util.*;

public class PrintAllPossiblePhoneDigits {
  public static void main(String[] args) {
    int number[] = { 2, 3, 4 };
    ArrayList<String> arr = possibleWords(number);
    System.out.println(arr);
  }

  static ArrayList<String> possibleWords(int arr[]) {
    ArrayList<String> result = new ArrayList<>();
    if (arr == null || arr.length == 0) {
      return result;
    }
    String digits = "";
    for (int e : arr) {
      digits += e;
    }
    String mapping[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    combUtil(result, digits, "", 0, mapping);
    return result;
  }

  private static void combUtil(ArrayList<String> result, String digits, String current, int index, String[] mapping) {
    if (index == digits.length()) {
      result.add(current);
      return;
    }
    // This gets the index of the current element
    String letters = mapping[Character.getNumericValue(digits.charAt(index))];
    for (int i = 0; i < letters.length(); i++) {
      combUtil(result, digits, current + letters.charAt(i), index + 1, mapping);
    }
  }

}
