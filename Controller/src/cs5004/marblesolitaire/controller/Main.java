package cs5004.marblesolitaire.controller;

import java.io.InputStreamReader;
import java.io.IOException;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

// Note I know this does not need to be included please do not grade, used for testing.

/**
 * I used this for initial testing not part of assignment.
 */
public class Main {
  /**
   * I used this for initial testing not part of assignment.
   */
  public static void main(String[] args) throws IOException {
    MarbleSolitaireController controller
            = new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);
    //streams instead
    controller.playGame(new MarbleSolitaireModelImpl());
  }
}
