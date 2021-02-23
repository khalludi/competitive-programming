import java.util.*;
import java.io.*;

public class Example {
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
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // PrintWriter pw = new PrintWriter(new BufferedWriter(new
    // OutputStreamWriter(System.out)));

    // pw.close();

    File f = new File("mst_in.txt");
    Scanner sc = new Scanner(f);

    int V = sc.nextInt(), E = sc.nextInt();
    AL.clear();
    for (int i = 0; i < V; ++i) {
      ArrayList<IntegerPair> Neighbor = new ArrayList<>();
      AL.add(Neighbor);
    }

    for (int i = 0; i < E; ++i) {
      int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
      AL.get(u).add(new IntegerPair(v, w));
      AL.get(v).add(new IntegerPair(u, w));
    }

    int mst_cost = 0, num_taken = 0;
    for (int i = 0; i < V; ++i) {
      taken.add(false);
    }
    process(0);
    while (!pq.isEmpty()) {
      IntegerPair front = pq.poll();
      int u = front.second(), w = front.first();
      if (taken.get(u))
        continue;
      mst_cost += w;
      process(u);
      ++num_taken;
      if (num_taken == V - 1)
        break;
    }
    System.out.printf("MST cost = %d (Prim's)\n", mst_cost);
    sc.close();
  }
}