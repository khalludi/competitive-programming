import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int caseNo = Integer.parseInt(br.readLine());
    while (caseNo > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuffer num1 = new StringBuffer(st.nextToken());
      StringBuffer num2 = new StringBuffer(st.nextToken());

      BigInteger int1 = new BigInteger(num1.reverse().toString());
      BigInteger int2 = new BigInteger(num2.reverse().toString());
      BigInteger sum = int1.add(int2);

      StringBuffer out = new StringBuffer(sum.toString());
      pw.printf("%s\n", new BigInteger(out.reverse().toString()).toString());

      caseNo--;
    }

    pw.close();
  }
}