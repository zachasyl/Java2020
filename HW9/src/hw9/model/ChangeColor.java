package hw9.model;

/**
 * This class implements methods from interface Animation to detail a ChangeColor animation.
 */
public class ChangeColor implements Animation {
  private int start;
  private int end;
  private AnimationType type;
  private String oldColor;
  private String newColor;
  private AbstractShape shape;

  /**
   * Construct an MoveAnimation object.
   *
   * @param shape the shape the animation concerns.
   * @param color the color of the involved shape.
   * @param start the starting time unit of color change.
   * @param end   the ending time unit of color change.
   */
  public ChangeColor(AbstractShape shape, TheColor color, int start, int end) {
    this.shape = shape;
    this.oldColor = shape.shapeColor.toString();
    this.newColor = color.toString();
    this.start = start;
    this.end = end;
    this.type = AnimationType.CHANGECOLOR;
  }


  @Override
  public double getStartX() {
    return 0;
  }

  @Override
  public double getStartY() {
    return 0;
  }

  @Override
  public double getEndX() {
    return 0;
  }

  @Override
  public double getEndY() {
    return 0;
  }

  @Override
  public double getStartHeight() {
    return 0;
  }

  @Override
  public double getStartWidth() {
    return 0;
  }

  @Override
  public double getEndHeight() {
    return 0;
  }

  @Override
  public double getEndWidth() {
    return 0;
  }


  @Override
  public AnimationType getType() {
    return this.type;
  }

  @Override
  public IShapes getShape() {
    return this.shape;
  }

  @Override
  public int getStartTime() {
    return this.start;
  }

  @Override
  public int getEndTime() {
    return this.end;
  }

  @Override
  public String toString() {
    return String.format("Shape %s changes color from %s to %s from t=%d to t=%d\n",
            this.shape.getName(), this.oldColor, this.newColor, this.start, this.end);
  }

}
