package hw9.model;

/**
 * This abstract class represents a hypothetical shape. It offers  operations of the IShapes
 * interface. Please see interface for javadocs of methods.
 */
public class AbstractShape implements IShapes {
  protected String name;
  protected ShapeType type;
  protected double x;
  protected double y;
  protected double width;
  protected double height;
  protected int appears;
  protected int disappears;
  // = new Color(123, 111, 222);
  // https://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html
  protected TheColor shapeColor;

  /**
   * Construct an Oval object.  An IllegalArgumentException is thrown if the width or height is less
   * than or equal to 0. secondx, secondy, and diagonals calculated during construction.
   *
   * @param x          center x coordinate.
   * @param y          center y coordinate.
   * @param width      the width of the oval.
   * @param height     the height of the oval.
   * @param appears    time shape appears in animation.
   * @param disappears time shape disappears in animation,
   * @param shapeColor the color of the shape.
   * @throws IllegalArgumentException if width or height are not greater than zero.
   * @throws IllegalArgumentException if disappear before appear.
   * @oaram name the name of the shape.
   */
  public AbstractShape(String name, double x, double y, double width, double height,
                       int appears, int disappears, TheColor shapeColor) {

    // IllegalArgumentException thrown if width or height less than equal to zero.
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be greater than 0");
    } else if (appears >= disappears) {
      throw new IllegalArgumentException("Cannot disappear before appear");
    } else {
      this.x = x;
      this.y = y;
      this.name = name;
      this.width = width;
      this.height = height;
      this.appears = appears;
      this.disappears = disappears;
      this.shapeColor = shapeColor;
    }
  }

  public String getType() {

    return this.type.toString().toLowerCase();
  }

  @Override
  public double getX() {
    return this.x;
  }

  @Override
  public double getY() {
    return this.y;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getAppears() {
    return this.appears;
  }

  @Override
  public int getDisappears() {
    return this.disappears;
  }

  @Override
  public String getStringColor() {
    return this.shapeColor.toString();
  }

  @Override
  public TheColor getShapeColor() {
    return this.shapeColor;
  }
}
