import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] hand;

    // Dictionary / Map
    Map<String, Integer> map1 = new HashMap<String, Integer>();
    map1.put("S", 0);
    map1.put("H", 1);
    map1.put("D", 2);
    map1.put("C", 3);

    Map<String, Integer> map2 = new HashMap<String, Integer>();
    map2.put("A", 0);
    map2.put("K", 1);
    map2.put("Q", 2);
    map2.put("J", 3);

    Map<Integer, String> map3 = new HashMap<Integer, String>();
    map3.put(0, "S");
    map3.put(1, "H");
    map3.put(2, "D");
    map3.put(3, "C");

    ArrayList<String> ret = new ArrayList<>();

    while (sc.hasNextLine()) {
      hand = new int[4][5];
      String[] cards = sc.nextLine().split(" ");

      // if (cards[0].charAt(0) == 'z') {
      // break;
      // }

      for (String card : cards) {
        hand[map1.get(card.substring(1))][map2.getOrDefault(card.substring(0, 1), 4)]++;
      }

      // System.out.println(Arrays.deepToString(hand));

      // Count points
      int points = 0;
      int prepoints = 0;

      // Aces
      points += hand[0][0] > 0 ? 4 * hand[0][0] : 0;
      points += hand[1][0] > 0 ? 4 * hand[1][0] : 0;
      points += hand[2][0] > 0 ? 4 * hand[2][0] : 0;
      points += hand[3][0] > 0 ? 4 * hand[3][0] : 0;

      // Kings
      points += hand[0][1] > 0 ? 3 * hand[0][1] : 0;
      points += hand[1][1] > 0 ? 3 * hand[1][1] : 0;
      points += hand[2][1] > 0 ? 3 * hand[2][1] : 0;
      points += hand[3][1] > 0 ? 3 * hand[3][1] : 0;

      // Queen
      points += hand[0][2] > 0 ? 2 * hand[0][2] : 0;
      points += hand[1][2] > 0 ? 2 * hand[1][2] : 0;
      points += hand[2][2] > 0 ? 2 * hand[2][2] : 0;
      points += hand[3][2] > 0 ? 2 * hand[3][2] : 0;

      // Jack
      points += hand[0][3] > 0 ? 1 * hand[0][3] : 0;
      points += hand[1][3] > 0 ? 1 * hand[1][3] : 0;
      points += hand[2][3] > 0 ? 1 * hand[2][3] : 0;
      points += hand[3][3] > 0 ? 1 * hand[3][3] : 0;

      // isStopped
      boolean[] isStopped = new boolean[4];

      // king nothing
      for (int i = 0; i < 4; i++) {
        int other_cards = 0;
        if (hand[i][1] <= 0) {
          continue;
        }
        for (int j = 0; j < 5; j++) {
          if (j == 1) {
            continue;
          }
          other_cards += hand[i][j];
        }

        if (other_cards == 0) {
          points--;
        } else {
          isStopped[i] = true;
        }
      }

      // queen + 0 or 1
      for (int i = 0; i < 4; i++) {
        int other_cards = 0;
        if (hand[i][2] <= 0) {
          continue;
        }
        for (int j = 0; j < 5; j++) {
          if (j == 2) {
            continue;
          }
          other_cards += hand[i][j];
        }

        if (other_cards <= 1) {
          points--;
        } else {
          isStopped[i] = true;
        }
      }

      // Jack + 0 or 1 or 2
      for (int i = 0; i < 4; i++) {
        int other_cards = 0;
        if (hand[i][3] <= 0) {
          continue;
        }
        for (int j = 0; j < 5; j++) {
          if (j == 3) {
            continue;
          }
          other_cards += hand[i][j];
        }

        if (other_cards <= 2) {
          points--;
        }
      }

      prepoints = points;

      // length
      int max_suit = -1;
      int max_idx = -1;
      int[] suits = new int[4];
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 5; j++) {
          suits[i] += hand[i][j];
        }

        if (suits[i] > max_suit) {
          max_suit = suits[i];
          max_idx = i;
        }

        int suit_len = suits[i];
        if (suit_len == 2) {
          points++;
        } else if (suit_len == 1 || suit_len == 0) {
          points += 2;
        }
      }

      // isStopped Ace
      for (int i = 0; i < 4; i++) {
        if (hand[i][0] > 0) {
          isStopped[i] = true;
        }
      }

      boolean stopped = isStopped[0] && isStopped[1] && isStopped[2] && isStopped[3];
      if (stopped && prepoints >= 16) {
        System.out.println("BID NO-TRUMP");
        // ret.add("BID NO-TRUMP");
      } else if (points >= 14) {
        System.out.printf("BID %s\n", map3.get(max_idx));
        // ret.add("BID " + map3.get(max_idx));
      } else {
        System.out.println("PASS");
        // ret.add("PASS");
      }
    }

    // for (String s : ret) {
    // System.out.println(s);
    // }
  }
}