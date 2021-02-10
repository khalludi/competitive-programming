import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    BigInteger num1 = new BigInteger(br.readLine());
    BigInteger num2 = new BigInteger(br.readLine());
    BigInteger sum = num1.add(num2);

    pw.println(sum.toString());
    pw.close();
  }
}