package hw9.model;


/**
 * This class represents a Rectangle. X and Y represent coordinates of lower left corner. It has a
 * width and height.
 */
public class Rectangle extends AbstractShape {


  /**
   * Construct a Rectangle object.  An IllegalArgumentException is thrown if the width or height is
   * less than or equal to 0. secondx, secondy, and diagonals calculated during construction.
   *
   * @param x      the bottom left corner x coordinate.
   * @param y      the bottom left corner y coordinate.
   * @param width  the width of the rectangle.
   * @param height the height of the rectangle.
   */


  public Rectangle(String name, double x, double y, double width, double height,
                   int appears, int disappears, TheColor shapeColor) {
    super(name, x, y, width, height, appears, disappears, shapeColor);

    this.type = ShapeType.RECTANGLE;

  }

  /**
   * Override the toString method so that an object call returns the specified string.
   *
   * @return calling object returns a string detailing the object.
   */
  public String toString() { // overriding the toString() method for object representation

    return ("Name: " + this.name + "\n" + "Type: " + this.getType() +
            "\n"
            + "Min corner: (" + this.x + "," + this.y + "), "
            + "Width: " + this.width + ", Height: " + this.height + ", Color: "
            + "(" + shapeColor + ")"
            + "\n" + "Appears at t=" + this.appears + "\n"
            + "Disappears at t=" + this.disappears + "\n"
            );
  }
}
