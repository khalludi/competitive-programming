import java.util.*;
import java.io.*;

public class Main2 {

  static HashMap<Integer, Integer> snowflakePosition = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int testcases = Integer.parseInt(br.readLine());
    while (testcases > 0) {
      snowflakePosition.clear();

      int lines = Integer.parseInt(br.readLine());
      Segment[] segmentsByStart = new Segment[lines + 5];
      Segment[] segmentsByEnd = new Segment[lines + 5];

      for (int i = 0; i < lines; i++) {
        int val = Integer.parseInt(br.readLine());
        Integer map_val = snowflakePosition.get(val);
        snowflakePosition.put(val, i);
        if (map_val == null) {
          continue;
        }
        Segment seg = new Segment(map_val, i);
        segmentsByStart[map_val] = seg;
        segmentsByEnd[i] = seg;
      }

      int max_len = 0;
      for (int p = 0; p < lines; p++) {
        Segment s1 = segmentsByStart[p];
        if (s1 == null) {
          s1 = new Segment(p, lines);
        } else {
          segmentsByEnd[s1.second()] = null;
        }
        int len = s1.diff();
        for (int j = p + 1; j < p + len; j++) {
          if (segmentsByEnd[j] != null) {
            len = segmentsByEnd[j].second() - s1.first();
            break;
          }
        }

        max_len = Math.max(max_len, len);
      }

      pw.printf("%d\n", max_len);

      testcases--;
    }

    pw.close();
  }

  static class Segment {
    int _first;
    int _second;

    public Segment(int first, int second) {
      _first = first;
      _second = second;
    }

    public int first() {
      return _first;
    }

    public int second() {
      return _second;
    }

    public int diff() {
      return _second - _first;
    }
  }
}