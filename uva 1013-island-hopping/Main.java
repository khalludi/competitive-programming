import java.util.*;
import java.io.*;

public class Main {

  static ArrayList<ArrayList<IntegerTrip>> AL = new ArrayList<>();
  static ArrayList<Boolean> taken = new ArrayList<>();
  static PriorityQueue<IntegerTrip> pq = new PriorityQueue<>();

  static void process(int u) {
    taken.set(u, true);
    for (IntegerTrip v_w : AL.get(u)) {
      if (!taken.get((int) v_w.first())) {
        pq.offer(new IntegerTrip(v_w.second(), v_w.first(), v_w.pop()));
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringTokenizer st;
    int group = 1;
    int testcases = Integer.parseInt(br.readLine());
    while (testcases != 0) {
      AL.clear();
      taken.clear();
      pq.clear();

      int tot_pop = 0;
      ArrayList<IntegerTrip> islandArr = new ArrayList<>();
      for (int i = 0; i < testcases; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int pop = Integer.parseInt(st.nextToken());
        tot_pop += pop;
        islandArr.add(new IntegerTrip(x, y, pop));
      }

      for (int i = 0; i < testcases; i++) {
        ArrayList<IntegerTrip> neighbors = new ArrayList<>();
        for (int j = 0; j < testcases; j++) {
          if (i == j) {
            continue;
          }

          int x_diff = islandArr.get(i).first() - islandArr.get(j).first();
          int y_diff = islandArr.get(i).second() - islandArr.get(j).second();
          int weight = x_diff * x_diff + y_diff * y_diff;
          neighbors.add(new IntegerTrip(j, weight, islandArr.get(j).pop()));
        }
        AL.add(neighbors);
      }

      for (int i = 0; i < testcases; i++) {
        taken.add(false);
      }

      double mst_cost = 0.0;
      int num_taken = 0;
      process(0);
      while (!pq.isEmpty()) {
        IntegerTrip front = pq.poll();
        int w = front.first();
        int u = front.second();
        double pop = front.pop();
        if (taken.get(u))
          continue;
        mst_cost += Math.sqrt(w) * pop;
        process(u);
        ++num_taken;
        if (num_taken == testcases - 1)
          break;
      }

      if (group != 1) {
        pw.println();
      }
      pw.printf("Island Group: %d  Average %.2f\n", group, mst_cost / tot_pop);

      group++;
      testcases = Integer.parseInt(br.readLine());
    }
    pw.close();
  }

  static class IntegerTrip implements Comparable<IntegerTrip> {
    int x, y;
    double pop;

    public IntegerTrip(int x, int y, double pop) {
      this.x = x;
      this.y = y;
      this.pop = pop;
    }

    public int compareTo(IntegerTrip o) {
      if (!this.first().equals(o.first())) {
        return this.first() - o.first();
      } else {
        return this.second() - o.second();
      }
    }

    public Integer first() {
      return x;
    }

    public Integer second() {
      return y;
    }

    public double pop() {
      return pop;
    }
  }
  /*
   * static class IntegerPair implements Comparable<IntegerPair> { int x, y;
   * 
   * public IntegerPair(int x, int y) { this.x = x; this.y = y; }
   * 
   * public int compareTo(IntegerPair o) { if (this.first() != o.first()) { return
   * this.first() - o.first(); } else { return this.second() - o.second(); } }
   * 
   * public int first() { return x; }
   * 
   * public int second() { return y; } }
   * 
   * static class DubPair implements Comparable<DubPair> { double x; double y;
   * 
   * public DubPair(double x, double y) { this.x = x; this.y = y; }
   * 
   * public int compareTo(DubPair o) { if (Math.abs(this.first() - o.first()) >
   * 0.00001) { return (int) Math.ceil(this.first() - o.first()); } else { return
   * (int) Math.ceil(this.second() - o.second()); } }
   * 
   * public double first() { return x; }
   * 
   * public double second() { return y; } }
   * 
   * static class DubTrip implements Comparable<DubTrip> { double x; double y;
   * double z;
   * 
   * public DubTrip(double x, double y, double z) { this.x = x; this.y = y; this.z
   * = z; }
   * 
   * public int compareTo(DubTrip o) { if (Math.abs(this.first() - o.first()) >
   * 0.00001) { return (int) Math.ceil(this.first() - o.first()); } else { return
   * (int) Math.ceil(this.second() - o.second()); } }
   * 
   * public double first() { return x; }
   * 
   * public double second() { return y; }
   * 
   * public double pop() { return z; } }
   */
}