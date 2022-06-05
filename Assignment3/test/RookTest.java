import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for Rook.
 */
public class RookTest {
  public Rook rookOne;
  public Rook rookTwo;

  /**
   * Tests the getColumn().
   */
  @org.junit.Test
  public void testGetColumn() {
    rookOne = new Rook(7, 0, Color.BLACK);
    assertEquals(0, rookOne.getColumn());
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal1() {
    rookOne = new Rook(4, 12, Color.BLACK);
  }

  /**
   * Tests the getRow().
   */
  @org.junit.Test
  public void testGetRow() {
    rookOne = new Rook(7, 0, Color.BLACK);
    assertEquals(7, rookOne.getRow());
  }

  /**
   * Tests the getColor(). Black.
   */
  @org.junit.Test
  public void testGetColorB() {
    rookOne = new Rook(7, 0, Color.BLACK);
    assertEquals(Color.BLACK, rookOne.getColor());
  }

  /**
   * Tests the getColor(). White.
   */
  @org.junit.Test
  public void testGetColorW() {
    rookOne = new Rook(7, 0, Color.WHITE);
    assertEquals(Color.WHITE, rookOne.getColor());
  }

  @org.junit.Test
  public void testCanMove1() {
    rookOne = new Rook(3, 3, Color.BLACK);
    assertEquals(true, rookOne.canMove(3, 0));
  }

  @org.junit.Test
  public void testCanMove2() {
    rookOne = new Rook(3, 3, Color.BLACK);
    assertEquals(true, rookOne.canMove(3, 7));
  }


  @org.junit.Test
  public void testCanMove3() {
    rookOne = new Rook(3, 3, Color.BLACK);
    assertEquals(true, rookOne.canMove(0, 3));
  }


  @org.junit.Test
  public void testCanMove4() {
    rookOne = new Rook(3, 3, Color.BLACK);
    assertEquals(false, rookOne.canMove(-5, 10));
  }

  /**
   * Testing if rook can move to diagonal square. should be false.
   */
  @org.junit.Test
  public void testCanMove5() {
    rookOne = new Rook(3, 3, Color.BLACK);
    assertEquals(false, rookOne.canMove(0, 6));
  }

  /**
   * Testing if rook can capture vertically.
   */
  @org.junit.Test
  public void testCanMove6() {
    rookOne = new Rook(3, 3, Color.BLACK);
    assertEquals(true, rookOne.canMove(3, 6));
  }


  /**
   * Testing if rook can capture horizontally from furthest point to furthest point. up vertially
   */
  @org.junit.Test
  public void testCanMove8() {
    rookOne = new Rook(0, 0, Color.BLACK);
    assertEquals(true, rookOne.canMove(0, 7));
  }

  /**
   * Testing if rook can kill horizontally from furthest point to furthest point. up vertially
   */
  @org.junit.Test
  public void testCanKill() {
    rookOne = new Rook(0, 0, Color.WHITE);
    rookTwo = new Rook(0, 7, Color.BLACK);

    assertEquals(true, rookOne.canMove(0, 7));
  }


}

