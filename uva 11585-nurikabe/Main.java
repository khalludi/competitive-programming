import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {

    static int[] cardinal_dx = {0, 0, 1, -1};
    static int[] cardinal_dy = {1, -1, 0, 0};
    static int[] all_dx = {0,1,1, 1, 0,-1,-1,-1};
    static int[] all_dy = {1,1,0,-1,-1,-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int testcases = Integer.parseInt(br.readLine());
        while (testcases > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            String[][] matrix = new String[r][c];
            int[][] nums = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    nums[i][j] = -1;
                }
            }

            boolean skip = false;
            BigInteger cmp = new BigInteger("10000");
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int rtmp = Integer.parseInt(st.nextToken());
                int ctmp = Integer.parseInt(st.nextToken());
                BigInteger val = new BigInteger(st.nextToken());
                if (val.compareTo(cmp) == 1) {
                    skip = true;
                    continue;
                }
                nums[rtmp][ctmp] = val.intValue();
            }

            for (int i = 0; i < r; i++) {
                matrix[i] = br.readLine().split("");
            }

            if (skip) {
                pw.printf("not solved\n");
                testcases--;
                continue;
            }

            // All # should be connected
            boolean ret = true;
            boolean done = false;
            for (int i = 0; i < r && ret; i++) {
                for (int j = 0; j < c; j++) {
                    if (!done && matrix[i][j].equals("#")) {
                        flood_fill(i, j, matrix);
                        done = true;
                        break;
                    }

                    if (done && matrix[i][j].equals("#")) {
                        ret = false;
                        break;
                    }
                }
            }

            if (!ret) {
                pw.printf("not solved\n");
                testcases--;
                continue;
            }

            // Condition 2
            int total_nums = d;
            for (int i = 0; i < r && ret; i++) {
                for (int j = 0; j < c; j++) {
                    if (nums[i][j] != -1 && matrix[i][j].equals(".")) {
                        total_nums--;
                        int num_whit = flood_fill2(i, j, matrix, 0);
                        if (num_whit != nums[i][j]) {
                            ret = false;
                            break;
                        }
                    }
                }
            }
            if (total_nums != 0) {
                ret = false;
            }

            if (!ret) {
                pw.printf("not solved\n");
                testcases--;
                continue;
            }

            // Condition 3
            for (int i = 0; i < r && ret; i++) {
                for (int j = 0; j < c; j++) {
                    if (matrix[i][j].equals(".")) {
                        ret = false;
                        break;
                    }
                    if (matrix[i][j].equals("!")) {
                        ret = ret && flood_fill3(i, j, matrix, false);
                    }
                }
            }

            // System.out.printf(ret ? "true\n" : "false\n");

            if (!ret) {
                pw.printf("not solved\n");
                testcases--;
                continue;
            }

            // Condition 4
            for (int i = 0; i < r-1 && ret; i++) {
                for (int j = 0; j < c-1; j++) {
                    if (!(matrix[i][j].equals("*") || 
                        matrix[i+1][j].equals("*") ||
                        matrix[i][j+1].equals("*") ||
                        matrix[i+1][j+1].equals("*"))) {

                        ret = false;
                        break;
                    }
                }
            }

            // System.out.printf(ret ? "true\n" : "false\n");

            if (!ret) {
                pw.printf("not solved\n");
            } else {
                pw.printf("solved\n");
            }

            testcases--;
        }

        pw.close();
    }

    // flip # to @
    static void flood_fill(int r, int c, String[][] matrix) {
        if (r < 0 || r >= matrix.length) {}
        else if (c < 0 || c >= matrix[0].length) {}
        else if (matrix[r][c].equals("#")) {
            matrix[r][c] = "@";
            for (int i = 0; i < 4; i++) {
                flood_fill(r+cardinal_dx[i], c+cardinal_dy[i], matrix);
            }
        }
    }

    // return number of whitespaces
    static int flood_fill2(int r, int c, String[][] matrix, int num_whitespace) {
        if (r < 0 || r >= matrix.length) { return num_whitespace; }
        else if (c < 0 || c >= matrix[0].length) { return num_whitespace; }
        else if (matrix[r][c].equals(".")) {
            matrix[r][c] = "!";
            num_whitespace += 1;
            for (int i = 0; i < 4; i++) {
                num_whitespace = flood_fill2(r+cardinal_dx[i], c+cardinal_dy[i], matrix, num_whitespace);
            }
        }

        return num_whitespace;
    }

    // return if connected to edge
    static boolean flood_fill3(int r, int c, String[][] matrix, boolean edgeFound) {
        if (r < 0 || r >= matrix.length) {return edgeFound;}
        else if (c < 0 || c >= matrix[0].length) {return edgeFound;}
        else if (matrix[r][c].equals("!")) {
            // System.out.printf("   (%d, %d); matrix = (%d,%d)\n", r, c, matrix.length, matrix[0].length);
            if (r == 0 || c == 0 || r == matrix.length - 1 || c == matrix[0].length - 1) {
                edgeFound = true;
            }
            // System.out.println(edgeFound);
            matrix[r][c] = "*";
            for (int i = 0; i < 8; i++) {
                edgeFound = flood_fill3(r+all_dx[i], c+all_dy[i], matrix, edgeFound);
            }
        }
        return edgeFound;
    }
}