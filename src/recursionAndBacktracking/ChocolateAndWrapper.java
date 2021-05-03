package recursionAndBacktracking;

public class ChocolateAndWrapper {
  public static void main(String[] args) {
    int money = 16;
    int price = 2;
    int wrap = 2;
    System.out.println(countMaxChocoImp(money, price, wrap));
  }

  static int countRec(int choc, int wrap) {
    // if the number of chocolates is less than
    // number of wrappers
    if (choc < wrap) {
      return 0;
    }
    // get the new chocolate number
    int newChoc = choc / wrap;
    return newChoc + countRec(newChoc + choc % wrap, wrap);
  }

  static int countMaxChoco(int money, int price, int wrap) {
    int choc = money / price;
    return choc + countRec(choc, wrap);
  }

  static int countMaxChocoImp(int money, int price, int wrap) {
    // this is edge case
    if (money < price) {
      return 0;
    }
    // number of chocolates that can be
    // purchased with the money
    int choc = money / price;
    choc = choc + (choc - 1) / (wrap - 1);
    return choc;
  }

}
