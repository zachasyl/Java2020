
/**
 * This interface represents all operations for a node in a list of
 * polynomial terms.
 * The advantage of the ADT design is that this interface may now represent
 * operations on a single node.
 */
public interface PolynomialNodeADTInterface {
  /**
   * gets coefficient of entered power.
   * Because coefficients of the same power will combine, there can only be
   * a single coefficient with the power the user enters as a parameter.
   * @param power the power for which you wish to get the coefficient.
   * @return coefficient of term with parameter power.
   *
   */

  int getCoefficient(int power);
  /**
   * Returns int highest power of all terms.
   *
   */

  int getDegree();
  /**
   * Evaluates the expression when x is equal to parameter value.
   *
   * @param value a double, the value of x.
   * @return double mathematical evaluation of expression.
   */

  double evaluate(double value);
  /**
   * Removes the term (coefficient and power) containing parameter power.
   *
   * @param power , the power of the term user wishes to remove.
   * @return PolynomialNodeADTInterface sequence without term.
   */

  PolynomialNodeADTInterface removeTerm(int power);
  /**
   * Adds terms to an expression. One may either add many terms
   * to create an expression or use addTerm to add terms to a
   * PolynomialImpl string.
   *
   * @param coefficient the coeffic of the term user wishes to add.
   * @param power the power of the term the user wishes to add.
   * @return PolynomialNodeADTInterface sequence with added term.
   */

  PolynomialNodeADTInterface addTerm(int coefficient, int power);

}

