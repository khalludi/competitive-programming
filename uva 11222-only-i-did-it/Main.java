// The problem statement is incorrect. There is an extra line before every testcase. >:(

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("in2.txt"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = Integer.valueOf(br.readLine());
        TreeSet<Integer> problems = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            br.readLine();
            boolean[] a = new boolean[10001];
            boolean[] b = new boolean[10001];
            boolean[] c = new boolean[10001];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.valueOf(st.nextToken());
            for (int j = 0; j < M; j++) {
                int problem = Integer.valueOf(st.nextToken());
                problems.add(problem);
                a[problem] = true;
            }

            st = new StringTokenizer(br.readLine());
            M = Integer.valueOf(st.nextToken());
            for (int j = 0; j < M; j++) {
                int problem = Integer.valueOf(st.nextToken());
                problems.add(problem);
                b[problem] = true;
            }

            st = new StringTokenizer(br.readLine());
            M = Integer.valueOf(st.nextToken());
            for (int j = 0; j < M; j++) {
                int problem = Integer.valueOf(st.nextToken());
                problems.add(problem);
                c[problem] = true;
            }

            pw.printf("Case #%d:\n", i+1);
            int tot_a = 0;
            int tot_b = 0;
            int tot_c = 0;
            for (int problem : problems) {
                if (a[problem] && !b[problem] && !c[problem])
                    tot_a++;
                else if (!a[problem] && b[problem] && !c[problem])
                    tot_b++;
                else if (!a[problem] && !b[problem] && c[problem])
                    tot_c++;
            }

            if (tot_a == tot_b && tot_b == tot_c) {
                StringBuilder sb = new StringBuilder("1 ");
                sb.append(tot_a);
                sb.append(" ");
                for (int problem : problems) {
                    if (a[problem] && !b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n2 ");
                sb.append(tot_b);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n3 ");
                sb.append(tot_c);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && !b[problem] && c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                pw.printf("%s\n", sb.toString());
            } else if (tot_a == tot_b && tot_a > tot_c) {
                StringBuilder sb = new StringBuilder("1 ");
                sb.append(tot_a);
                sb.append(" ");
                for (int problem : problems) {
                    if (a[problem] && !b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n2 ");
                sb.append(tot_b);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                pw.printf("%s\n", sb.toString());
            } else if (tot_b == tot_c && tot_b > tot_a) {
                StringBuilder sb = new StringBuilder("2 ");
                sb.append(tot_b);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n3 ");
                sb.append(tot_c);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && !b[problem] && c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                pw.printf("%s\n", sb.toString());
            } else if (tot_a == tot_c && tot_a > tot_b) {
                StringBuilder sb = new StringBuilder("1 ");
                sb.append(tot_a);
                sb.append(" ");
                for (int problem : problems) {
                    if (a[problem] && !b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n3 ");
                sb.append(tot_c);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && !b[problem] && c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                pw.printf("%s\n", sb.toString());
            } else if (tot_a >= tot_b && tot_a >= tot_c) {
                StringBuilder sb = new StringBuilder("1 ");
                sb.append(tot_a);
                sb.append(" ");
                for (int problem : problems) {
                    if (a[problem] && !b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                pw.printf("%s\n", sb.toString());
            } else if (tot_b >= tot_a && tot_b >= tot_c) {
                StringBuilder sb = new StringBuilder("2 ");
                sb.append(tot_b);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && b[problem] && !c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                pw.printf("%s\n", sb.toString());
            } else {
                StringBuilder sb = new StringBuilder("3 ");
                sb.append(tot_c);
                sb.append(" ");
                for (int problem : problems) {
                    if (!a[problem] && !b[problem] && c[problem]) {
                        sb.append(problem);
                        sb.append(" ");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                pw.printf("%s\n", sb.toString());
            }

            problems.clear();
        }

        pw.close();
        br.close();
    }
}