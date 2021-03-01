import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());
    while (r != 0 || c != 0 || start != 0) {
      char[][] grid = new char[r][c];
      for (int i = 0; i < r; i++) {
        grid[i] = br.readLine().toCharArray();
      }

      ArrayList<ArrayList<IntegerTrip>> step_grid = new ArrayList<>(Collections.nCopies(r, new ArrayList<>()));

      IntegerTrip curr = new IntegerTrip(0, start - 1, 0);
      int fin_step = 0, loop_step = -1;
      while (true) {
        if (curr.r < 0 || curr.r >= r || curr.c < 0 || curr.c >= c) {
          fin_step = curr.step;
          break;
        }

        boolean found = false;
        for (IntegerTrip tmp : step_grid.get(curr.r)) {
          if (tmp.r == curr.r && tmp.c == curr.c) {
            fin_step = tmp.step;
            loop_step = curr.step - tmp.step;
            found = true;
            break;
          }
        }
        if (found)
          break;

        step_grid.get(curr.r).add(new IntegerTrip(curr.r, curr.c, curr.step));

        char dir = grid[curr.r][curr.c];
        if (dir == 'N') {
          curr.r -= 1;
        } else if (dir == 'S') {
          curr.r += 1;
        } else if (dir == 'W') {
          curr.c -= 1;
        } else if (dir == 'E') {
          curr.c += 1;
        }
        curr.step += 1;
      }

      if (loop_step == -1) {
        pw.printf("%d step(s) to exit\n", fin_step);
      } else {
        pw.printf("%d step(s) before a loop of %d step(s)\n", fin_step, loop_step);
      }

      st = new StringTokenizer(br.readLine());
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      start = Integer.parseInt(st.nextToken());
    }
    pw.close();
  }

  static class IntegerTrip {
    public int r;
    public int c;
    public int step;

    public IntegerTrip(int r, int c, int step) {
      this.r = r;
      this.c = c;
      this.step = step;
    }

    public String toString() {
      return r + " " + c + " " + step;
    }
  }
}