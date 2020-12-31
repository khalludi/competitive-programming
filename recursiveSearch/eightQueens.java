package recursiveSearch;

import java.util.Scanner;

public class eightQueens {

  private static int row[] = new int[8];
  private static int TC, a, b, lineCounter;

  static boolean place(int r, int c) {
    for (int prev = 0; prev < c; prev++) {
      if (row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c))) {
        return false;
      }
    }
    return true;
  }

  static void backtrack(int c) {
    if (c == 8 && row[b] == a) {
      System.out.printf("%2d     %d", ++lineCounter, row[0] + 1);
      for (int j = 1; j < 8; j++) {
        System.out.printf(" %d", row[j] + 1);
      }
      System.out.println();
    }
    for (int r = 0; r < 8; r++) {
      if (place(r, c)) {
        row[c] = r;
        backtrack(c + 1);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    TC = sc.nextInt();
    while (TC-- > 0) {
      a = sc.nextInt();
      a--;
      b = sc.nextInt();
      b--;
      lineCounter = 0;
      System.out.println();
      backtrack(0);
      if (TC > 0)
        System.out.printf("\n");
    }
    sc.close();
  }
}