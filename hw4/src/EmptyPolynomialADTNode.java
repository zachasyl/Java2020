
/**
 * This class represents an empty node in the polynomial adt implementation.
 */

public class EmptyPolynomialADTNode implements PolynomialNodeADTInterface {
  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public double evaluate(double value) {
    return 0;

  }

  @Override
  public PolynomialNodeADTInterface removeTerm(int power) {
    return this;
  }



  @Override
  public PolynomialNodeADTInterface addTerm(int coefficient, int power) {

    return new ElementNodePolynomialADT(coefficient, power, this);
  }


  @Override
  public String toString() {
    return "";
  }

}