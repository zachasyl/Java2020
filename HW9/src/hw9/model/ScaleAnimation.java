package hw9.model;


import java.util.Objects;

/**
 * This class implements methods from interface Animation to create ScaleAnimation animation.
 * objects.
 */
public class ScaleAnimation implements Animation {
  private IShapes shape;
  private AnimationType type;
  private final double startWidth;
  private final double startHeight;
  private final double endWidth;
  private final double endHeight;
  private final int startTime;
  private final int endTime;

  /**
   * Construct an ScaleAnimation object.
   *
   * @param shape      the shape the animation concerns.
   * @param startWidth     starting x  of animation.
   * @param startHeight     starting y of animation.
   * @param endWidth       end x of animation.
   * @param endHeight       end y of animation.
   * @param startTime  time unit of animation start.
   * @param endTime    time unit of animation end.
   * @throws  NullPointerException if shape is null.
   */
  public ScaleAnimation(IShapes shape, double startWidth, double startHeight,
      double endWidth, double endHeight, int startTime, int endTime) {
    this.shape = Objects.requireNonNull(shape);
    this.type = AnimationType.SCALE;
    this.startWidth = startWidth;
    this.startHeight = startHeight;
    this.endWidth = endWidth;
    this.endHeight = endHeight;
    this.startTime = startTime;
    this.endTime = endTime;
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
    return this.startHeight;
  }

  @Override
  public double getStartWidth() {
    return this.startWidth;
  }

  @Override
  public double getEndHeight() {
    return this.endHeight;
  }

  @Override
  public double getEndWidth() {
    return this.endWidth;
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
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public String toString() {
    return String.format("Shape %s scales from Width: %f, Height: %f to Width: %f, "
        + "Height: %f from t=%d to t=%d\n", this.shape.getName(), this.startWidth,
        this.startHeight, this.endWidth, this.endHeight, this.startTime,
        this.endTime);
  }
}
