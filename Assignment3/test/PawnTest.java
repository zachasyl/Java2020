import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for Pawn.
 */
public class PawnTest {
  Pawn pawnOne;
  Knight knightOne;

  @org.junit.Test
  public void testGetColumn() {
    pawnOne = new Pawn(1, 2, Color.BLACK);
    assertEquals(2, pawnOne.getColumn());
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal1() {
    pawnOne = new Pawn(-50, 3, Color.BLACK);
  }


  /**
   * Tests the getRow().
   */
  @org.junit.Test
  public void testGetRow() {
    pawnOne = new Pawn(1, 2, Color.BLACK);
    assertEquals(1, pawnOne.getRow());
  }

  /**
   * Tests the getColor(). Black.
   */
  @org.junit.Test
  public void testGetColorB() {
    pawnOne = new Pawn(7, 0, Color.BLACK);
    assertEquals(Color.BLACK, pawnOne.getColor());
  }

  /**
   * Tests the getColor(). White.
   */
  @org.junit.Test
  public void testGetColorW() {
    pawnOne = new Pawn(7, 0, Color.WHITE);
    assertEquals(Color.WHITE, pawnOne.getColor());
  }

  /**
   * Tests if pawn can move forward one.
   */
  @org.junit.Test
  public void testMove() {
    pawnOne = new Pawn(1, 2, Color.WHITE);
    assertEquals(true, pawnOne.canMove(2, 2));
  }


  /**
   * Tests if pawn cant move forward more than one.
   */
  @org.junit.Test
  public void testMove2() {
    pawnOne = new Pawn(1, 2, Color.BLACK);
    assertEquals(false, pawnOne.canMove(4, 2));
  }

  /**
   * Tests that pawn may not move backwards.
   */
  @org.junit.Test
  public void testMove3() {
    pawnOne = new Pawn(1, 2, Color.WHITE);
    assertEquals(false, pawnOne.canMove(0, 2));
  }

  /**
   * Tests that pawn may capture diagonally one square diagonal left.
   */
  @org.junit.Test
  public void testKill() {
    pawnOne = new Pawn(1, 2, Color.WHITE);
    knightOne = new Knight(2, 1, Color.BLACK);

    assertEquals(true, pawnOne.canKill(knightOne));
  }

  /**
   * Tests that white pawn may  capture diagonally one square diagonal right.
   */
  @org.junit.Test
  public void testKill2() {
    pawnOne = new Pawn(1, 2, Color.WHITE);
    knightOne = new Knight(2, 3, Color.BLACK);

    assertEquals(true, pawnOne.canKill(knightOne));
  }

  /**
   * Tests that black pawn may capture diagonally one square diagonal right.
   */
  @org.junit.Test
  public void testKill2b() {
    pawnOne = new Pawn(2, 0, Color.BLACK);
    knightOne = new Knight(1, 1, Color.WHITE);

    assertEquals(true, pawnOne.canKill(knightOne));
  }


  /**
   * Tests that pawn may not capture diagonally three squares away. (may not capture diagonally more
   * than one diag away).
   */
  @org.junit.Test
  public void testKill3() {
    pawnOne = new Pawn(1, 2, Color.BLACK);
    knightOne = new Knight(4, 5, Color.BLACK);

    assertEquals(false, pawnOne.canKill(knightOne));
  }

  /**
   * Tests that pawn may not capture forwards not diagonally, false.
   */
  @org.junit.Test
  public void testKill4() {
    pawnOne = new Pawn(1, 2, Color.BLACK);
    knightOne = new Knight(2, 2, Color.BLACK);

    assertEquals(false, pawnOne.canKill(knightOne));
  }

}