import java.util.*;

public class TokenTest {
  public static void main(String[] args) {
    String str = "This is-a*test";
    StringTokenizer st = new StringTokenizer(str);

    System.out.println(st.nextToken());
    System.out.println(st.nextToken("-").substring(1));
    System.out.println(st.nextToken("*"));
    System.out.println(3 / 2);
  }
}
