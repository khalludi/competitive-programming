import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Stack<Character>> containers = new ArrayList<>();
  static HashSet<Character> unique = new HashSet<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String input = br.readLine();
    int caseno = 1;
    while (!input.equals("end")) {
      int len = input.length();
      containers.clear();
      unique.clear();

      int ans = 0;
      for (int i = 0; i < len; i++) {
        unique.add(input.charAt(i));
        ans += add_to_stack(input, i);
      }

      ans = Math.min(unique.size(), ans);

      pw.printf("Case %d: %d\n", caseno, ans);

      caseno++;
      input = br.readLine();
    }

    pw.close();
  }

  static int add_to_stack(String inp, int i) {
    for (int j = 0; j < containers.size(); j++) {
      if (inp.charAt(i) <= containers.get(j).peek()) {
        containers.get(j).push(inp.charAt(i));
        return 0;
      }
    }
    containers.add(new Stack<Character>());
    containers.get(containers.size() - 1).push(inp.charAt(i));

    return 1;
  }
}