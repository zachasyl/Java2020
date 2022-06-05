import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for Queen.
 */
public class QueenTest {
  public Queen queenOne;
  public Queen queenTwo;

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSpeedIncreaseFail() {
    queenOne = new Queen(-5, 5, Color.BLACK);
  }

  /**
   * Tests the getColumn().
   */
  @org.junit.Test
  public void testGetColumn() {
    queenOne = new Queen(7, 5, Color.BLACK);
    assertEquals(5, queenOne.getColumn());
  }

  /**
   * Tests the getRow().
   */
  @org.junit.Test
  public void testGetRow() {
    queenOne = new Queen(7, 0, Color.BLACK);
    assertEquals(7, queenOne.getRow());
  }

  /**
   * Tests the getColor(). Black.
   */
  @org.junit.Test
  public void testGetColorB() {
    queenOne = new Queen(7, 0, Color.BLACK);
    assertEquals(Color.BLACK, queenOne.getColor());
  }

  /**
   * Tests the getColor(). White.
   */
  @org.junit.Test
  public void testGetColorW() {
    queenOne = new Queen(7, 0, Color.WHITE);
    assertEquals(Color.WHITE, queenOne.getColor());
  }

  /**
   * Tests the canMove() method works (true) moving for bishop moving 'northeast.'
   */
  @org.junit.Test
  public void testCanMoveNE() {
    queenOne = new Queen(0, 0, Color.BLACK);
    assertEquals(true, queenOne.canMove(7, 7));
  }

  /**
   * Tests the canMove() method works moving for bishop moving 'northwest.'
   */
  @org.junit.Test
  public void testCanMoveNW() {
    queenOne = new Queen(2, 5, Color.BLACK);
    assertEquals(true, queenOne.canMove(3, 6));
  }

  /**
   * Tests the canMove() method works moving for bishop moving 'southeast.'
   */
  @org.junit.Test
  public void testCanMoveSE() {
    queenOne = new Queen(7, 0, Color.BLACK);
    assertEquals(true, queenOne.canMove(0, 7));
  }


  /**
   * Tests the canMove() method works moving for bishop moving 'southwest.'
   */
  @org.junit.Test
  public void testCanMoveSW() {
    queenOne = new Queen(6, 6, Color.BLACK);
    assertEquals(true, queenOne.canMove(1, 1));
  }


  /**
   * Tests Queen can kill in bound queen south east capture.
   */
  @org.junit.Test
  public void testCanKillSE() {
    queenOne = new Queen(7, 0, Color.BLACK);
    queenTwo = new Queen(0, 7, Color.WHITE);
    assertEquals(true, queenOne.canKill(queenTwo));
  }

  /**
   * Tests Queen can kill in bound queen south east capture.
   */
  @org.junit.Test
  public void testCanKillSE2() {
    queenOne = new Queen(7, 0, Color.BLACK);
    queenTwo = new Queen(7, 1, Color.WHITE);
    assertEquals(true, queenOne.canKill(queenTwo));
  }


  /**
   * Tests the canMove() detects invalid position.
   */
  @org.junit.Test
  public void testCanMoveFalse() {
    queenOne = new Queen(7, 0, Color.BLACK);
    assertEquals(false, queenOne.canMove(1, 2));
  }

  /**
   * Tests the canKill() detects invalid capture.
   */
  @org.junit.Test
  public void testCanMoveCaptureFalse() {
    queenOne = new Queen(7, 0, Color.BLACK);
    queenOne = new Queen(7, 1, Color.BLACK);
    assertEquals(false, queenOne.canMove(1, 2));
  }


  /**
   * Testing queen can capture piece horizontally to its left.
   */
  @org.junit.Test
  public void testCanMove1() {
    queenOne = new Queen(3, 3, Color.BLACK);
    assertEquals(true, queenOne.canMove(3, 0));
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal1() {
    queenOne = new Queen(-200, 300, Color.BLACK);
  }


  /**
   * Testing queen can move horizontally right.
   */
  @org.junit.Test
  public void testCanMove2() {
    queenOne = new Queen(3, 3, Color.BLACK);
    assertEquals(true, queenOne.canMove(3, 7));
  }

  /**
   * Testing queen can move vertically down.
   */
  @org.junit.Test
  public void testCanMove3() {
    queenOne = new Queen(3, 3, Color.BLACK);
    assertEquals(true, queenOne.canMove(0, 3));
  }

  /**
   * Testing queen cannot move out of bounds.
   */
  @org.junit.Test
  public void testCanMove4() {
    queenOne = new Queen(3, 3, Color.BLACK);
    assertEquals(false, queenOne.canMove(-5, 10));
  }

  /**
   * Testing queen can capture piece to its northwest.
   */
  @org.junit.Test
  public void testCanMove5() {
    queenOne = new Queen(3, 3, Color.BLACK);
    assertEquals(true, queenOne.canMove(0, 6));
  }


}