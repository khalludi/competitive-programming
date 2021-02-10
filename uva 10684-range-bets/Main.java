import java.util.Scanner;

// package uva 10684-range-bets;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // StringBuilder results = new StringBuilder();

    while (sc.hasNextInt()) {
      int nums = sc.nextInt();
      int curr_sum = 0;
      int max = -1;
      if (nums == 0) {
        break;
      }
      while (nums > 0) {
        int tmp = sc.nextInt();
        curr_sum += tmp;
        if (curr_sum < 0)
          curr_sum = 0;
        max = Math.max(max, curr_sum);
        nums--;
      }
      if (max <= 0) {
        System.out.println("Losing streak.");
      } else {
        System.out.println("The maximum winning streak is " + String.valueOf(max) + ".");
      }
    }

    // System.out.println(results.toString().substring(0, results.length() - 1));
  }
}
