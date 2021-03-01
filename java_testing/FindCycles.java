import java.util.*;
import java.io.*;

public class FindCycles {

  private static final int UNVISITED = 0;
  private static final int EXPLORED = 2;
  private static final int VISITED = 1;

  private static ArrayList<ArrayList<IntegerPair>> AL;
  private static ArrayList<Integer> dfs_num;
  private static ArrayList<Integer> dfs_parent;

  private static void cycleCheck(int u) {
    dfs_num.set(u, EXPLORED);
    for (IntegerPair v_w : AL.get(u)) {
      if (dfs_num.get(v_w.first()) == UNVISITED) {
        dfs_parent.set(v_w.first(), u);
        cycleCheck(v_w.first());
      } else if (dfs_num.get(v_w.first()) == EXPLORED) {
        if (v_w.first() == dfs_parent.get(u)) {
          System.out.printf("Bidirectional Edge (%d, %d) - (%d, %d)", u, v_w.first(), v_w.first(), u);
        } else {
          System.out.printf("Back Edge (%d, %d) (Cycle)\n", u, v_w.first());
        }
      } else if (dfs_num.get(v_w.first()) == VISITED) {
        System.out.printf("Forward/Cross Edge (%d, %d)\n", u, v_w.first());
      }
    }
    dfs_num.set(u, VISITED);
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("dir_graph.txt"));

    int V = sc.nextInt();
    AL = new ArrayList<>();
    for (int u = 0; u < V; ++u) {
      AL.add(new ArrayList<>());
      int k = sc.nextInt();
      while (k-- > 0) {
        int v = sc.nextInt(), w = sc.nextInt();
        AL.get(u).add(new IntegerPair(v, w));
      }
    }

    System.out.printf("Graph Edges Property Check\n");
    dfs_num = new ArrayList<>(Collections.nCopies(V, UNVISITED));
    dfs_parent = new ArrayList<>(Collections.nCopies(V, -1));
    for (int u = 0; u < V; ++u) {
      if (dfs_num.get(u) == UNVISITED) {
        cycleCheck(u);
      }
    }
  }

  static class IntegerPair {
    Integer _first;
    Integer _second;

    public IntegerPair(int first, int second) {
      this._first = first;
      this._second = second;
    }

    public int first() {
      return _first;
    }

    public int second() {
      return _second;
    }
  }
}