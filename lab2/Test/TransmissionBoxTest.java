import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for TransmissionBox.
 */
public class TransmissionBoxTest {
  // three cars that are unique TransmissionBoxes
  private TransmissionBox carOne;
  private TransmissionBox carTwo;
  private TransmissionBox carThree;

  @Before
  public void setUp() {
    carOne = new TransmissionBox(9, 10, 20, 30,
            40);
    carTwo = new TransmissionBox(49, 10, 25, 30,
            50);
    carThree = new TransmissionBox(-500, 10, 20, 30,
            40);
  }

  /**
   * Tests that an speedIncrease correctly causes an in increase in gear and speed. speedIncrease()
   * creates a new object with a new speed and the if statements in constructor determine gear.
   */
  @Test
  public void testSpeedIncrease() {
    assertEquals("Current Gear: 2, Current Speed: 11.00, T1: 10, T2: 20, T3: 30, T4: 40.",
            carOne.speedIncrease().toString());

    assertEquals("Current Gear: 5, Current Speed: 51.00, T1: 10, T2: 25, T3: 30, T4: 50.",
            carTwo.speedIncrease().toString());
  }

  /**
   * Tests that an speedDecrease correctly causes an in decrease in gear and speed. speedDecrease()
   * creates a new object with a new speed and the if statements in constructor determine gear.
   */
  @Test
  public void testSpeedDecrease() {
    assertEquals("Current Gear: 1, Current Speed: 7.00, T1: 10, T2: 20, T3: 30, T4: 40.",
            carOne.speedDecrease().toString());
  }

  /**
   * Tests that an IllegalArgumentException is thrown when it is expected to be thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSpeedDecreaseFail() {
    carThree.speedDecrease();
  }

  /**
   * Tests that getSpeed correctly gets current speed. Here we increase car one speed twice and see
   * that it gets the correct speed.
   */
  @Test
  public void testGetSpeed() {
    assertEquals(13, carOne.speedIncrease().speedIncrease().getSpeed(), .01);

  }

  /**
   * Tests that getCurrentGear correctly obtains the correct gear.
   */
  @Test
  public void getCurrentGear() {
    assertEquals(1, carOne.getCurrentGear());
  }
}