import java.util.*;
import java.io.*;

public class Main {

  static Stack<Integer> stack = new Stack<>();
  static ArrayDeque<Integer> queue = new ArrayDeque<>();
  static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringTokenizer st;
    String input = br.readLine();
    while (input != null) {
      int n = Integer.parseInt(input);
      boolean[] ret = { true, true, true };
      stack.clear();
      queue.clear();
      priorityQueue.clear();

      while (n > 0) {
        st = new StringTokenizer(br.readLine());
        int check = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());
        if (check == 1) {
          stack.push(val);
          queue.offer(val);
          priorityQueue.offer(val);
        } else {
          if (stack.empty() || stack.pop() != val) {
            ret[0] = false;
          }
          if (queue.isEmpty() || queue.poll() != val) {
            ret[1] = false;
          }
          if (priorityQueue.isEmpty() || priorityQueue.poll() != val) {
            ret[2] = false;
          }
        }
        n--;
      }

      if (ret[0] && !ret[1] && !ret[2]) {
        pw.println("stack");
      } else if (!ret[0] && ret[1] && !ret[2]) {
        pw.println("queue");
      } else if (!ret[0] && !ret[1] && ret[2]) {
        pw.println("priority queue");
      } else if (!ret[0] && !ret[1] && !ret[2]) {
        pw.println("impossible");
      } else {
        pw.println("not sure");
      }

      input = br.readLine();
    }

    pw.close();
  }
}