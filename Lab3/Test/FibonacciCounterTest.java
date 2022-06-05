import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for FibonacciCounter.
 */
public class FibonacciCounterTest {
  // three separate test objects
  private FibonacciCounter fibOne;
  private FibonacciCounter fibTwo;
  private FibonacciCounter fibThree;

  @Before
  public void setUp() {
    // creates an instance that represents the first test object
    fibOne = new FibonacciCounter(1);
    // creates an instance that represents the second test object
    fibTwo = new FibonacciCounter(7);

  }

  /**
   * Tests CurrentCount(). Ensures the method returns expected current count
   */
  @Test
  public void testCurrentCount() {
    assertEquals(1, fibOne.currentCount());
    assertEquals(7, fibTwo.currentCount());
  }

  /**
   * Tests Increment(). Ensures FibonacciCounter object method Increment() increments by one and
   * then returns the object with an incremented current count. toString() is used to obtain the
   * string representation of the object.
   */
  @Test
  public void testIncrement() {
    assertEquals("2", fibOne.increment().toString());
    assertEquals("8", fibTwo.increment().toString());
  }

  /**
   * Tests Decrement(). Ensures FibonacciCounter object method Decrement() decrements by one and
   * then returns the object with an decremented current count. toString() is used to obtain the
   * string representation of the object.
   */
  @Test
  public void testDecrement() {
    assertEquals("0", fibOne.decrement().toString());
    assertEquals("6", fibTwo.decrement().toString());
  }


  /**
   * Tests Fib(). Ensures Fib correctly calculates the value at countValue
   */
  @Test
  public void testFib() {
    assertEquals(13, fibTwo.fib());
  }



  /**
   * Tests Increment(). and then Fib(). The point of this test is to ensure that fib is correctly
   * performed on an object after that object has undergone the increment method.
   */
  @Test
  public void testIncrementThenFib() {
    // now count value should be 3 if incremented twice.
    assertEquals(3, fibOne.increment().increment().currentCount());
    // after being incremented twice to 3, the fib() should be 2.
    assertEquals(2, fibOne.increment().increment().fib());

  }

  /**
   * Tests that an IllegalArgumentException is thrown when a FibonacciCounter object is created with
   * a negative countValue.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFibFail() {
    fibThree = new FibonacciCounter(-3);

  }

  /**
   * Tests Fib() to ensure IllegalArgumentException is thrown when the number at
   * countvalue position is too big (more than MAXVALUE of integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFibFail2()
  {      fibOne = new FibonacciCounter(47);
         fibOne.fib();
  }

  /**
   * 46 count value should be less than MAX_value int.
   */
  @Test
  public void testFibPass()
  {      fibOne = new FibonacciCounter(46);
    fibOne.fib();
  }

  /**
   * Tests that fib can be used if there is a countvalue of 0.
   */
  @Test
  public void testFib2() {
    fibTwo = new FibonacciCounter(0);
    fibTwo.fib();
  }


  /**
   * Tests that an IllegalArgumentException is NOT thrown when a FibonacciCounter object is created
   * with a countvalue of exactly 0
   */
  @Test
  public void testDecrementFail() {
    // this specifically tests a count of 0 (which is allowed as an initial countValue)
    // being decreased by decrement().
    fibThree = new FibonacciCounter(1);
  }

  /**
   * Tests that an IllegalArgumentException is thrown when a FibonacciCounter object is created with
   * a countvalue at or above 0 that decrements lower than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDecrementFail2() {
    // this specifically tests a count of 0 (which is allowed as an initial countValue)
    // being decreased by decrement().
    fibThree = new FibonacciCounter(0);
    fibThree.decrement();
  }
}