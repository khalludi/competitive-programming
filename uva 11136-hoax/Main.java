import java.util.*;
import java.io.*;

public class Main {

  static TreeMap<Integer, Integer> map = new TreeMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringTokenizer st;
    Integer N = Integer.parseInt(br.readLine());
    while (N != 0) {
      map.clear();
      long cost = 0;

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        Integer lines = Integer.parseInt(st.nextToken());
        Integer num;
        while (lines > 0) {
          num = Integer.parseInt(st.nextToken());
          map.put(num, map.getOrDefault(num, 0) + 1);
          lines--;
        }

        int highest = map.lastKey();
        if (map.get(highest) == 1)
          map.remove(highest);
        else
          map.put(highest, map.get(highest) - 1);

        int lowest = map.firstKey();
        if (map.get(lowest) == 1)
          map.remove(lowest);
        else
          map.put(lowest, map.get(lowest) - 1);

        cost += (highest - lowest);
      }

      pw.printf("%d\n", cost);
      N = Integer.parseInt(br.readLine());
    }

    pw.close();
  }
}