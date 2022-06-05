/**
 * This class represents a vector. A Vector has a x, y, and z component and a magnitude.
 */
public class Vector3D {

  // x component of vector.
  private double x;

  // y component of a vector.
  private double y;

  // z component of a vector.
  private double z;

  /**
   * Construct a publication.Vector object that has the provided x, y and  z parameters.
   *
   * @param x the x value to be given to this vector.
   * @param y the y value to be given to this vector
   * @param z the z value to be assigned to this vector
   */

  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double getZ() {
    return this.z;
  }

  /**
   * Return the magnitude of this vector.
   *
   * @return double the magnitude of this Vector
   */
  public double getMagnitude() {
    // magnitude of vector.
    double magnitude;
    magnitude = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    return magnitude;
  }

  /**
   * override the toString method so that object call returns a string.
   *
   * @return calling object returns a string that contains the x, y, and z component of vector.
   */
  public String toString() { // overriding the toString() method for object representation
    return "(" + String.format("%.2f", x) + "," + String.format("%.2f", y) + ","
            + String.format("%.2f", z) + ")";
  }

  /**
   * the normalization of this vector.
   *
   * @return normalization of vector as as new Vector3D object, normalizeVector If magnitude is 0,
   *         throws exception.
   */
  public Vector3D normalize() {
    double magnitude;
    magnitude = getMagnitude();

    Vector3D normalizeVector = new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    if (magnitude == 0) {
      throw new IllegalArgumentException("cannot divide by 0");
    } else {
      return normalizeVector;
    }
  }

  /**
   * Adds the components of the vector with another vector's components.
   *
   * @return new object addVector, containing the x, y, and z components of the resultant vector
   */
  public Vector3D add(Vector3D vector) {

    Vector3D addVector = new Vector3D(this.x + vector.x, this.y
            + vector.y, this.z + vector.z);

    return addVector;
  }

  /**
   * Multiplies each component of the vector with a constant.
   *
   * @return new object multiplyVector, containing the x, y, and z components of the resultant
   *         vector
   */
  public Vector3D multiply(double constant) {

    Vector3D multiplyVector = new Vector3D(this.x * constant,
            this.y * constant, this.z * constant);

    return multiplyVector;

  }

  /**
   * dot product of each vector.
   *
   * @return the dot product of the vector, a double.
   */
  public double dotProduct(Vector3D vector) {
    return (this.x * vector.x) + (this.y * vector.y) + (this.z * vector.z);
  }

  /**
   * smallest angle between vector and another vector.
   *
   * @return double the smaller of two angles formed between vector and other vector in degrees
   */
  public double angleBetween(Vector3D vector) {
    if (this.getMagnitude() == 0 || vector.getMagnitude() == 0) {
      throw new IllegalArgumentException("cannot divide by 0");
    } else {
      return Math.toDegrees(Math.acos((dotProduct(vector) / ((this.getMagnitude())
              * (vector.getMagnitude())))));
    }
  }
}








