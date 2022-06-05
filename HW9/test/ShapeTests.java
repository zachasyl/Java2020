import org.junit.Test;

import static org.junit.Assert.assertEquals;

import hw9.model.Oval;
import hw9.model.Rectangle;
import hw9.model.TheColor;

/**
 * Tests shapes.
 */
public class ShapeTests {

  /**
   * Tests color.
   */
  @Test
  public void testColortoString() {
    TheColor color = new TheColor(50, 50, 200);
    assertEquals("50, 50, 200", color.toString());
  }

  /**
   * Tests you can return color from shape.
   */
  @Test
  public void testColorfromSHape() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals("50, 50, 200", rectangle.getShapeColor().toString());
  }

  /**
   * Tests you can return color from shape as a string (used in object tostring returns).
   */
  @Test
  public void testColorfromSHapeString() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals("50, 50, 200", rectangle.getStringColor());
  }

  /**
   * Tests getX.
   */
  @Test
  public void testgetX() {
    TheColor color = new TheColor(56, 83, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(50.0, rectangle.getX(), .01);
  }

  /**
   * Tests getY.
   */
  @Test
  public void testgetY() {
    TheColor color = new TheColor(56, 83, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(200.0, rectangle.getY(), .01);
  }

  /**
   * Tests getWidth.
   */
  @Test
  public void testgetWidth() {
    TheColor color = new TheColor(56, 83, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(3, rectangle.getWidth(), .01);
  }

  /**
   * Tests getHeight.
   */
  @Test
  public void testgetHeight() {
    TheColor color = new TheColor(56, 83, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(4, rectangle.getHeight(), .01);
  }

  /**
   * Tests getHeight.
   */
  @Test
  public void testgetName() {
    TheColor color = new TheColor(56, 83, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals("frank the rectangle", rectangle.getName());
  }

  /**
   * Tests rectangle toString().
   */
  @Test
  public void testRectangleToString() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(
            "Name: frank the rectangle\n"
                    + "Type: rectangle\n"
                    + "Min corner: (50.0,200.0), Width: 3.0, Height: 4.0, Color: (50, 50, 200)\n"
                    + "Appears at t=4\n"
                    + "Disappears at t=5\n", rectangle.toString());
  }


  /**
   * Tests rectangle getType().
   */
  @Test
  public void testENnm() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals("rectangle", rectangle.getType());
  }

  /**
   * Tests rectangle Appears().
   */
  @Test
  public void testAppears() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(4, rectangle.getAppears());
  }

  /**
   * Tests rectangle getType().
   */
  @Test
  public void testDisappears() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(5, rectangle.getDisappears());
  }

  /**
   * Tests oval getType(). will return enum converted to string
   */
  @Test
  public void testENnm2() {
    TheColor color = new TheColor(50, 50, 200);
    Oval oval = new Oval("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals("oval", oval.getType());
  }


  /**
   * Tests getradiusx.
   */
  @Test
  public void testRectangleRadiusW() {
    TheColor color = new TheColor(50, 50, 200);
    Oval oval = new Oval("frank the oval", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(1.5, oval.getRadiusW(), .01);
  }

  /**
   * Tests getradiusx.
   */
  @Test
  public void testRectangleRadiusH() {
    TheColor color = new TheColor(50, 50, 200);
    Oval oval = new Oval("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals(2.0, oval.getRadiusH(), .01);
  }

  /**
   * Tests oval toString().
   */
  @Test
  public void testOvalToString() {
    TheColor color = new TheColor(50, 50, 200);
    Oval oval = new Oval("frank the rectangle", 50, 200, 3, 4,
            4, 5, color);
    assertEquals("Name: frank the rectangle\n" +
            "Type:oval\n" +
            "Center: (50.0,200.0), X radius: 1.5, Y radius: 2.0, Color: (50, 50, 200)\n" +
            "Appears at t=4\n" +
            "Disappears at t=5\n", oval.toString());
  }

  /**
   * Tests cannot disappear before appear. If we want it to appear yet again it would have to be
   * redrawn as a new shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAafterDOval() {
    TheColor color = new TheColor(50, 50, 200);
    Oval oval = new Oval("frank the rectangle", 50, 200, 3, 4,
            5, 4, color);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAafterDRectangle() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, 3, 4,
            4, 4, color);
  }

  // Note i can not test out of bounds because we do not know what the bounds are and -x -y is
  // probably allowed.

  @Test(expected = IllegalArgumentException.class)
  public void testRectangleBadSize() {
    TheColor color = new TheColor(50, 50, 200);
    Rectangle rectangle = new Rectangle("frank the rectangle", 50, 200, -3, 4,
            4, 4, color);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCircleBadSize() {
    TheColor color = new TheColor(50, 50, 200);
    Oval oval = new Oval("frank the rectangle", 50, 200, -3, 4,
            4, 4, color);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadColor() {
    TheColor color = new TheColor(50, 50, 290);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadColor2() {
    TheColor color = new TheColor(50, -50, 30);
  }


}