package hw9.model;


import java.util.Objects;

/**
 * This class represents the MoveAnimation animation.
 */
public class MoveAnimation implements Animation {
  private IShapes shape;
  private AnimationType type;
  private final double startX;
  private final double startY;
  private final double endX;
  private final double endY;
  private final int startTime;
  private final int endTime;

  /**
   * Construct an MoveAnimation object.
   *
   * @param shape     the shape the animation concerns.
   * @param startX    starting x  of animation.
   * @param startY    starting y of animation.
   * @param endX      end x of animation.
   * @param endY      end y of animation.
   * @param startTime time unit of animation start.
   * @param endTime   time unit of animation end.
   */
  public MoveAnimation(IShapes shape, double startX, double startY, double endX,
                       double endY, int startTime, int endTime) {
    this.shape = Objects.requireNonNull(shape);
    this.type = AnimationType.MOVE;
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public double getStartX() {
    return this.startX;
  }

  @Override
  public double getStartY() {
    return this.startY;
  }

  @Override
  public double getEndX() {
    return this.endX;
  }

  @Override
  public double getEndY() {
    return this.endY;
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
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public String toString() {
    return String.format("Shape %s moves from (%f, %f) to (%f, %f) from t=%d to "
                    + "t=%d\n", this.shape.getName(), this.startX, this.startY, this.endX,
            this.endY, this.startTime, this.endTime);
  }


}
