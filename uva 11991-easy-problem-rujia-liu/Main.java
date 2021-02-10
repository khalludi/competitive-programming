import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String tmp = br.readLine();
    while (tmp != null) {
      ArrayList<Integer> adjList[] = new ArrayList[1000005];
      for (int i = 0; i < 1000000; i++) {
        adjList[i] = new ArrayList<>();
      }

      StringTokenizer st = new StringTokenizer(tmp);
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        adjList[Integer.parseInt(st.nextToken())].add(i);
      }

      int k;
      int v;
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        if (adjList[v].size() < k)
          pw.println(0);
        else
          pw.println(adjList[v].get(k - 1));
      }

      tmp = br.readLine();
    }

    pw.close();
  }
}