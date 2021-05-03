package recursionAndBacktracking;

public class StepsToReachDest {
  public static void main(String[] args) {
    int dest = 2;
    // System.out.println(steps(0, 0, dest));
    System.out.println(stepsIter(dest));
  }

  static int steps(int source, int step, int dest) {
    if (Math.abs(source) > (dest)) {
      return Integer.MAX_VALUE;
    }
    if (source == dest) {
      return step;
    }
    int pos = steps(source + step + 1, step + 1, dest);
    int neg = steps(source - step + 1, step + 1, dest);
    return Math.min(pos, neg);
  }

  // Did not understood
  // Alternative approach
  static int stepsIter(int dest) {
    if (dest == 0 || dest == 1) {
      return dest;
    }
    int sum = 0;
    int count = 1;
    while (true) {
      sum += count;
      if (sum == dest) {
        return count;
      }
      if (sum > dest && (sum - dest) % 2 == 0) {
        return count;
      }
      count++;
    }
  }
}
