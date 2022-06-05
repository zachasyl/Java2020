package hw9.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * This class contains many of the tests for AnimationModel.
 */
public class AnimationTests {
  AnimationModel model;
  ArrayList<IShapes> shapes;

  /**
   * Sets up AnimationModelImpl and ArrayList shapes for future testing.
   */
  @Before
  public void setup() {
    model = new AnimationModelImpl();
    shapes = ((AnimationModelImpl) model).shapes;
  }

  /**
   * Tests get start height scale.
   */
  @Test
  public void testGetStartHeight() {

    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    ScaleAnimation a = new ScaleAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(5, a.getStartHeight(), .01);

  }

  /**
   * Tests get start width scale.
   */
  @Test
  public void testGetStartWidth() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    ScaleAnimation a = new ScaleAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(4, a.getStartWidth(), .01);

  }


  /**
   * Tests get end width scale.
   */
  @Test
  public void testGetStartEndWidth() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    ScaleAnimation a = new ScaleAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(6, a.getEndWidth(), .01);

  }


  /**
   * Tests get end height scale.
   */
  @Test
  public void testGetStartEndHeight() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    ScaleAnimation a = new ScaleAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(7, a.getEndHeight(), .01);

  }


  /**
   * Tests start x Move.
   */
  @Test
  public void testGetStartXMove() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    MoveAnimation a = new MoveAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(4, a.getStartX(), .01);

  }

  /**
   * Tests start Y Move.
   */
  @Test
  public void testGetStartYMove() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    MoveAnimation a = new MoveAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(5, a.getStartY(), .01);

  }

  /**
   * Tests end x.
   */
  @Test
  public void testGetEndX() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    MoveAnimation a = new MoveAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(6, a.getEndX(), .01);

  }

  /**
   * Tests end Y Move.
   */
  @Test
  public void testGetEndY() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    MoveAnimation a = new MoveAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(7, a.getEndY(), .01);

  }

  /**
   * Tests start time Move.
   */
  @Test
  public void testStartTimeMove() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    MoveAnimation a = new MoveAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(11, a.getStartTime(), .01);

  }

  /**
   * Tests end time Move.
   */
  @Test
  public void testEndTimeMove() {
    Rectangle r = new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5));
    MoveAnimation a = new MoveAnimation(r, 4, 5,
            6, 7, 11, 20);
    assertEquals(20, a.getEndTime(), .01);

  }

  /**
   * Tests addShape with model toString() method.
   */
  @Test
  public void testAddShape() {
    model.addShape(new Rectangle("R", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5)));
    model.addShape(new Oval("O", 400, 500, 4, 5, 1,
            10, new TheColor(5, 5, 5)));

    assertEquals("Shapes:\n"
            + "Name: O\n"
            + "Type:oval\n"
            + "Center: (400.0,500.0), X radius: 2.0, Y radius: 2.5, Color: (5, 5, 5)\n"
            + "Appears at t=1\n"
            + "Disappears at t=10\n"
            + "\n"
            + "Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (500.0,600.0), Width: 5.0, Height: 6.0, Color: (5, 5, 5)\n"
            + "Appears at t=10\n"
            + "Disappears at t=20\n"
            + "\n", model.toString());
  }

  /**
   * Tests addAnimation with 3 possible animations. Tests with toString().
   */
  @Test
  public void testAddAnimation() {
    model.addShape(new Oval("Oval", 400, 500, 4, 5, 1,
            10, new TheColor(5, 5, 5)));
    model.addShape(new Rectangle("Rect", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5)));
    model.addAnimation(new MoveAnimation(model.getShape("Oval"), 4, 5, 5,
            6, 1, 10));
    model.addAnimation(new ScaleAnimation(model.getShape("Rect"), 4, 5,
            6, 7, 11, 20));
    model.addAnimation(new ChangeColor((AbstractShape) model.getShape("Rect"),
            new TheColor(5, 5, 5),
            10, 20));
    assertEquals("Shapes:\n"
            + "Name: Oval\n"
            + "Type:oval\n"
            + "Center: (400.0,500.0), X radius: 2.0, Y radius: 2.5, Color: (5, 5, 5)\n"
            + "Appears at t=1\n"
            + "Disappears at t=10\n"
            + "\n"
            + "Name: Rect\n"
            + "Type: rectangle\n"
            + "Min corner: (500.0,600.0), Width: 5.0, Height: 6.0, Color: (5, 5, 5)\n"
            + "Appears at t=10\n"
            + "Disappears at t=20\n"
            + "\n"
            + "Shape Oval moves from (4.000000, 5.000000) to (5.000000, 6.000000) from t=1 to " +
            "t=10\n"
            + "Shape Rect changes color from 5, 5, 5 to 5, 5, 5 from t=10 to t=20\n"
            + "Shape Rect scales from Width: 4.000000, Height: 5.000000 "
            + "to Width: 6.000000, Height: 7.000000 from t=11 to t=20\n", model.toString());
  }

  /**
   * Tests removePreviousAnimation by removing an animation from the ArrayList. Tests with
   * toString().
   */
  @Test
  public void testRemovePreviousAnimation() {
    model.addShape(new Oval("Oval", 200, 300, 4, 5, 1,
            10, new TheColor(5, 5, 5)));
    model.addAnimation(new MoveAnimation(shapes.get(0), 4, 5, 5,
            6, 1, 10));
    assertEquals("Shapes:\n"
            + "Name: Oval\n"
            + "Type:oval\n"
            + "Center: (200.0,300.0), X radius: 2.0, Y radius: 2.5, Color: (5, 5, 5)\n"
            + "Appears at t=1\n"
            + "Disappears at t=10\n"
            + "\n"
            + "Shape Oval moves from (4.000000, 5.000000) to (5.000000, 6.000000) from t=1 to" +
            " t=10\n", model.toString());
    model.removePreviousAnimation();
    assertEquals("Shapes:\n"
            + "Name: Oval\n"
            + "Type:oval\n"
            + "Center: (200.0,300.0), X radius: 2.0, Y radius: 2.5, Color: (5, 5, 5)\n"
            + "Appears at t=1\n"
            + "Disappears at t=10\n"
            + "\n", model.toString());
  }

  /**
   * Tests IllegalArgumentExceptin will be thrown if the shape doesnt exit in the array.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testExceptionNoName() {
    model.addShape(new Rectangle("Frank", 500, 600, 5, 6, 10,
            20, new TheColor(5, 5, 5)));

    assertEquals(6, model.getShape("Bob"));
  }


  /**
   * Tests that addShape throws IllegalArgumentException if argument is NULL.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException1() {
    model.addShape(null);
  }


  /**
   * Tests that addAnimation throws  IllegalArgumentException if argument is NULL.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    model.addAnimation(null);
  }

  /**
   * Tests that addAnimation throws IllegalStateException if conflicting animation has overlapping
   * time intervals.
   */
  @Test(expected = IllegalStateException.class)
  public void testException3() {
    model.addShape(new Oval("Oval", 200, 300, 4, 5, 1,
            10, new TheColor(5, 5, 5)));
    model.addAnimation(new MoveAnimation(shapes.get(0), 4, 5, 5,
            6, 1, 10));
    model.addAnimation(new MoveAnimation(shapes.get(0), 3, 4, 5,
            6, 5, 11));
  }

  /**
   * Tests that addAnimation throws IllegalStateException if conflicting animation has overlapping
   * time intervals.
   */
  @Test(expected = IllegalStateException.class)
  public void testException4() {
    model.addShape(new Oval("Oval", 200, 300, 4, 5, 1,
            10, new TheColor(5, 5, 5)));
    model.addAnimation(new MoveAnimation(shapes.get(0), 4, 5, 5,
            6, 5, 10));
    model.addAnimation(new MoveAnimation(shapes.get(0), 3, 4, 5,
            6, 1, 10));
  }

  /**
   * Tests that addAnimation throws IllegalStateException if conflicting animation has overlapping
   * time intervals.
   */
  @Test(expected = IllegalStateException.class)
  public void testException5() {
    model.addShape(new Oval("Oval", 200, 300, 4, 5, 1,
            10, new TheColor(5, 5, 5)));
    model.addAnimation(new MoveAnimation(shapes.get(0), 4, 5, 5,
            6, 1, 10));
    model.addAnimation(new MoveAnimation(shapes.get(0), 3, 4, 5,
            6, 5, 6));
  }

  /**
   * Tests that addAnimation throws IllegalStateException if conflicting animation has overlapping
   * time intervals.
   */
  @Test(expected = IllegalStateException.class)
  public void testException6() {
    model.addShape(new Oval("Oval", 200, 300, 4, 5, 1,
            10, new TheColor(5, 5, 5)));
    model.addAnimation(new MoveAnimation(shapes.get(0), 4, 5, 5,
            6, 5, 10));
    model.addAnimation(new MoveAnimation(shapes.get(0), 3, 4, 5,
            6, 1, 20));
  }

  /**
   * Testing that removePreviousAnimation throws IllegalStateException if ArrayList is empty.
   */
  @Test(expected = IllegalStateException.class)
  public void testException7() {
    model.removePreviousAnimation();
  }
}
