// package uva 01237;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class Main {
  private static class Pair<T, S> {
    public T left;
    public S right;

    public Pair(T left, S right) {
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Query Answers
    ArrayList<String> ret = new ArrayList<>();

    int testCases = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < testCases; i++) {
      // Database
      HashMap<String, Pair<Integer, Integer>> map = new HashMap<>();

      // Build map
      int dbSize = Integer.parseInt(sc.nextLine());
      int randNum = 0;
      for (int j = 0; j < dbSize; j++) {
        String[] line = sc.nextLine().split(" ");
        if (!map.containsKey(line[0]))
          map.put(line[0], new Pair<Integer, Integer>(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
        else {
          map.put(line[0] + "-" + String.valueOf(randNum),
              new Pair<Integer, Integer>(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
          randNum++;
        }
      }

      // Go thru Querys
      int querySize = Integer.parseInt(sc.nextLine());
      for (int j = 0; j < querySize; j++) {
        int numFound = 0;
        String foundKey = "";
        int price = Integer.parseInt(sc.nextLine());
        for (String key : map.keySet()) {
          Pair<Integer, Integer> pair = map.get(key);
          if (pair.left <= price && price <= pair.right) {
            if (numFound == 1) {
              numFound++;
              break;
            } else {
              numFound++;
              foundKey = key;
            }
          }
        }

        if (numFound == 0 || numFound == 2) {
          ret.add("UNDETERMINED");
        } else {
          ret.add(foundKey);
        }
      }

      ret.add("123");
    }

    int idx = 0;
    for (String str : ret) {
      if (str.equals("123")) {
        if (idx != ret.size() - 1)
          System.out.println();
      } else if (str.contains("-")) {
        System.out.println(str.substring(0, str.indexOf('-')));
      } else {
        System.out.println(str);
      }
      idx++;
    }
  }
}
