package recursionAndBacktracking;

import java.util.*;

public class FactorsCombination {
  // this is a wrong question answer
  // do this again
  public static void main(String[] args) {
    // int n = 16;
    // List<List<Integer>> resultant = factComb(n);
    // for(List<Integer> i : resultant) {
    // for(int j : i) {
    // System.out.print(j + " ");
    // }
    // System.out.println();
    // }

    int n = 16;
    ArrayList<Integer> single_list = new ArrayList<>();
    compute_factors(2, n, 1, single_list);
    for (int i = 0; i < factors_combination.size(); i++) {
      for (int j = 0; j < factors_combination.get(i).size(); j++) {
        System.out.print(factors_combination.get(i).get(j));
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> factComb(int n) {
    List<List<Integer>> result_list = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<>();
    factorsListFunc(2, 1, n, result_list, list);
    return result_list;
  }

  static void factorsListFunc(int first, int each_prod, int n, List<List<Integer>> result_list,
      List<Integer> single_result_list) {
    if (first > n || each_prod > n) {
      return;
    }
    if (each_prod == n) {
      ArrayList<Integer> t = new ArrayList<>(single_result_list);
      result_list.add(t);
      return;
    }
    for (int i = first; i < n; i++) {
      if (i * each_prod > n) {
        break;
      }
      if (n % i == 0) {
        single_result_list.add(i);
        factorsListFunc(i, i * each_prod, n, result_list, single_result_list);
        single_result_list.remove(single_result_list.size() - 1);
      }
    }
  }

  static ArrayList<ArrayList<Integer>> factors_combination = new ArrayList<>();

  static void compute_factors(int current_no, int n, int product, ArrayList<Integer> single_list) {
    if (current_no > (n / 2) || product > n) {
      return;
    }
    if (product == n) {
      factors_combination.add(single_list);
      return;
    }
    single_list.add(current_no);
    compute_factors(current_no, n, product * current_no, single_list);
    single_list.remove(single_list.size());
    compute_factors(current_no + 1, n, product, single_list);
  }

}
