import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the list using ADT.
 */
public class PolynomialImplTest {
  Polynomial polynomial2;
  Polynomial list;
  Polynomial list2;


  /**
   * Tests functionality of addterm and tostring. Tests that negative and pos coefficients are
   * displayed correctly. Tests that the first term does not hae a "+" in front of it. Tests that
   * terms with same power combine.
   */
  @Test
  public void testAddTerm() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 3);
    list.addTerm(6, 3);
    list.addTerm(6, 2);
    list.addTerm(6, 1);
    list.addTerm(9, 3);
    list.addTerm(6, 20);
    list.addTerm(1, 9);
    list.addTerm(1, 50);

    assertEquals("1x^50 +6x^20 +1x^9 +21x^3 +6x^2 +6x^1", list.toString());
  }

  /**
   * Tests that an IllegalArgumentException is thrown when adding a term with a negative exponent.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArg() {
    Polynomial list = new PolynomialImpl();
    list.addTerm(1, -50);

  }

  /**
   * Tests that removeTerm correctly removes terms containing specified powers.
   */
  @Test
  public void testRemove() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 3);
    list.addTerm(6, 3);
    list.addTerm(6, 2);
    list.addTerm(6, 1);
    list.addTerm(6, 20);
    list.addTerm(1, 9);
    list.removeTerm(1);
    list.removeTerm(3);
    assertEquals("6x^20 +1x^9 +6x^2", list.toString());

  }

  /**
   * Tests that removeTerm doesn't behave unexpectedly when removing term that doesn't exist.
   */
  @Test
  public void testRemoveEmpty() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 3);

    list.removeTerm(5);
    assertEquals("6x^3", list.toString());
  }

  /**
   * Tests that PolynomialImpl can intake a string and convert it to terms. Tests that terms will
   * automatically combine if like. Tests combining terms with power of 1.
   */
  @Test
  public void testPolyString() {
    PolynomialImpl list = new PolynomialImpl("15x^3 -5x +99x");

    assertEquals("15x^3 +94x^1", list.toString());
  }

  /**
   * Tests that PolynomialImpl cannot intake letters.
   */
  @Test(expected = NumberFormatException.class)
  public void testPolyStringLetters() {
    PolynomialImpl list = new PolynomialImpl("a");
  }

  /**
   * Tests that get degree returns highest power.
   */
  @Test
  public void testDegree() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 3);
    list.addTerm(1, 9);
    list.addTerm(20, 8);

    assertEquals(9, list.getDegree());
  }

  /**
   * Tests that get coefficient returns co of specified power when multiple terms have the same
   * power.
   */
  @Test
  public void testGetCoefficient() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 3);
    list.addTerm(1, 9);
    list.addTerm(1, 3);
    list.addTerm(2, 3);
    list.addTerm(20, 8);
    list.getCoefficient(3);

    assertEquals(9, list.getCoefficient(3));

  }

  /**
   * Tests that get coefficient returns co of specified power when one term has the  power.
   */
  @Test
  public void testGetCoefficient2() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 3);
    list.addTerm(1, 9);

    assertEquals(6, list.getCoefficient(3));

  }

  /**
   * Tests that evaluate successfully plugs in x and does math correctly.
   */
  @Test
  public void testEvaluate() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 1);
    list.addTerm(5, 2);

    assertEquals(63.0, list.evaluate(3), .01);

  }

  /**
   * Tests that evaluate successfully plugs in x and does math correctly with a random decimal.
   */
  @Test
  public void testEvaluateDec() {
    Polynomial list = new PolynomialImpl();

    list.addTerm(6, 1);
    list.addTerm(5, 2);

    assertEquals(83.072, list.evaluate(3.52), .01);

  }

  /**
   * Tests that evaluate successfully plugs in x and does math correctly with a random decimal.
   */
  @Test
  public void testAdd() {
    Polynomial list = new PolynomialImpl("5x +3x");
    Polynomial list2 = new PolynomialImpl("5x +6x^3");
    // tests for ""
    Polynomial list3 = new PolynomialImpl("");

    assertEquals("6x^3 +13x^1", (list.add(list3)).toString());
    //assertEquals("6x^3 +13x^1", (list.add(list3)).toString());

  }

  /**
   * Tests that terms cancelling out.
   */
  @Test
  public void testAddNegate() {
    Polynomial list = new PolynomialImpl("5x");
    Polynomial list2 = new PolynomialImpl("-5x");


    assertEquals("0", (list.add(list2)).toString());
    //assertEquals("6x^3 +13x^1", (list.add(list3)).toString());

  }
}











