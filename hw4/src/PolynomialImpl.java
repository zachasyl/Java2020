/**
 * This class implements the polynomial ADT.
 */

public class PolynomialImpl implements Polynomial {
  private PolynomialNodeADTInterface head;

  /**
   * Construct a Polynomial Implementation object that has a head. Implements the Polynomial ADT.
   * This allows for construction if a string is not input as a parameter.
   */
  public PolynomialImpl() {
    head = new EmptyPolynomialADTNode();

  }

  /**
   * Construct a Polynomial Implementation object that has a head.
   *
   * @param polynomial a string which is entered and converted/parsed into terms of a polynomialimpl
   *                   object so that a starting polynomialimpl object may consist of several terms
   *                   without building via addTerm.
   */
  public PolynomialImpl(String polynomial) {
    head = new EmptyPolynomialADTNode();

    if (polynomial.equals("")) {
      throw new IllegalArgumentException("invalid input");
    }

    String[] terms = polynomial.split(" ");


    for (String term : terms) {
      int power = 0;
      int coefficient = 0;
      if (term.contains("x") || term.contains("X")) {

        String[] termArray = term.split("\\^");

        String valueOfCoefficientWithX = termArray[0];

        int indexOfx = valueOfCoefficientWithX.indexOf("x");
        String coefficientValue = valueOfCoefficientWithX.substring(0, indexOfx);
        try {
          coefficient = Integer.parseInt(coefficientValue);
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Input is not a valid integer ");
        }

        if (termArray.length > 2) {
          throw new IllegalArgumentException("invalid input");

        } else if (termArray.length == 1) {
          power = 1;
        } else {
          power = Integer.parseInt(termArray[1]);

        }
      } else {
        power = 0;
        coefficient = Integer.parseInt(term);
      }

      addTerm(coefficient, power);

    }
  }


  @Override
  public void addTerm(int coefficient, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("cant be negative");
    }
    this.head = head.addTerm(coefficient, power);
  }

  @Override
  public void removeTerm(int power) {
    this.head = this.head.removeTerm(power);
  }

  @Override
  public int getDegree() {

    return this.head.getDegree();
  }


  @Override
  public int getCoefficient(int power) {
    return this.head.getCoefficient(power);
  }

  /**
   * Converts to string.
   */
  public String toString() {
    String x;
    String sub;
    x = head.toString();

    if (x.equals("")) {
      return "0";
    }
    // "chops" off + if plus is at front end by utilizing substring.
    if (x.charAt(0) == '+') {
      sub = x.substring(1);

      return sub;
    }

    return head.toString();
  }

  @Override
  public double evaluate(double value) {
    return this.head.evaluate(value);
  }

  @Override
  public Polynomial add(Polynomial other) {
    String con;
    String cat;
    String concat;
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("invalid must be Poloynomialimpl");
    }

    con = this.toString();
    cat = other.toString();


    concat = con + " " + cat;
    System.out.print(concat);
    return new PolynomialImpl(concat);


  }


}

