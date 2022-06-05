/**
 * This class represents a FibonacciCounter. It has an integer count value which represents the
 * current position in the Fibonacci Sequence starting at 0 (since java doesn't have unsigned ints
 * exceptions are thrown).
 */
public class FibonacciCounter {
  private int countValue;

  /**
   * Construct a FibonacciCounter object that has the provided countValue.
   *
   * @param countValue the current position in the fibonacci sequence, an integer.
   */
  public FibonacciCounter(int countValue) {
    // throwing the exception in the constructor
    // so i can throw it just once.
    if (countValue < 0) {
      throw new IllegalArgumentException("Fib sequence must start at 0th value or higher");
    } else {
      this.countValue = countValue;
    }
  }


  /**
   * Override the toString method so that an object call returns a string.
   *
   * @return calling object returns the countValue as a string.
   */
  public String toString() {

    return String.format("%d", countValue);
  }


  /**
   * Increases our position in the Fibonacci sequence by one and returns which sequence position is
   * the current.
   *
   * @return the object with an increased countValue of one.
   */
  public FibonacciCounter increment() {

    FibonacciCounter incremented = new FibonacciCounter(this.countValue + 1);
    return incremented;

  }

  /**
   * Decreases our position in the Fibonacci sequence by one and returns which sequence position is
   * the current.
   *
   * @return the object with a decreased countValue of one.
   */
  public FibonacciCounter decrement() {
    // we don't want to decrement to below 0 since doing so
    //would just later lead to an exception being thrown.
    if (countValue == 0) {
      throw new IllegalArgumentException("Fib sequence must start at 0th value or higher");
    } else {
      FibonacciCounter decremented = new FibonacciCounter(this.countValue - 1);
      return decremented;
    }
  }


  /**
   * Returns the current countValue, the current position in the sequence.
   *
   * @return countValue integer.
   */
  public int currentCount() {

    return this.countValue;
  }


  /**
   * Employs Binet's formula to determine the value of the Fibonacci sequence countValue position.
   *
   * @return the value at the current countValue. Math.round is used to ensure the result is an
   *       integer, since using a double for instance would not result in enough decimal places for
   *       the program to realize Binet's formula guarantees an integer.
   */
  public long fib() {
    return Math.round(((1 / Math.sqrt(5)) * (Math.pow((1 + Math.sqrt(5)) / 2, this.countValue))
            - (Math.pow((1 - Math.sqrt(5) / 2), this.countValue))));
  }
}

