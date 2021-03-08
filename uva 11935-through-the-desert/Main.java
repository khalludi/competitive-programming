import java.util.*;
import java.io.*;

public class Main {

  static char[] events = new char[55];
  static int[] km = new int[55];
  static int[] val = new int[55];
  static int idx = 0;

  static boolean can(double fuel) {

    double init = fuel;
    int ckm = 0, leak = 0, cons = 0;
    for (int i = 0; i <= idx; i++) {
      fuel = fuel - (km[i] - ckm) * leak - (km[i] - ckm) / 100.0 * cons;
      if (fuel < 0)
        return false;
      if (events[i] == 'F') {
        cons = val[i];
      } else if (events[i] == 'L') {
        leak++;
      } else if (events[i] == 'M') {
        leak = 0;
      } else if (events[i] == 'G' && fuel >= 0) {
        fuel = init;
      }
      ckm = km[i];
    }

    return fuel >= 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String input = br.readLine();
    while (!input.equals("0 Fuel consumption 0")) {

      idx = 0;
      StringTokenizer st = new StringTokenizer(input);
      int my_km = Integer.parseInt(st.nextToken());
      String my_event = st.nextToken();
      while (!my_event.substring(0, 2).equals("Go")) {

        char c = my_event.charAt(0);
        if (c == 'F') {
          events[idx] = c;
          km[idx] = my_km;
          st.nextToken();
          val[idx] = Integer.parseInt(st.nextToken());
        } else {
          events[idx] = c;
          km[idx] = my_km;
        }

        st = new StringTokenizer(br.readLine());
        my_km = Integer.parseInt(st.nextToken());
        my_event = st.nextToken();
        idx++;
      }
      events[idx] = 'g';
      km[idx] = my_km;

      // Binary Search The Answer
      double lo = 0.0, hi = 10000.00;
      while (Math.abs(hi - lo) > 1e-9) {
        double mid = (lo + hi) / 2.0;
        if (can(mid))
          hi = mid;
        else
          lo = mid;
      }
      pw.printf("%.3f\n", hi);

      input = br.readLine();
    }

    pw.close();
  }
}