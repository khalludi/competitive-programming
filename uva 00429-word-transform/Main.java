import java.util.*;
import java.io.*;

public class Main {

  public static boolean valid(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;

    int diffCount = 0;
    for (int i = 0; i < s1.length(); i++)
      if (s1.charAt(i) != s2.charAt(i))
        diffCount++;

    return diffCount == 1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringTokenizer st;
    int testcases = Integer.parseInt(br.readLine());
    boolean first = true;
    while (testcases-- > 0) {
      if (first)
        br.readLine();

      ArrayList<String> dictionary = new ArrayList<>();

      String input = br.readLine();
      while (!input.equals("*")) {
        dictionary.add(input);
        input = br.readLine();
      }

      // System.out.println(dictionary);

      HashMap<String, ArrayList<String>> adjList = new HashMap<>();
      for (String s1 : dictionary) {
        for (String s2 : dictionary) {
          if (valid(s1, s2)) {
            if (!adjList.containsKey(s1))
              adjList.put(s1, new ArrayList<>());
            adjList.get(s1).add(s2);

            if (!adjList.containsKey(s2))
              adjList.put(s2, new ArrayList<>());
            adjList.get(s2).add(s1);
          }
        }
      }

      if (first) {
        first = false;
      } else {
        pw.println();
      }
      String query;
      while ((query = br.readLine()) != null && !query.isEmpty()) {
        st = new StringTokenizer(query);
        String src = st.nextToken();
        String dest = st.nextToken();

        HashSet<String> visited = new HashSet<>();
        visited.add(src);

        LinkedList<TraverseData> queue = new LinkedList<>();
        queue.add(new TraverseData(src, 0));

        int ans = -1;
        while (!queue.isEmpty()) {
          TraverseData dat = queue.removeFirst();

          if (dat.word.equals(dest)) {
            ans = dat.depth;
            break;
          } else if (adjList.containsKey(dat.word)) {
            for (String neighbor : adjList.get(dat.word)) {
              if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.addLast(new TraverseData(neighbor, dat.depth + 1));
              }
            }
          }
        }

        pw.printf("%s %s %d\n", src, dest, ans);
      }
    }

    br.close();
    pw.close();
  }

  public static class TraverseData {
    String word;
    int depth;

    public TraverseData(String w, int d) {
      this.word = w;
      this.depth = d;
    }
  }
}