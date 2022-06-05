import org.junit.Test;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Vector class.
 */
public class Vector3DTest {
  private Vector3D firstVector;
  private Vector3D secondVector;
  private Vector3D thirdVector;

  // used as parameter to test  multiply function
  double constant = 5;

  @Before
  public void setUp() throws Exception {
    // Create an instance that represents Vector firstVector;
    firstVector = new Vector3D(500, 68, 73);
    //Create an instance that represents Vector secondVector.
    secondVector = new Vector3D(0, 0, 0);
    // Create an instance that represents Vector thirdVector.
    thirdVector = new Vector3D(5, 6, 9);
  }

  /**
   * Tests ToString(). Ensures Vector object method toString() returns string that is comprised of
   * each component of vector
   */
  @Test
  public void testToString() {
    assertEquals("(500.00,68.00,73.00)", firstVector.toString());
  }

  /**
   * Tests Add(). Ensures Vector object method Add() returns string that is comprised of each
   * component of two vectors, added. Note a string is only returned because of the toString()
   * method.
   */
  @Test
  public void testAdd() {
    assertEquals("(505.00,74.00,82.00)", firstVector.add(thirdVector).toString());
  }

  /**
   * Tests Multiply(). Ensures Vector object method Multiply() returns string that is comprised of
   * each component of the vector, multiplied by a constant
   */
  @Test
  public void testMultiply() {
    assertEquals("(25.00,30.00,45.00)", thirdVector.multiply(constant).toString());
  }

  /**
   * Tests DotProduct(). Ensures Vector object method DotProduct() returns double dot product of two
   * vectors
   */
  @Test
  public void testDotProduct() {
    assertEquals(3565, thirdVector.dotProduct(firstVector),
            .01);
  }

  /**
   * Tests AngleBetween(). Ensures Vector object method AngleBetween() returns angle in degrees
   * between two vectors
   */
  @Test
  public void testAngleBetween() {
    assertEquals(54.07, firstVector.angleBetween(thirdVector), .01);
  }

  @Test(expected = IllegalArgumentException.class)
  // this will throw an exception since the magnitude is 0
  public void testAngleBetweenFail() {
    secondVector.angleBetween(firstVector);
  }

  /**
   * Tests Normalize(). Ensures Vector object method Normalize() returns string that is comprised of
   * normalization, and an exception is thrown if the magnitude is zero (as is the case in
   * normalization with secondVector)
   */
  @Test
  public void testNormalize() {
    assertEquals("(0.98,0.13,0.14)", firstVector.normalize().toString());
  }

  @Test(expected = IllegalArgumentException.class)
  // this will throw an exception since the magnitude is 0
  public void testNormalizeFail() {
    secondVector.normalize();
  }

  /**
   * Tests GetX(). Ensures Vector object method GetX() returns x.
   */
  @Test
  public void testGetX() {
    assertEquals(500, firstVector.getX(), .01);
  }

  /**
   * Tests GetY(). Ensures Vector object method GetY() returns y.
   */
  @Test
  public void testGetY() {
    assertEquals(68, firstVector.getY(), .01);
  }

  /**
   * Tests GetZ(). Ensures Vector object method GetZ() returns z.
   */
  @Test
  public void testGetZ() {
    assertEquals(73, firstVector.getZ(), .01);
  }

  /**
   * Tests Magnitude(). Ensures Vector object method Magnitude() returns double magnitude of vector
   */
  @Test
  public void testGetMagnitude() {
    assertEquals(509.85, firstVector.getMagnitude(), .01);

  }
}