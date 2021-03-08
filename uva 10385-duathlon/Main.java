import java.util.*;
import java.io.*;

public class Main {

  static int road;
  static ArrayList<Pair> speed;

  static double getTime(Pair sped, Pair length) {
    return length.first / sped.first + length.second / sped.second;
  }

  static double diff(double val) {
    double lowestTime = 1e9;
    Pair currentLength = new Pair(val, road - val);
    double cheaterTime = getTime(speed.get(speed.size() - 1), currentLength);

    for (int i = 0; i < speed.size() - 1; ++i) {
      lowestTime = Math.min(lowestTime, getTime(speed.get(i), currentLength));
    }

    return (cheaterTime - lowestTime) * 3600.0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringTokenizer st;
    String input = br.readLine();
    boolean first = true;
    while (input != null) {
      if (first) {
        road = Integer.parseInt(input);
        first = false;
      } else {
        road = Integer.parseInt(br.readLine());
      }
      int n_comp = Integer.parseInt(br.readLine());

      speed = new ArrayList<>();
      for (int i = 0; i < n_comp; i++) {
        st = new StringTokenizer(br.readLine());
        speed.add(new Pair(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
      }

      double l = 0;
      double r = road;

      while (r - l > 1e-8) {
        double m1 = (r + r + l) / 3.0;
        double m2 = (r + l + l) / 3.0;

        if (diff(m2) < diff(m1))
          r = m1;
        else
          l = m2;
      }

      if (diff(l) > 0)
        pw.printf("The cheater cannot win.\n");
      else {
        pw.printf("The cheater can win by %d seconds with r = %.2fkm and k = %.2fkm.\n", Math.round(-diff(l)), l,
            road - l);
      }

      input = br.readLine();
    }
    pw.close();
  }

  static class Pair {
    public double first;
    public double second;

    public Pair(double first, double second) {
      this.first = first;
      this.second = second;
    }
  }
}