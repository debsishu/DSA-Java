package recursionAndBacktracking;

public class BinaryMore1s0s {
  public static void main(String[] args) {
    printNums(4);
  }

  static void printBinaryRec(String number, int extraOnes, int remainingPlaces) {
    // if the number is generated
    if (remainingPlaces == 0) {
      System.out.print(number + " ");
      return;
    }
    // add 1 to the current number and reduce the remaining places by one
    printBinaryRec(number + "1", extraOnes + 1, remainingPlaces - 1);
    // if there is more one than the zero append 0 and reduce the remaining palces
    // by one
    if (extraOnes > 0) {
      printBinaryRec(number + "0", extraOnes - 1, remainingPlaces - 1);
    }
  }

  static void printNums(int n) {
    String s = "";
    printBinaryRec(s, 0, n);
  }
}
