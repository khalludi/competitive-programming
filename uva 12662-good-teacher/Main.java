import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = Integer.valueOf(br.readLine());
        
        String[] students = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = st.nextToken();
        }

        int Q = Integer.valueOf(br.readLine());
        for (int i = 0; i < Q; i++) {
            int idx = Integer.valueOf(br.readLine()) - 1;

            if (students[idx].charAt(0) != '?') {
                pw.println(students[idx]);
            } else {
                int leftIdx = idx;
                int rightIdx = idx;
                boolean left = false, right = false;
                int iters = 0;
                while (true) {
                    if (leftIdx > 0) { leftIdx--; }
                    if (rightIdx < N - 1) { rightIdx++; }
                    iters++;
                    
                    left = students[leftIdx].charAt(0) != '?';
                    right = students[rightIdx].charAt(0) != '?';

                    if (left || right) { break; }
                }
                
                if (left && right) {
                    pw.printf("middle of %s and %s\n", students[leftIdx], students[rightIdx]);
                } else if (left) {
                    StringBuilder sb = new StringBuilder();
                    while (iters > 0) {
                        sb.append("right of ");

                        iters--;
                    }
                    sb.append(students[leftIdx]);
                    pw.printf("%s\n", sb.toString());
                } else if (right) {
                    StringBuilder sb = new StringBuilder();
                    while (iters > 0) {
                        sb.append("left of ");

                        iters--;
                    }
                    sb.append(students[rightIdx]);
                    pw.printf("%s\n", sb.toString());
                }
            }
        }

        pw.close();
        br.close();
    }
}