
/**
 * This interface represents the List of polynomials. We do not deal with nodes here.
 */
public interface Polynomial {

  /**
   * Add term to list in descending order of power.
   *
   * @param coefficient int coeff of term.
   * @param power int power of term
   */
  void addTerm(int coefficient, int power);

  /**
   * Removes the term (coefficient and power) containing parameter power.
   *
   * @param power the power of the term user wishes to remove.
   */
  void removeTerm(int power);

  /**
   * Returns int highest power of all terms.
   */
  int getDegree();

  /**
   * Gets highest power.
   * @param power the power for which you wish to get the coefficient. Because coefficients of the
   *               same power will combine, there can only be a single coefficient with the power
   *               the user enters as a parameter.
   * @return int coefficient of term with parameter power.
   */
  int getCoefficient(int power);

  /**
   * Evaluates the expression when x is equal to parameter value.
   *
   * @param value a double, the value of x.
   * @return double mathematical evaluation of expression.
   */
  double evaluate(double value);

  /**
   * Adds other polynomial to polynomial.
   * polynomial combined with polynomial other.
   */
  Polynomial add(Polynomial other);

}


