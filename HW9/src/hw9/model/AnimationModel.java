package hw9.model;

/**
 * This interface represents the operations offered by the animation model. The methods herein
 * record descriptions of different possible animations for geometric shapes.
 */
public interface AnimationModel {

  /**
   * Adds IShapes object to ArrayList in model. It adds it in the order in which they appear. Throws
   * IllegalArgumentException if IShape object is NULL.
   *
   * @param shape IShapes object
   * @throws IllegalArgumentException if IShapes object is NULL
   */
  void addShape(IShapes shape) throws IllegalArgumentException;

  /**
   * Adds Animation object, such as MoveAnimation, ScaleAnimation, or ChangeColor, to ArrayList in
   * model. Method checks if animation is legal(not overlapping with previous contrary changes) and
   * adds it in order by start time. Thows IllegalArgumentException if Animation is NULL, and throws
   * IllegalStateException if Animation is not legal.
   *
   * @param a Animation object
   * @throws IllegalArgumentException if Animation is NULL
   * @throws IllegalStateException    if Animation is not legal
   */
  void addAnimation(Animation a) throws IllegalArgumentException,
          IllegalStateException;

  /**
   * Removes previous animation (in case a mistake is made) by locating the previous index and
   * removing at index. Throws IllegalStateException if you try to remove from an empty ArrayList.
   *
   * @throws IllegalStateException if trying to remove from empty ArrayList
   */
  void removePreviousAnimation() throws IllegalStateException;


  /**
   * Returns shape but its string name.
   *
   * @param name the string name assigned to an object.
   * @returns IShapes a shape.
   */
  IShapes getShape(String name);

  /**
   * Returns description of animation as a string.
   *
   * @returns String.
   */
  String toString();

}
