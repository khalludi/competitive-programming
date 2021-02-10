import java.util.*;

public class Main {

  static class Pair<T, S> {
    public T left;
    public S right;

    Pair(T left, S right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return String.valueOf(left) + " " + String.valueOf(right);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextLine()) {
      String[] in = sc.nextLine().split(" ");
      int soldiers = Integer.valueOf(in[0]);
      int testcases = Integer.valueOf(in[1]);

      if (soldiers == 0 && testcases == 0) {
        break;
      }

      ArrayList<Pair<Integer, Integer>> intervals = new ArrayList<>();
      intervals.add(new Pair<>(1, soldiers));
      while (testcases > 0) {
        in = sc.nextLine().split(" ");
        int left = Integer.valueOf(in[0]);
        int right = Integer.valueOf(in[1]);

        Pair<Integer, Integer> split_pair1 = null, split_pair2 = null;
        int idxToReplace = -1;
        for (int i = 0; i < intervals.size(); i++) {
          Pair<Integer, Integer> tmp = intervals.get(i);
          if (left >= tmp.left && left < tmp.right) {
            idxToReplace = i;
            if (tmp.left == left) {
              split_pair1 = new Pair<>(right + 1, tmp.right);
              break;
            } else if (tmp.right == right) {
              split_pair1 = new Pair<>(tmp.left, left - 1);
            } else {
              split_pair1 = new Pair<>(tmp.left, left - 1);
              split_pair2 = new Pair<>(right + 1, tmp.right);
            }
            break;
          } else if (left == tmp.left && right == tmp.right) {
            idxToReplace = i;
            break;
          }
        }

        intervals.remove(idxToReplace);
        if (split_pair1 != null)
          intervals.add(idxToReplace, split_pair1);
        if (split_pair2 != null) {
          intervals.add(idxToReplace + 1, split_pair2);
        }

        String leftInt = "";
        for (int j = idxToReplace - 1; j < Math.min(idxToReplace + 3, intervals.size()); j++) {
          if (j < 0) {
            continue;
          }
          if (intervals.get(j).left > left) {
            if (j - 1 < 0) {
              leftInt = "*";
            } else {
              leftInt = Integer.toString(intervals.get(j - 1).right);
            }
            break;
          }
        }
        if (leftInt.equals("")) {
          leftInt = "*";
        }

        String rightInt = "";
        for (int j = idxToReplace - 1; j < Math.min(idxToReplace + 3, intervals.size()); j++) {
          if (j < 0) {
            continue;
          }
          if (intervals.get(j).left > right) {
            rightInt = Integer.toString(intervals.get(j).left);
            break;
          }
        }
        if (rightInt.equals("")) {
          rightInt = "*";
        }

        // System.out.println(idxToReplace);
        System.out.println(intervals);
        if (intervals.isEmpty())
          System.out.println("* *");
        else
          System.out.printf("%s %s\n", leftInt, rightInt);

        testcases--;
      }

      System.out.println("-");
    }
  }
}