/**
 * This class represents an element node in the polynomial adt implementation.
 */
public class ElementNodePolynomialADT implements PolynomialNodeADTInterface {
  private final int power;
  private int coefficient;
  private PolynomialNodeADTInterface rest;

  /**
   * Construct a Node adt power, coefficient, and rest of list.
   *
   * @param coefficient coefficient of term.
   * @param power       of term.
   * @param rest        next node.
   */
  public ElementNodePolynomialADT(int coefficient, int power, PolynomialNodeADTInterface rest) {
    this.power = power;
    this.coefficient = coefficient;
    this.rest = rest;
  }

  @Override
  public PolynomialNodeADTInterface addTerm(int coefficient, int power) {

    //otherwise if you have for instance 3^3 + 3^3 = 6^3 it would return 6^3 and 3^3
    //ElementNodePolynomialADT(this.coefficient + coefficient, power, this);
    if (power == this.power) {
      if (this.coefficient + coefficient == 0) {
        return this.rest;
      }
      this.coefficient = this.coefficient + coefficient;
      return this;
    }

    if (power > this.power) {

      return new ElementNodePolynomialADT(coefficient, power, this);
    } else {

      this.rest = this.rest.addTerm(coefficient, power);


      return this;
    }
  }

  /**
   * Adds other polynomial to polynomial.
   *
   * @param other the other polynomial
   * @return polynomial combined with polynomial other.
   */
  public Polynomial add(Polynomial other) {


    return null;
  }

  @Override
  public PolynomialNodeADTInterface removeTerm(int power) {
    if (this.power == power) {
      return this.rest.removeTerm(power);
    }

    this.rest = this.rest.removeTerm(power);
    return this;

  }


  @Override
  public int getDegree() {

    if (this.power >= this.rest.getDegree()) {
      return this.power;
    }
    return this.rest.getDegree();
  }

  /**
   * Override the toString method so that an object call returns a string.
   *
   * @return string of polynomial.
   */
  @Override
  public String toString() {


    if (this.power == 0 && this.coefficient > 0) {
      return "+" + String.valueOf(this.coefficient) + this.rest.toString();
    } else if (this.power == 0 && this.coefficient < 0) {
      return String.valueOf(this.coefficient) + this.rest.toString();
    } else if (this.coefficient < 0) {
      return String.valueOf(this.coefficient) + "x" + "^"
              + String.valueOf(this.power) + " " + this.rest.toString();

    } else if (this.coefficient > 0 && this.rest instanceof ElementNodePolynomialADT) {

      return "+" + String.valueOf(this.coefficient) + "x" + "^"
              + String.valueOf(this.power) + " " + this.rest.toString();

    } else if (this.coefficient > 0 && this.rest instanceof EmptyPolynomialADTNode) {

      return "+" + String.valueOf(this.coefficient) + "x" + "^"
              + String.valueOf(this.power) + this.rest.toString();
    } else {
      return "";
    }

  }

  @Override
  public int getCoefficient(int power) {
    if (this.power == power) {
      return this.coefficient;
    }
    return this.rest.getCoefficient(power);
  }

  public int getPower() {
    return this.power;
  }

  @Override
  public double evaluate(double value) {
    return (this.coefficient * Math.pow(value, this.power)) + rest.evaluate(value);
  }


}

