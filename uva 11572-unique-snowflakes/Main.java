import java.util.*;
import java.io.*;

public class Main {

  static HashMap<Integer, Integer> snowflakePosition = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int testcases = Integer.parseInt(br.readLine());
    while (testcases > 0) {
      snowflakePosition.clear();

      int lines = Integer.parseInt(br.readLine());
      int mx = 0, u = 0;
      for (int i = 1; i <= lines; i++) {
        int x = Integer.parseInt(br.readLine());
        Integer r = snowflakePosition.get(x);
        if (r != null && r > u) {
          mx = Math.max(mx, i - u - 1);
          u = r;
        }
        snowflakePosition.put(x, i);
      }
      mx = Math.max(mx, lines - u);
      pw.printf("%d\n", mx);
      testcases--;
    }
    pw.close();
  }
}