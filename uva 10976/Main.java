// package uva 10976;

import java.util.Scanner;
import java.util.ArrayList;

class Main {

  private static class Pair<T, S> {
    public T left;
    public S right;

    public Pair(T left, S right) {
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String line = sc.nextLine();
    while (!line.equals("")) {
      ArrayList<Pair<Long, Long>> ret = new ArrayList<>();
      int frac = Integer.parseInt(line);
      if (frac == 0) {
        System.out.println("0");
        line = sc.nextLine();
        continue;
      }
      double goal = 1.0 / frac;

      for (long i = frac + 1; i < frac * 2; i++) {
        double res = (i * frac * 1.0) / (i - frac);
        // System.out.println(res);
        // double x = 1.0 / i;
        // for (long j = frac * 2 + 1; j < 100000000; j++) {
        // double sum = x + 1.0 / j;
        if (res - Math.floor(res) < 1e-18) {
          ret.add(new Pair<Long, Long>(i, (long) Math.floor(res)));
        }
        // if (sum < goal) {
        // break;
        // }
        // }
      }
      ret.add(new Pair<Long, Long>(Long.valueOf(frac * 2), Long.valueOf(frac * 2)));
      // System.out.printf("1/%d = 1/%d + 1/%d\n", frac, frac * 2, frac * 2);

      System.out.println(ret.size());
      for (Pair p : ret) {
        System.out.printf("1/%d = 1/%d + 1/%d\n", frac, p.right, p.left);
      }

      line = sc.nextLine();
    }
  }
}
