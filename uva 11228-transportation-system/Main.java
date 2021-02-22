import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<ArrayList<IntegerPair>> AL = new ArrayList<>();
  static ArrayList<Boolean> taken = new ArrayList<>();
  static PriorityQueue<IntegerPair> pq = new PriorityQueue<>();

  static void process(int u) {
    taken.set(u, true);
    for (IntegerPair v_w : AL.get(u)) {
      if (!taken.get(v_w.first())) {
        pq.offer(new IntegerPair(v_w.second(), v_w.first()));
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int testcases = Integer.parseInt(br.readLine());
    int testcase = 1;
    StringTokenizer st;
    while (testcase <= testcases) {
      // Reset
      if (testcase != 1) {
        AL.clear();
        taken.clear();
        pq.clear();
      }

      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      for (int i = 0; i < n; i++) {
        taken.add(false);
      }

      ArrayList<IntegerPair> cityCenter = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        cityCenter.add(new IntegerPair(x, y));
      }

      for (int i = 0; i < cityCenter.size(); i++) {
        ArrayList<IntegerPair> neighbors = new ArrayList<>();
        for (int j = 0; j < cityCenter.size(); j++) {
          if (i == j) {
            continue;
          }
          int x_diff = cityCenter.get(i).first() - cityCenter.get(j).first();
          int y_diff = cityCenter.get(i).second() - cityCenter.get(j).second();
          neighbors.add(new IntegerPair(j, x_diff * x_diff + y_diff * y_diff));
          // System.out.printf("%d, %d; %d, %d; %d\n", cityCenter.get(i).first(),
          // cityCenter.get(i).second(),
          // cityCenter.get(j).first(), cityCenter.get(j).second(), x_diff * x_diff +
          // y_diff * y_diff);
        }
        AL.add(neighbors);
      }

      double rail_cost = 0, road_cost = 0;
      int num_states = 1, num_taken = 0;
      process(0);
      while (!pq.isEmpty()) {
        IntegerPair front = pq.poll();
        int u = front.second(), w = front.first();
        if (taken.get(u))
          continue;
        if (w > r * r) {
          num_states++;
          rail_cost += Math.sqrt(w);
        } else {
          road_cost += Math.sqrt(w);
        }
        process(u);
        ++num_taken;
        if (num_taken == n - 1)
          break;
      }

      pw.printf("Case #%d: %d %d %d\n", testcase, num_states, Math.round(road_cost), Math.round(rail_cost));

      testcase++;
    }

    pw.close();
  }

  static class IntegerPair implements Comparable<IntegerPair> {
    int _first;
    int _second;

    public IntegerPair(int first, int second) {
      _first = first;
      _second = second;
    }

    public int compareTo(IntegerPair o) {
      if (!this.first().equals(o.first())) {
        return this.first() - o.first();
      } else {
        return this.second() - o.second();
      }
    }

    Integer first() {
      return _first;
    }

    Integer second() {
      return _second;
    }
  }
}
