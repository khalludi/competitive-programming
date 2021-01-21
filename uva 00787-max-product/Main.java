import java.util.Scanner;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BigInteger stop = new BigInteger("-999999");
    BigInteger[][] memo = new BigInteger[101][100];

    BigInteger max = new BigInteger("-888880");
    int idx = 0;
    while (sc.hasNextBigInteger()) {
      BigInteger curr = sc.nextBigInteger();
      if (curr.compareTo(stop) == 0) {
        idx = 0;
        System.out.println(max);
        max = new BigInteger("-888880");
        continue;
      }

      memo[idx][0] = curr;
      max = max.max(memo[idx][0]);
      for (int i = 0; i < idx; i++) {
        memo[i][idx - i] = memo[i][idx - i - 1].multiply(curr);
        max = max.max(memo[i][idx - i]);
        // System.out.println(memo[i][idx - i]);
      }
      idx++;
    }
  }
}
