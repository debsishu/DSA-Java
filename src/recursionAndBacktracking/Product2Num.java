package recursionAndBacktracking;

public class Product2Num {
  public static void main(String[] args) {
    System.out.println(product(5, 100));
  }

  static int productUtil(int num, int into) {
    if(into == 1) {
      return num;
    }
    if(into == 0) {
      return 0;
    }
    return productUtil(num, into - 1) + num;
  }

  static int product(int num, int into) {
    if(num > into) {
      return productUtil(num, into);
    } else {
      return productUtil(into, num);
    }
  }
}
