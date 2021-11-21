import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line;
        while ((line = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(line);

            int N = Integer.valueOf(st.nextToken());
            boolean[] nums = new boolean[N-1];

            int prev = Integer.valueOf(st.nextToken());
            for (int i = 1; i < N; i++) {
                int tmp = Integer.valueOf(st.nextToken());
                int sum = Math.abs(tmp - prev);
                if (1 <= sum && sum <= N - 1) nums[sum-1] = true;
                prev = tmp;
            }

            boolean valid = true;
            for (boolean x : nums) {
                valid = valid && x;
            }

            if (valid) {
                pw.println("Jolly");
            } else {
                pw.println("Not jolly");
            }
        }

        pw.close();
        br.close();
    }
}