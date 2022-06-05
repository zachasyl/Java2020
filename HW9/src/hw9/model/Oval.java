package hw9.model;

/**
 * This class represents a Oval. It has all the methods of AbstractShape plus two unique ones.
 */
public class Oval extends AbstractShape {
  private double radiusX;
  private double radiusY;
  private double x;
  private double y;

  /**
   * Construct an Oval object.  An IllegalArgumentException is thrown if the width or height is less
   * than or equal to 0. secondx, secondy, and diagonals calculated during construction.
   *
   * @param x      center x coordinate.
   * @param y      center y coordinate.
   * @param width  the width of the oval.
   * @param height the height of the oval.
   */
  public Oval(String name, double x, double y, double width, double height,
              int appears, int disappears, TheColor shapeColor) {
    super(name, x, y, width, height, appears, disappears, shapeColor);

    this.type = ShapeType.OVAL;
    this.x = x;
    this.y = y;
    this.radiusX = width / 2;
    this.radiusY = height / 2;
  }


  /**
   * Override the toString method so that an object call returns the specified string.
   *
   * @return calling object returns a string detailing the object.
   */
  @Override
  public String toString() { // overriding the toString() method for object representation

    return ("Name: " + this.name + "\n" + "Type:" + this.type.toString().toLowerCase() +
            "\n"
            + "Center: (" + this.x + "," + this.y + "), "
            + "X radius: " + this.radiusX + ", Y radius: " + this.radiusY + ", Color: "
            + "(" + shapeColor + ")" + "\n" + "Appears at t=" + this.appears
            + "\n" + "Disappears at t=" + this.disappears + "\n"
            );
  }

  // The following two functions are UNIQUE to oval.
  //  An alternative is to Override the abstract getX and getY
  // to have them uniquely return the radius, but we opted not to do that
  // since returning x and y can give diameters...need to see rest of assignment.

  /**
   * Returns the radius, a method unique to the Oval.
   *
   * @return double RadiusX.
   */
  public double getRadiusW() {
    return this.radiusX;
  }

  /**
   * Returns the radius, a method unique to the Oval.
   *
   * @return double RadiusY.
   */
  public double getRadiusH() {
    return this.radiusY;
  }

}
