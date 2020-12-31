// package uva 00927;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Long> ans = new ArrayList<>();
    int testCases = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < testCases; i++) {
      String arr_str = sc.nextLine();
      int[] arr = Arrays.stream(arr_str.split(" ")).mapToInt(Integer::parseInt).toArray();
      int d = Integer.parseInt(sc.nextLine());
      int k = Integer.parseInt(sc.nextLine());

      ans.add(kthIntInSequence(arr, d, k));
    }

    for (long i : ans) {
      System.out.println(i);
    }
  }

  private static long kthIntInSequence(int[] arr, int d, int k) {
    int x = 0;
    int mult = 1;
    while (x < k) {
      x += mult * d;
      mult++;
      // System.out.printf("%d, %d\n", x, mult);
    }
    mult--;
    // System.out.println(x);
    // System.out.println(mult);

    long ret = 0;
    for (int i = 1; i < arr.length; i++) {
      ret += arr[i] * Math.pow(mult, i - 1);
    }

    return ret;
  }
}
