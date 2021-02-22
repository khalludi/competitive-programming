public class IntegerPair implements Comparable<IntegerPair> {
  int _first;
  int _second;

  public IntegerPair(int first, int second) {
    _first = first;
    _second = second;
  }

  public int compareTo(IntegerPair o) {
    if (!this.first().equals(o.first())) {
      return this.first() - o.first();
    } else {
      return this.second() - o.second();
    }
  }

  Integer first() {
    return _first;
  }

  Integer second() {
    return _second;
  }
}
