import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String str = br.readLine();
    while (str != null) {
      StringTokenizer st = new StringTokenizer(str);
      int N = Integer.parseInt(st.nextToken());
      BigInteger A = new BigInteger(st.nextToken());

      BigInteger sum = BigInteger.ZERO;
      BigInteger tmp = BigInteger.ONE;
      for (int i = 1; i <= N; i++) {
        sum = sum.add(tmp.multiply(A.pow(i)));
        tmp = tmp.add(BigInteger.ONE);
      }

      pw.printf("%s\n", sum.toString());

      str = br.readLine();
    }

    pw.close();
  }
}