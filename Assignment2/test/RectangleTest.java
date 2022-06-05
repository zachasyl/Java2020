import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for Rectangle.
 */

public class RectangleTest {
  private Rectangle rectangleOne;
  private Rectangle rectangleTwo;


  @Before
  public void setUp() {
    //  creates rectangle objects for testing purposes
    rectangleOne = new Rectangle(1, 0, 4, 6);
    rectangleTwo = new Rectangle(3, 2, 5, 2);

  }

  /**
   * Tests the ToString method to ensure object output is a string.
   */
  @Test
  public void testToString() {
    assertEquals("x:1, y:0, w:4, h:6", rectangleOne.toString());
  }

  /**
   * Tests the Intersection method.
   */
  @Test
  public void testIntersect() {
    assertEquals("x:3, y:2, w:2, h:2", rectangleOne.intersect(rectangleTwo).toString());
  }

  /**
   * Tests the Intersection method.
   */
  @Test
  public void testIntersect3() {
    rectangleOne = new Rectangle(1, 5, 40, 50);
    rectangleTwo = new Rectangle(10, 3, 500, 300);
    assertEquals("x:10, y:5, w:31, h:50", rectangleOne.intersect(rectangleTwo).toString());
  }

  /**
   * Tests the Intersection method where and and y are 0.
   */
  @Test
  public void testIntersect4() {
    rectangleOne = new Rectangle(0, 0, 40, 50);
    rectangleTwo = new Rectangle(0, 0, 30, 10);
    assertEquals("x:0, y:0, w:30, h:10", rectangleOne.intersect(rectangleTwo).toString());
  }

  /**
   * Tests the overlap method on two rectangles that overlap.
   */
  @Test
  public void testOverlap() {
    assertEquals(true, rectangleOne.overlap(rectangleTwo));
  }

  /**
   * Tests the overlap method on two rectangles that share a X side but do not actually overlap.
   */
  @Test
  public void testOverlap2() {
    rectangleOne = new Rectangle(1, 0, 1, 1);
    rectangleTwo = new Rectangle(1, 1, 1, 1);

    assertEquals(false, rectangleOne.overlap(rectangleTwo));
  }

  /**
   * Tests the overlap method on two rectangles that share a Y but do not actually overlap.
   */
  @Test
  public void testOverlap3() {
    rectangleOne = new Rectangle(1, 0, 1, 1);
    rectangleTwo = new Rectangle(2, 0, 1, 1);

    assertEquals(false, rectangleOne.overlap(rectangleTwo));
  }

  /**
   * Tests the overlap method on two rectangles that clearly dont overlap.
   */
  @Test
  public void testOverlap4() {
    rectangleOne = new Rectangle(1, 0, 1, 1);
    rectangleTwo = new Rectangle(20, 20, 1, 1);

    assertEquals(false, rectangleOne.overlap(rectangleTwo));
  }

  /**
   * Tests the Union method.
   */
  @Test
  public void testUnion() {
    assertEquals("x:1, y:0, w:7, h:6", rectangleOne.union(rectangleTwo).toString());

  }

  /**
   * Tests that an IllegalArgumentException is thrown when height is 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testZeroHeight() {
    Rectangle zeroHeight;
    zeroHeight = new Rectangle(0, 3, 5, 0);

  }

  /**
   * Tests that an IllegalArgumentException is thrown when width is 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testZeroWidth() {
    Rectangle zeroWidth;
    zeroWidth = new Rectangle(0, 3, 0, 5);
  }

  /**
   * Tests that an NoSuchElementException is thrown when we are asked for the intersection between
   * two rectangles that dont overlap.
   */

  @Test(expected = NoSuchElementException.class)
  public void testIntersectionNoSuchElement() {
    Rectangle overlapTest1;
    Rectangle overlapTest2;
    overlapTest1 = new Rectangle(0, 0, 1, 1);
    overlapTest2 = new Rectangle(200, 200, 1, 1);
    overlapTest1.intersect(overlapTest2);
  }

  /**
   * Tests that an NoSuchElementException is thrown when we are asked for the intersection between
   * two rectangles that dont overlap.
   */
  @Test(expected = NoSuchElementException.class)
  public void testIntersectionNoSuchElement2() {
    Rectangle overlapTest1;
    Rectangle overlapTest2;
    overlapTest1 = new Rectangle(0, 0, 1, 1);
    overlapTest2 = new Rectangle(200, 200, 1, 1);
    overlapTest2.intersect(overlapTest1);
  }
}

