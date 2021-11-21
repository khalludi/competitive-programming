import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line;
        while ((line = br.readLine()) != null) {

            int N = Integer.valueOf(line);
            if (N == 0) { break; }
            
            String[] ret = new String[N];
            int currIdx = 0;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String card = st.nextToken();
                String spelling = st.nextToken();

                int spellIdx = 0;
                while (spellIdx != spelling.length() - 1) {
                    if (ret[currIdx % N] == null) {
                        spellIdx++;
                    }
                    currIdx++;
                }

                while (ret[currIdx % N] != null) {
                    currIdx++;
                }

                ret[currIdx % N] = card;
            }

            for (int i = 0; i < N - 1; i++) {
                pw.printf("%s ", ret[i]);
            }
            pw.printf("%s\n", ret[N-1]);

        }

        pw.close();
        br.close();
    }
}