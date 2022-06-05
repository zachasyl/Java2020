package hw9.model;

/**
 * This interface contains all public operations that all shapes support.
 */
public interface IShapes {

  /**
   * Color of shape.
   *
   * @return String shapes color as a string.
   */
  String getStringColor();

  /**
   * Color of shape.
   *
   * @return TheColor color as object.
   */
  TheColor getShapeColor();

  /**
   * Returns X coordinate of shape.
   *
   * @return double x coordinate.
   */
  double getX();

  /**
   * Returns Y coordinate of shape.
   *
   * @return double x coordinate.
   */
  double getY();

  /**
   * Returns width of shape.
   *
   * @return double width coordinate.
   */
  double getWidth();

  /**
   * Returns height of shape.
   *
   * @return double height coordinate.
   */
  double getHeight();

  /**
   * Returns name of shape.
   *
   * @return string name.
   */
  String getName();

  /**
   * Returns time that object appears.
   *
   * @return int time object appears.
   */
  int getAppears();

  /**
   * Returns time that object disappears.
   *
   * @return int time object disappears.
   */
  int getDisappears();

  /**
   * Returns string shape description.
   *
   * @return String.
   */
  String toString();


}