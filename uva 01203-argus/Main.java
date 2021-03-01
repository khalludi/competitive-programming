import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    PriorityQueue<IntegerPair> pQueue = new PriorityQueue<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    String inputToken = st.nextToken();
    while (!inputToken.equals("#")) {
      int reg = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      pQueue.offer(new IntegerPair(time, reg));
      st = new StringTokenizer(br.readLine());
      inputToken = st.nextToken();
    }

    int k = Integer.parseInt(br.readLine());
    while (k > 0) {
      IntegerPair tmp = pQueue.poll();
      pw.printf("%d\n", tmp.second());
      tmp.update();
      pQueue.offer(tmp);

      k--;
    }

    pw.close();
  }

  static class IntegerPair implements Comparable<IntegerPair> {
    int base;
    int _first;
    int _second;

    public IntegerPair(int first, int second) {
      _first = first;
      base = first;
      _second = second;
    }

    public int first() {
      return _first;
    }

    public void update() {
      _first += base;
    }

    public int second() {
      return _second;
    }

    public int compareTo(IntegerPair o) {
      if (this.first() == o.first()) {
        return second() - o.second();
      } else {
        return first() - o.first();
      }
    }

  }

}