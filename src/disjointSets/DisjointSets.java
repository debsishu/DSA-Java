package disjointSets;

public class DisjointSets {
  private int[] S;

  public DisjointSets(int numElements) {
    S = new int[numElements];
    for (int i = 0; i < S.length; i++) {
      S[i] = -1;
    }
  }

  public void union(int root1, int root2) {
    if (S[root2] < S[root1]) {
      S[root1] = root2;
    } else {
      if (S[root1] == S[root2]) {
        S[root1]--;
      }
      S[root2] = root1;
    }
  }

  // Path Compression
  public int find(int x) {
    if (S[x] < 0) {
      return x;
    } else {
      S[x] = find(S[x]);
      return S[x];
    }
  }

  public static void main(String[] args) {
    int NumElements = 97;
    int NumInSameSet = 14;

    DisjointSets s = new DisjointSets(NumElements);
    int set1, set2;

    for (int k = 1; k < NumInSameSet; k *= 2) {
      for (int j = 0; j + k < NumElements; j += 2 * k) {
        set1 = s.find(j);
        set2 = s.find(j + k);
        s.union(set1, set2);
      }
    }

    for (int i = 0; i < NumElements; i++) {
      System.out.print(s.find(i) + "*");
      if (i % NumInSameSet == NumInSameSet - 1) {
        System.out.println();
      }
    }
    System.out.println();
  }
}
