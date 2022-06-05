/**
 * This class represents a TransmissionBox. It has a current speed and four thresholds, all
 * parameters. The current gear is not a parameter and is determined by the constructor.
 */
public class TransmissionBox {

  // current speed of car. Note i used speed of car but irl it would be RPM of engine not mph
  // the instructions seem to say speed of car
  private double currentSpeed;
  // 1-2 or back.
  private int thresholdOne;
  // 2-3 or back.
  private int thresholdTwo;
  // 3-4 or back.
  private int thresholdThree;
  // 4-5 or back.
  private int thresholdFour;

  private int currentGear;

  /**
   * Construct a TransmissionBox object with the provided parameters current speed and threadholds
   * one through four. the TransmissionBox regulates currentGear by considering speed
   *
   * @param currentSpeed   current speed
   * @param thresholdOne   gear 1-2 or back
   * @param thresholdTwo   gear 2-3 or back
   * @param thresholdThree gear 3-4 or back
   * @param thresholdFour  gear 4-5 or back
   */

  public TransmissionBox(double currentSpeed, int thresholdOne, int thresholdTwo,
                         int thresholdThree, int thresholdFour) {
    this.currentSpeed = currentSpeed;
    this.thresholdOne = thresholdOne;
    this.thresholdTwo = thresholdTwo;
    this.thresholdThree = thresholdThree;
    this.thresholdFour = thresholdFour;
    if (currentSpeed < 0) { // throwing the exception in the constructor
      // so i can throw it just once.
      throw new IllegalArgumentException("No negatives/ reverse.");
    } else {
      // the currentGear is updated automatically based on speed
      // and current threshold and it is not a parameter.
      if (this.currentSpeed >= thresholdFour) {
        this.currentGear = 5;
      } else if (this.currentSpeed >= thresholdThree) {
        this.currentGear = 4;
      } else if (this.currentSpeed >= thresholdTwo) {
        this.currentGear = 3;
      } else if (this.currentSpeed > thresholdOne) {
        this.currentGear = 2;
      } else if (this.currentSpeed <= thresholdOne) {
        this.currentGear = 1;
      }
    }
  }

  /**
   * Override the toString method so that an object call returns a string.
   *
   * @return calling object returns the current gear, current speed, and each threshold as a string.
   */
  public String toString() { // overriding the toString() method for object representation

    return String.format("Current Gear: %d", currentGear) + ", "
            + String.format("Current Speed: %.2f", currentSpeed)
            + ", " + String.format("T1: %d", thresholdOne) + ", "
            + String.format("T2: %d", thresholdTwo) + ", "
            + String.format("T3: %d", thresholdThree)
            + ", " + String.format("T4: %d", thresholdFour) + ".";
  }

  /**
   * Increases speed of TransmissionBox object by two by creating a new transmissionBox with higher
   * speed.
   *
   * @return new increasedSpeed object with an increased speed (everything else same as original
   *      object).
   */
  public TransmissionBox speedIncrease() {

    TransmissionBox increasedSpeed = new TransmissionBox(this.currentSpeed
            + 2, this.thresholdOne, this.thresholdTwo, this.thresholdThree, this.thresholdFour);

    return increasedSpeed;
  }

  /**
   * Decreases speed of TransmissionBox object by two by creating a new transmissionBox with lower
   * speed.
   *
   * @return new decrasedSpeed object with an decreased speed (everything else same as original
   *      object).
   */
  public TransmissionBox speedDecrease() {

    TransmissionBox decreasedSpeed = new TransmissionBox(this.currentSpeed
            - 2, this.thresholdOne, this.thresholdTwo, this.thresholdThree, this.thresholdFour);
    return decreasedSpeed;
  }

  /**
   * speed of the current object.
   *
   * @return the object's current speed.
   */
  public double getSpeed() {

    return this.currentSpeed;
  }

  /**
   * Gear of the current object.
   *
   * @return the object's current gear.
   */
  public int getCurrentGear() {

    return this.currentGear;
  }
}











