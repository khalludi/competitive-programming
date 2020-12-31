// package permutation;

import java.util.Scanner;

public class nextPermutation {

  private static void distinctPerm(String s, String ans) {
    if (s.length() == 0) {
      System.out.println(ans);
      return;
    }

    boolean[] used = new boolean[26];
    for (int i = 0; i < s.length(); i++) {
      if (used[s.charAt(i) - 'a']) {
        continue;
      }
      used[s.charAt(i) - 'a'] = true;
      char ch = s.charAt(i);
      String new_str = s.substring(0, i) + s.substring(i + 1);
      distinctPerm(new_str, ans + ch);
    }
  }

  private static void nextPerm(String s, String ans) {
    if (s.length() == 0) {
      System.out.println(ans);
      return;
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      String new_str = s.substring(0, i) + s.substring(i + 1);
      nextPerm(new_str, ans + ch);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.printf("Enter string to permute: ");
    String s = sc.nextLine();
    nextPerm(s, "");
    distinctPerm(s, "");
    sc.close();
  }
}
