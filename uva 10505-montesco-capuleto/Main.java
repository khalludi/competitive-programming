import java.util.*;
import java.io.*;

public class Main {
  private static ArrayList<ArrayList<Integer>> AL;

  static boolean has(ArrayList<Integer> v, int e) {
    for (int i = 0; i < v.size(); i++) {
      if (v.get(i) == e)
        return true;
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int V, E, v, tc;
    StringTokenizer st;
    tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      br.readLine();
      V = Integer.parseInt(br.readLine());
      AL = new ArrayList<>();
      for (int i = 0; i < V; i++) {
        AL.add(new ArrayList<>());
      }

      for (int u = 0; u < V; u++) {
        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        for (int j = 0; j < E; j++) {
          v = Integer.parseInt(st.nextToken());
          v--;
          if (v < V) {
            if (!has(AL.get(u), v)) {
              AL.get(u).add(v);
            }
            if (!has(AL.get(v), u)) {
              AL.get(v).add(u);
            }
          }
        }
      }

      System.out.println(AL);

      int[] color = new int[V];
      Arrays.fill(color, 1 << 9);
      boolean isBipartite;
      int ans = 0;

      for (int s = 0; s < V; s++) {
        if (color[s] != 1 << 9) {
          continue;
        }

        isBipartite = true;
        int colorCount[] = { 0, 0 };
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(s);
        color[s] = 0;
        colorCount[0]++;

        while (!q.isEmpty()) {
          int u = q.peek();
          q.poll();
          for (int j = 0; j < AL.get(u).size(); j++) {
            v = AL.get(u).get(j);
            if (color[v] == 1 << 9) {
              color[v] = 1 - color[u];
              colorCount[color[v]]++;
              q.offer(v);
            } else if (color[v] == color[u]) {
              isBipartite = false;
            }
            System.out.printf("color[%d] = %d; color[%d] = %d; colorCount = {%d, %d}; isBipartite = %d\n", u, color[u],
                v, color[v], colorCount[0], colorCount[1], isBipartite ? 1 : 0);
          }
        }

        if (isBipartite)
          ans += Math.max(colorCount[0], colorCount[1]);
      }

      pw.printf("%d\n", ans);
    }

    br.close();
    pw.close();
  }
}