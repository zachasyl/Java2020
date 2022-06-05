import java.util.NoSuchElementException;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * This class represents a Rectangle. Its x, y, width, and height are parameters. A Rectangle has an
 * x and y coordinate which represent the position of its bottom left corner. It has a width and
 * height. It has a secondX and SecondY which represent the coordinate of its second x based on its
 * width and second y based on its height. Lastly, the Rectangle will have a diagonalX and
 * diagonalY, representing its top right corner, which is used for calculations in certain methods.
 */
public class Rectangle {
  private int x;
  private int y;
  private int width;
  private int height;
  private int secondX;
  private int secondY;
  private int diagonalX;
  private int diagonalY;
  private Rectangle other;

  /**
   * Construct a Rectangle object. Second coordinates and diagonals are calculated at shape
   * construction so we dont need to keep doing math ie this.x + this.width in multiple functions
   * repeatedly. An IllegalArgumentException is thrown if the width or height is less than or equal
   * to 0.
   *
   * @param x      the bottom left corner x coordinate.
   * @param y      the bottom left corner y coordinate.
   * @param width  the width of the rectangle.
   * @param height the height of the rectangle.
   */
  public Rectangle(int x, int y, int width, int height) {

    // IllegalArgumentException thrown if width or height less than equal to zero.
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be greater than 0");
    } else {

      this.secondX = x + width;
      this.secondY = y + height;

      // the points diagonal from bottom left corner.
      this.diagonalX = this.secondX + this.height;
      this.diagonalY = this.x + this.secondY;

      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }
  }

  /**
   * Override the toString method so that an object call returns a string.
   *
   * @return calling object returns the x, y, width, and height of object as a string.
   */
  public String toString() { // overriding the toString() method for object representation
    String strX = Integer.toString(x);
    String strY = Integer.toString(y);
    String strW = Integer.toString(width);
    String strH = Integer.toString(height);
    return (("x:" + strX + ", " + "y:" + strY + ", " + "w:" + strW
            + ", " + "h:" + strH));
  }

  /**
   * Determines if two rectangles share any overlap.
   *
   * @param other the rectangle with which a determination of whether there is an overlap is to be
   *              made.
   * @return Boolean true if overlap, false if no overlap.
   */
  public Boolean overlap(Rectangle other) {
    // Note that secondX, for instace, is just this.x + width.
    // If all four conditions are met there must be an overlap.
    if (this.x < other.secondX &&
            this.secondX > other.x
            && this.y < other.secondY
            && this.secondY > other.y) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * If there is an overlap, determines the x, y, width, and height of the rectangle that is a
   * result of the overlap -- the intersection rectangle. Throws a NoSuchElementException if there
   * is no overlap because there can be no resultant intersect rectangle if there is no overlap.
   *
   * @param other the rectangle with which an intersection is formed.
   * @returns intersect, the rectangle that is the intersection of the two rectangles.
   */
  public Rectangle intersect(Rectangle other) {
    // if there is no overlap, a NoSuchElementException is thrown.
    if (!this.overlap(other)) {
      throw new NoSuchElementException("There is no overlap!");
    } else {

      // Finding the diagonal coordinate allows calculation of intersection
      int newX = max(this.x, other.x);
      int newY = max(this.y, other.y);
      int newDiagonalX = min(this.diagonalX, other.diagonalX);
      int newDiagonalY = min(this.diagonalY, other.diagonalY);

      // Now we can see if the diagonals are greater than newX and newY.
      // Then, subtracting the lesser gives us width and height.
      int newWidth = max(newX, newDiagonalX) - min(newX, newDiagonalX);
      int newHeight = max(newY, newDiagonalY) - min(newY, newDiagonalY);

      Rectangle intersection = new Rectangle(newX, newY, newWidth, newHeight);
      return intersection;
    }
  }

  /**
   * Determines the union of two rectangle objects.
   *
   * @param other a rectangle object.
   * @return union, the resulting rectangle that is the union of two rectangle objects.
   */
  public Rectangle union(Rectangle other) {
    int newWidth = 0;
    int newHeight = 0;
    int newX = 0;
    int newY = 0;
    // the larger will determine the right side of the new rectangle...from that, the smaller
    //subtracted equals the new width.
    if (this.secondX > other.secondX) {
      newWidth = this.secondX - min(this.x, other.x);
    } else {
      newWidth = other.secondX - min(this.x, other.x);
    }
    if (this.secondY > other.secondY) {
      newHeight = this.secondY - min(this.y, other.y);
    } else {
      newHeight = other.secondY - min(this.y, other.y);
    }

    // the lesser serves as the left side x of the new rectangle.
    if (this.x < other.x) {
      newX = this.x;
    } else {
      newX = other.x;
    }
    if (this.y < other.y) {
      newY = this.y;
    } else {
      newY = other.y;
    }
    Rectangle union = new Rectangle(newX, newY, newWidth, newHeight);
    return union;
  }
}






