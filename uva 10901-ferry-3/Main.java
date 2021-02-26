import java.util.*;
import java.io.*;

public class Main {

  static PriorityQueue<IntegerPair> left = new PriorityQueue<>();
  static PriorityQueue<IntegerPair> right = new PriorityQueue<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int testcases = Integer.parseInt(br.readLine());
    while (testcases > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int ferry_limit = Integer.parseInt(st.nextToken());
      int time_crossing = Integer.parseInt(st.nextToken());
      int lines = Integer.parseInt(st.nextToken());
      int[] end_time = new int[lines];
      for (int i = 0; i < lines; i++) {
        st = new StringTokenizer(br.readLine());
        int val = Integer.parseInt(st.nextToken());
        if (st.nextToken().equals("left")) {
          left.offer(new IntegerPair(val, i));
        } else {
          right.offer(new IntegerPair(val, i));
        }
      }

      boolean isFerryLeft = true;
      int curr_time = 0;
      while (!left.isEmpty() || !right.isEmpty()) {
        int left_car = Integer.MAX_VALUE;
        if (!left.isEmpty()) {
          left_car = left.peek().first();
        }

        int right_car = Integer.MAX_VALUE;
        if (!right.isEmpty()) {
          right_car = right.peek().first();
        }

        int min_time = Math.min(left_car, right_car);
        if (isFerryLeft && left_car <= curr_time) {
          for (int i = 0; i < ferry_limit && !left.isEmpty(); i++) {
            if (left.peek().first() <= curr_time) {
              end_time[left.poll().second()] = curr_time + time_crossing;
            } else {
              break;
            }
          }

          isFerryLeft = false;
          curr_time += time_crossing;
        } else if (!isFerryLeft && right_car <= curr_time) {
          for (int i = 0; i < ferry_limit && !right.isEmpty(); i++) {
            if (right.peek().first() <= curr_time) {
              end_time[right.poll().second()] = curr_time + time_crossing;
            } else {
              break;
            }
          }

          isFerryLeft = true;
          curr_time += time_crossing;
        } else if (min_time <= curr_time) {
          curr_time += time_crossing;
          if (min_time == left_car) {
            for (int i = 0; i < ferry_limit && !left.isEmpty(); i++) {
              if (left.peek().first() <= curr_time) {
                end_time[left.poll().second()] = curr_time + time_crossing;
              } else {
                break;
              }
            }
          } else {
            for (int i = 0; i < ferry_limit && !right.isEmpty(); i++) {
              if (right.peek().first() <= curr_time) {
                end_time[right.poll().second()] = curr_time + time_crossing;
              } else {
                break;
              }
            }
          }
          curr_time += time_crossing;
        } else {
          curr_time = Math.min(left_car, right_car);
        }
      }

      for (int i : end_time) {
        pw.printf("%d\n", i);
      }
      if (testcases != 1) {
        pw.println();
      }

      testcases--;
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