import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for Bishop.
 */
public class BishopTest {
  public Bishop bishopOne;
  public Bishop bishopTwo;

  /**
   * Tests the canMove() method works (true) moving for bishop moving 'northeast.'
   */
  @org.junit.Test
  public void testCanMoveNE() {
    bishopOne = new Bishop(0, 0, Color.BLACK);
    assertEquals(true, bishopOne.canMove(7, 7));
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal1() {
    bishopOne = new Bishop(-4, 3, Color.BLACK);
  }


  /**
   * Tests the canMove() method works moving for bishop moving 'northwest.'
   */
  @org.junit.Test
  public void testCanMoveNW() {
    bishopOne = new Bishop(2, 5, Color.BLACK);
    assertEquals(true, bishopOne.canMove(3, 6));
  }

  /**
   * Tests the canMove() method works moving for bishop moving 'southeast.'
   */
  @org.junit.Test
  public void testCanMoveSE() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    assertEquals(true, bishopOne.canMove(0, 7));
  }


  /**
   * Tests the canMove() method works moving for bishop moving 'southwest.'
   */
  @org.junit.Test
  public void testCanMoveSW() {
    bishopOne = new Bishop(6, 6, Color.BLACK);
    assertEquals(true, bishopOne.canMove(1, 1));
  }


  /**
   * Tests bishops can kill.'
   */
  @org.junit.Test
  public void testCanKillSE() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    bishopTwo = new Bishop(0, 7, Color.WHITE);
    assertEquals(true, bishopOne.canKill(bishopTwo));
  }

  /**
   * Tests bishops can kill fail. Return false because same color pieces.
   */
  @org.junit.Test
  public void testCanKillSE2() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    bishopTwo = new Bishop(0, 7, Color.BLACK);
    assertEquals(false, bishopOne.canKill(bishopTwo));
  }

  /**
   * Tests the canMove() detects invalid position.
   */
  @org.junit.Test
  public void testCanMoveFalse() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    assertEquals(false, bishopOne.canMove(1, 2));
  }

  /**
   * Tests the canKill() detects invalid capture.
   */
  @org.junit.Test
  public void testCanMoveCaptureFalse() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    bishopTwo = new Bishop(7, 1, Color.BLACK);
    assertEquals(false, bishopOne.canMove(1, 2));
  }

  /**
   * Tests the getColumn().
   */
  @org.junit.Test
  public void testGetColumn() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    assertEquals(0, bishopOne.getColumn());
  }

  /**
   * Tests the getRow().
   */
  @org.junit.Test
  public void testGetRow() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    assertEquals(7, bishopOne.getRow());
  }

  /**
   * Tests the getColor(). Black.
   */
  @org.junit.Test
  public void testGetColorB() {
    bishopOne = new Bishop(7, 0, Color.BLACK);
    assertEquals(Color.BLACK, bishopOne.getColor());
  }

  /**
   * Tests the getColor(). White.
   */
  @org.junit.Test
  public void testGetColorW() {
    bishopOne = new Bishop(7, 0, Color.WHITE);
    assertEquals(Color.WHITE, bishopOne.getColor());
  }
}








