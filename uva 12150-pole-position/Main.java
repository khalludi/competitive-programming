import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line;
        while ((line = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(line);

            boolean works = true;
            int N = Integer.valueOf(st.nextToken());
            if (N == 0) { break; }

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int car = Integer.valueOf(st.nextToken());
                int val = Integer.valueOf(st.nextToken());
                int pos = i + val;
                // System.out.printf("(c = %d, val = %d, pos = %d, arr[pos] = %d)\n", car, val, pos, arr[pos]);

                if (pos < 0 || pos >= N || arr[pos] != 0) {
                    works = false;
                    continue;
                } else {
                    arr[pos] = car;
                }
            }

            // System.out.println(Arrays.toString(arr));

            if (!works) {
                pw.printf("-1\n");
            } else {
                for (int i = 0; i < arr.length - 1; i++) {
                    pw.printf("%d ", arr[i]);
                }
                pw.printf("%d\n", arr[arr.length - 1]);
            }
        }

        pw.close();
        br.close();
    }
}