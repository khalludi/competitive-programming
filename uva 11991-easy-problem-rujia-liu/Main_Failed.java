import java.io.*;
import java.util.*;

public class Main_Failed {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    String tmp = br.readLine();
    while (tmp != null) {
      StringTokenizer st = new StringTokenizer(tmp);
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      String tok;
      for (int i = 1; i <= n; i++) {
        tok = st.nextToken();
        if (!map.containsKey(tok))
          map.put(tok, new ArrayList<Integer>());
        map.get(tok).add(i);
      }

      int k;
      String v;
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        v = st.nextToken();

        if (!map.containsKey(v)) {
          pw.println(0);
        }

        boolean found = false;
        int idx = 1;
        ArrayList<Integer> arr = map.get(v);
        for (int x : arr) {
          if (idx == k) {
            pw.println(x);
            found = true;
          }
          idx++;
        }

        if (!found) {
          pw.println(0);
        }
      }

      tmp = br.readLine();
    }

    pw.close();
  }
}