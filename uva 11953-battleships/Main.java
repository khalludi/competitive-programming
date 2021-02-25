import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = { 0, 0, 1, -1 };
  static int[] dy = { -1, 1, 0, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int testcases = Integer.valueOf(br.readLine());
    int case_no = 1;
    while (case_no <= testcases) {
      int N = Integer.valueOf(br.readLine());
      String[][] matrix = new String[N][N];

      for (int i = 0; i < N; i++) {
        matrix[i] = br.readLine().split("");
      }

      int alive_ships = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (matrix[i][j].equals("x")) {
            alive_ships += floodfill(i, j, matrix, 1);
          } else if (matrix[i][j].equals("@")) {
            alive_ships += floodfill(i, j, matrix, 0);
          }
        }
      }

      pw.printf("Case %d: %d\n", case_no, alive_ships);

      case_no++;
    }

    pw.close();
  }

  // 0 = dead; 1 = alive
  static int floodfill(int r, int c, String[][] matrix, int found) {
    if (r < 0 || r >= matrix.length)
      return found;
    if (c < 0 || c >= matrix[0].length)
      return found;
    if (matrix[r][c].equals("x")) {
      found = 1;
      matrix[r][c] = ".";
      for (int k = 0; k < 4; k++) {
        found = floodfill(r + dx[k], c + dy[k], matrix, found);
      }
    } else if (matrix[r][c].equals("@")) {
      matrix[r][c] = ".";
      for (int k = 0; k < 4; k++) {
        found = floodfill(r + dx[k], c + dy[k], matrix, found);
      }
    }

    return found;
  }
}