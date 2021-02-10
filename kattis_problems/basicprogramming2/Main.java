import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    Integer int1;
    int[] arr = new int[N];
    Set<Integer> s = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int1 = Integer.parseInt(st.nextToken());
      arr[i] = int1;
      s.add(int1);
    }

    // Sort O(nlogn)

    if (t == 1) {
      Arrays.sort(arr);
      int startIdx = 0;
      int endIdx = N - 1;
      boolean found = false;
      while (startIdx < endIdx) {
        if (arr[startIdx] + arr[endIdx] == 7777) {
          found = true;
          break;
        } else if (arr[startIdx] + arr[endIdx] > 7777) {
          endIdx--;
        } else {
          startIdx++;
        }
      }
      pw.print(found ? "Yes" : "No");
    } else if (t == 2) {
      boolean found = s.size() != N;
      pw.print(found ? "Contains duplicate" : "Unique");
    } else if (t == 3) {
      Arrays.sort(arr);
      int target = (int) Math.ceil(N / 2.0);
      int cnt = 1;
      int val = arr[0];
      boolean found = false;
      for (int i = 1; i < N; i++) {
        if (cnt == target) {
          found = true;
          break;
        } else if (arr[i] == val) {
          cnt++;
        } else {
          val = arr[i];
          cnt = 1;
        }
      }
      pw.print(found ? val : -1);
    } else if (t == 4) {
      Arrays.sort(arr);
      double idx = N / 2.0;
      int idx2 = N / 2;
      if (idx != idx2) {
        pw.print(arr[idx2]);
      } else {
        pw.printf("%d %d", arr[idx2 - 1], arr[idx2]);
      }
    } else if (t == 5) {
      Arrays.sort(arr);
      boolean first = true;
      for (int i = 0; i < N; i++) {
        if (arr[i] >= 100 && arr[i] <= 999) {
          if (first) {
            pw.printf("%d", arr[i]);
            first = false;
          } else
            pw.printf(" %d", arr[i]);
        }
        if (arr[i] >= 1000) {
          break;
        }
      }
    }

    pw.close();
  }
}