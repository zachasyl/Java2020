import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for Knight.
 */
public class KnightTest {
  public Knight knightOne;
  public Bishop bishopOne;


  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal1() {
    knightOne = new Knight(4, 12, Color.BLACK);
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal2() {
    knightOne = new Knight(-4, 12, Color.BLACK);
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal3() {
    knightOne = new Knight(4, -12, Color.BLACK);
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating piece on square off of the
   * board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegal4() {
    knightOne = new Knight(-4, -12, Color.BLACK);
  }


  /**
   * Tests the getColumn().
   */
  @org.junit.Test
  public void testGetColumn() {
    knightOne = new Knight(7, 0, Color.BLACK);
    assertEquals(0, knightOne.getColumn());
  }

  /**
   * Tests the getRow().
   */
  @org.junit.Test
  public void testGetRow() {
    knightOne = new Knight(7, 0, Color.BLACK);
    assertEquals(7, knightOne.getRow());
  }

  /**
   * Tests the getColor(). Black.
   */
  @org.junit.Test
  public void testGetColorB() {
    knightOne = new Knight(7, 0, Color.BLACK);
    assertEquals(Color.BLACK, knightOne.getColor());
  }

  /**
   * Tests the getColor(). White.
   */
  @org.junit.Test
  public void testGetColorW() {
    knightOne = new Knight(7, 0, Color.WHITE);
    assertEquals(Color.WHITE, knightOne.getColor());
  }

  // note this begins testing of testCanMove1- testCanMove8, all of which determine
  // if each of the eight legal moves of the knight are possible from 3, 3.

  /**
   * Tests the canMove() method 3,3 to 5,2.
   */
  @org.junit.Test
  public void testCanMove1() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(5, 2));
  }

  /**
   * Tests the canMove() method 3,3 to 5,4.
   */
  @org.junit.Test
  public void testCanMove2() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(5, 4));
  }

  /**
   * Tests the canMove() method works moving for knight 3,3 to 4,1.
   */
  @org.junit.Test
  public void testCanMove3() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(4, 1));
  }

  /**
   * Tests the canMove() method works moving for knight 3,3 to 4,5.
   */
  @org.junit.Test
  public void testCanMove4() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(4, 5));
  }

  /**
   * Tests the canMove() method works moving for knight 3,3 to 2,1.
   */
  @org.junit.Test
  public void testCanMove5() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(2, 1));
  }


  /**
   * Tests the canMove() method works moving for knight 3,3 to 2,5.
   */
  @org.junit.Test
  public void testCanMove6() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(2, 5));
  }

  /**
   * Tests the canMove() method works moving for knight 3,3 to 1,2.
   */
  @org.junit.Test
  public void testCanMove7() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(1, 2));
  }

  /**
   * Tests the canMove() method works moving for knight 3,3 to 1,4.
   */
  @org.junit.Test
  public void testCanMove8() {
    knightOne = new Knight(3, 3, Color.BLACK);
    assertEquals(true, knightOne.canMove(1, 4));
  }

  /**
   * Tests the canKill() method works moving for knight moving left two down one.
   * Also tests whether piece can capture piece that is not the same as self.
   */
  @org.junit.Test
  public void testCanKillMove2() {
    knightOne = new Knight(4, 2, Color.BLACK);
    bishopOne = new Bishop(3, 0, Color.WHITE);

    assertEquals(true, knightOne.canKill(bishopOne));
  }

  /**
   * Tests the canKill() will fail if both pieces are white.
   */
  @org.junit.Test
  public void testCanKillMove2WW() {
    knightOne = new Knight(4, 2, Color.WHITE);
    bishopOne = new Bishop(3, 0, Color.WHITE);

    assertEquals(false, knightOne.canKill(bishopOne));
  }


  /**
   * Tests the canMove() method works moving for knight moving up two right one. different starting
   * pos.
   */
  @org.junit.Test
  public void testCanMoveOther() {
    knightOne = new Knight(4, 2, Color.BLACK);
    assertEquals(true, knightOne.canMove(6, 3));
  }


  /**
   * Tests the knight cant move to out of bound square that would be legal. (right two up one).
   */
  @org.junit.Test
  public void outOfBounds() {
    knightOne = new Knight(2, 6, Color.BLACK);
    assertEquals(false, knightOne.canMove(3, 8));
  }

  /**
   * Tests the knight cant move to out of bound square that would be legal. (right two up one).
   */
  @org.junit.Test
  public void outOfBounds2() {
    knightOne = new Knight(0, 7, Color.BLACK);
    assertEquals(false, knightOne.canMove(1, 9));
  }


}
