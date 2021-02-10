import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String s;
    while ((s = br.readLine()) != null) {
      LinkedList<Character> value = new LinkedList<>();
      int pointerLocation = 0;
      for (char c : s.toCharArray()) {
        if (c == '[')
          pointerLocation = 0;
        else if (c == ']')
          pointerLocation = value.size();
        else
          value.add(pointerLocation++, c);
      }

      StringBuilder sb = new StringBuilder();
      for (char c : value)
        sb.append(c);
      pw.println(sb.toString());
    }

    pw.close();
  }
}
