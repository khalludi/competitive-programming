import java.util.*;
import java.io.*;

public class MainFailed {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String input = br.readLine();
    StringBuffer sb = new StringBuffer();
    while (input != null) {
      // while (input.length() > 0) {
      char c;
      boolean toEnd = true;
      int startIdx = 0;
      for (int i = 0; i < input.length(); i++) {
        c = input.charAt(i);
        if (c == '[') {
          if (toEnd) {
            sb = sb.append(input.substring(startIdx, i));
          } else {
            sb = sb.insert(0, input.substring(startIdx, i));
          }
          toEnd = false;
          startIdx = i + 1;
        } else if (c == ']') {
          if (toEnd) {
            sb = sb.append(input.substring(startIdx, i));
          } else {
            sb = sb.insert(0, input.substring(startIdx, i));
          }
          toEnd = true;
          startIdx = i + 1;
        } else {
          // if (toEnd) {
          // sb = sb.append(c);
          // } else {
          // beginning = beginning.append(c);
          // }
        }
      }

      if (startIdx < input.length()) {
        if (toEnd) {
          sb = sb.append(input.substring(startIdx, input.length()));
        } else {
          sb = sb.insert(0, input.substring(startIdx, input.length()));
        }
      }

      pw.println(sb.toString());

      input = br.readLine();
    }

    pw.close();
  }
}