package hw9.model;

import java.awt.Color;

/**
 * This class sole purpose is to extend Java's Color class so that it can override the
 * toString method, which is used for shape color decriptions.
 */
public class TheColor extends Color {
  int r;
  int g;
  int b;

  /**
   * Extended r, g, b of TheColor used in string method.
   */
  public TheColor(int r, int g, int b) {
    super(r, g, b);
    this.r = r;
    this.g = g;
    this.b = b;

  }

  /**
   * Returns string representing color.
   */
  @Override
  public String toString() {
    return (r + ", " + g + ", " + b);
  }
}
