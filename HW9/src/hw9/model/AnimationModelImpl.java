package hw9.model;


import java.util.ArrayList;

/**
 * This class contains all the methods implemented by the AnimationModel interface. It represents a
 * way of storing possible animations for certain geometric shapes. See interface for all javadocs.
 */
public class AnimationModelImpl implements AnimationModel {
  private int prevAniIndex;
  protected ArrayList<Animation> animations;
  protected ArrayList<IShapes> shapes;

  /**
   * Constructor that initializes initial values and ArrayLists.
   */
  public AnimationModelImpl() {
    this.prevAniIndex = 0;
    this.animations = new ArrayList<Animation>();
    this.shapes = new ArrayList<IShapes>();
  }

  // Note that we dont yet have an exception thrown if shapes have same name.
  // we dont even know if we should be getting them by name because the instructions dont say.
  @Override
  public void addShape(IShapes shape) throws IllegalArgumentException,
          IllegalStateException {
    if (shape != null) {
      // check if animation is valid

      int arraySize = shapes.size();
      // iterate through list and place animation according to time
      if (arraySize == 0) {
        shapes.add(shape);
      } else {
        for (int i = 0; i < arraySize; i++) {
          if (i == arraySize - 1 && shape.getAppears()
                  > shapes.get(i).getAppears()) {
            shapes.add(i + 1, shape);
          } else if (shape.getAppears() < shapes.get(i).getAppears()) {
            shapes.add(i, shape);
          }
        }
      }
    } else {
      throw new IllegalArgumentException("Shape is NULL.");
    }
  }


  private boolean checkAnimation(Animation a) {
    for (int i = 0; i < animations.size(); i++) {
      if (a.getShape() == animations.get(i).getShape()
              && a.getType() == animations.get(i).getType()
              && ((a.getStartTime() <= animations.get(i).getStartTime()
              && a.getEndTime() > animations.get(i).getStartTime())
              || (a.getStartTime() >= animations.get(i).getStartTime()
              && a.getStartTime() < animations.get(i).getEndTime()))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void addAnimation(Animation a) throws IllegalArgumentException,
          IllegalStateException {
    if (a != null) {
      // check if animation is valid
      if (!checkAnimation(a)) {
        throw new IllegalStateException("Conflicting animations are not valid.");
      }
      int arraySize = animations.size();
      // iterate through list and place animation according to time
      if (arraySize == 0) {
        animations.add(a);
        this.prevAniIndex = 0;
      } else {
        for (int i = 0; i < arraySize; i++) {
          if (i == arraySize - 1 && a.getStartTime()
                  > animations.get(i).getStartTime()) {
            animations.add(i + 1, a);
            this.prevAniIndex = i + 1;
          } else if (a.getStartTime() < animations.get(i).getStartTime()) {
            animations.add(i, a);
            this.prevAniIndex = i;
          }
        }
      }
    } else {
      throw new IllegalArgumentException("Animation is NULL.");
    }
  }

  @Override
  public void removePreviousAnimation() throws IllegalStateException {
    if (this.prevAniIndex < animations.size()) {
      animations.remove(prevAniIndex);
    } else {
      throw new IllegalStateException("Cannot remove animation.");
    }
  }

  /**
   * Returns a String which represents all shapes and animations contained within the model in
   * order.
   *
   * @return String a string which represents all shapes and animations contained within the model
   *         in order
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Shapes:\n");
    for (IShapes shape : shapes) {
      stringBuilder.append(shape.toString()).append("\n");
    }
    for (Animation animation : animations) {
      stringBuilder.append(animation.toString());
    }
    return stringBuilder.toString();
  }

  /**
   * Returns shape but its string name.
   *
   * @param name the string name assigned to an object.
   * @returns IShapes a shape.
   */
  public IShapes getShape(String name) {

    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i).getName().equals(name)) {
        return shapes.get(i);
      }
    }
    throw new IllegalArgumentException("shape does not exit.");
  }
}