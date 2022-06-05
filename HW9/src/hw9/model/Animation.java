package hw9.model;


/**
 * This interface details all the methods an animation is capable of.
 */
public interface Animation {

  /**
   * Starting X of an animation.
   *
   * @return double start x.
   */
  double getStartX();

  /**
   * Starting Y of an animation.
   *
   * @return double start Y.
   */
  double getStartY();

  /**
   * End X of an animation.
   *
   * @return double end x.
   */
  double getEndX();

  /**
   * Starting Y of an animation.
   *
   * @return double end y.
   */
  double getEndY();


  /**
   * Starting height before an animation.
   *
   * @return double starting height
   */
  double getStartHeight();

  /**
   * Starting width before an animation.
   *
   * @return double starting width
   */
  double getStartWidth();

  /**
   * Ending height before an animation.
   *
   * @return double ending height
   */
  double getEndHeight();

  /**
   * Ending width before an animation.
   *
   * @return double ending width
   */
  double getEndWidth();

  /**
   * what type the animation is, for instance type move or type scale.
   *
   * @return AnimationType type.
   */
  AnimationType getType();

  /**
   * Returns object shape.
   *
   * @return IShapes the shap.
   */
  IShapes getShape();

  /**
   * Starting time of an animation.
   *
   * @return int starting time
   */
  int getStartTime();

  /**
   * Ending time of an animation.
   *
   * @return int ending time.
   */
  int getEndTime();

  /**
   * Returns a full description of the animation.
   *
   * @return String animation description.
   */
  String toString();


}
