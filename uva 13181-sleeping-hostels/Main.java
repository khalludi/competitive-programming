import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line;
        while ((line = br.readLine()) != null) {

            int max_dist = 0;
            int n = line.length();
            int currIdx = 0;

            while (line.charAt(currIdx) != 'X') {
                currIdx++;
            }

            max_dist = currIdx - 1;
            currIdx++;

            int num_unoccupied = 0;
            while (currIdx < n) {

                if (line.charAt(currIdx) == 'X') {
                    max_dist = Math.max(max_dist, (num_unoccupied - 1) / 2);
                    num_unoccupied = 0;
                } else {
                    num_unoccupied++;
                }

                currIdx++;
            }

            if (line.charAt(n - 1) != 'X') {
                max_dist = Math.max(max_dist, num_unoccupied - 1);
            }

            pw.println(max_dist);
        }

        pw.close();
        br.close();
    }
}