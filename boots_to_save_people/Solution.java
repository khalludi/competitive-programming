// package boots_to_save_people;

import java.util.Arrays;

public class Solution {
  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int ret = 0;
    int startIdx = 0;
    int endIdx = people.length - 1;
    while (startIdx <= endIdx) {
      int startPpl = startIdx < people.length ? people[startIdx] : 0;
      int endPpl = endIdx >= 0 ? people[endIdx] : 0;
      if (startPpl + endPpl <= limit) {
        startIdx++;
        endIdx--;
        ret++;
      } else {
        endIdx--;
        ret++;
      }
      System.out.printf("%d, %d\n", startIdx, endIdx);
    }

    return ret;
  }

  public static void main(String[] args) {
    int[] people = { 2, 4 };
    int limit = 5;
    int ans = numRescueBoats(people, limit);
    System.out.println("Answer: " + String.valueOf(ans));
  }
}
