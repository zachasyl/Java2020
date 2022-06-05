package cs5004.marblesolitaire.model;

/**
 * This class represents an implementation of the MSM. It offers all the operations and constructors
 * for a Marble Solitaire game.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private String[][] board;
  // default armThickness, default r and default c. Updated in constructors.
  /**
   * ᕙ(⇀‸↼‶)ᕗ.
   */
  private int armThickness = 3;
  private int r = 7;
  private int c = 7;

  /**
   * This private function is not intended to be called by any outside classes. It is used by each
   * constructor to setup the board to avoid code repetition. It determines which part of the board
   * will be the plus shape. Note that the _ space is calculated by the actual constructor after the
   * helper call.
   *
   * @returns void
   */
  private void implHelper() {
    this.board = new String[r][c];

    for (int row = 0; row < r; row++) {
      for (int col = 0; col < c; col++) {
        if (// The fours corners which will be filled with " " are calculated here.
                (row < armThickness - 1 && (col < armThickness - 1 || col > c - armThickness))
                        ||
                (row > r - armThickness && (col < armThickness - 1 || col > c - armThickness))
        ) {

          board[row][col] = " ";

        } else {
          // part of the "plus" shape to be filled with Os
          board[row][col] = "O";
        }
      }

    }
  }

  /**
   * The default constructor which takes no parameters. It can be used for a game where there is one
   * blank space at the board's center and the armthickness, r, and c is 7.
   */
  public MarbleSolitaireModelImpl() {
    implHelper();
    //calculates center of board using default r and c.
    this.board[(r / 2)][(c / 2)] = "_";
  }

  /**
   * A constructor which will take in a row and a column and use those inputs to determine the
   * location of the chosen "_". Everything else is default.
   *
   * @param sRow the row number of the empty position.
   * @param sCol the column number of the empty position.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    implHelper();
    //calculates center of board using parameter r and c.
    //Exception added during assignment 7.
    if (sRow < 0 || sCol < 0 ) {
      throw new IllegalArgumentException("invalid starting position");
    }
    this.board[sRow][sCol] = "_";
  }

  /**
   * A constructor which will take in a row and a column and arm thickness and use those inputs to
   * determine the location of the chosen "_". It will calculate r and c based on the armthickness.
   *
   * @param armThickness the thicc of left right top and bottom of plus sign.
   * @param sRow         the row number of the empty position.
   * @param sCol         the column number of the empty position.
   * @throws IllegalArgumentException if user tries to enter an even arm thickness.
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {

    //added assignment 7.
    if (sRow < 0 || sCol < 0 ) {
      throw new IllegalArgumentException("invalid starting position");
    }

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }
    this.armThickness = armThickness;

    // calculates r and c since we cannot use the defaults due to new armthickness.
    int r = armThickness + (armThickness - 1) + (armThickness - 1);
    int c = r;
    // this objects r and c will be set to calculation based on parameters.
    this.r = r;
    this.c = c;
    implHelper();
    if (!board[sRow][sCol].equals("O")) {
      throw new IllegalArgumentException("stop");
    } else {
      this.board[sRow][sCol] = "_";
    }
  }


  /**
   * A constructor which will take the arm thickness and use those inputs to determine the location
   * of the chosen "_". It will calculate r and c based on the armthickness.
   *
   * @param armThickness the thicc of left right top and bottom of plus sign.
   * @throws IllegalArgumentException if user tries to enter an even arm thickness.
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }
    this.armThickness = armThickness;

    int r = armThickness + (armThickness - 1) + (armThickness - 1);
    int c = r;

    this.r = r;
    this.c = c;
    implHelper();

    this.board[(r / 2)][(c / 2)] = "_";

  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException out of bounds if row or c is out of bounds.
   * @throws IllegalArgumentException cant move to start location.
   * @throws IllegalArgumentException need to select a marble.
   * @throws IllegalArgumentException must move to an empty space.
   * @throws IllegalArgumentException some conditions are met but the marbles are more than 1
   *                                  apart.
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    // Exceptions:
    if (toRow < 0 || toRow > r - 1 || toCol < 0 || toCol > c - 1) {
      throw new IllegalArgumentException("out of bounds");
    }
    if (fromRow == toRow && fromCol == toCol) {
      throw new IllegalArgumentException("Can't move to start location");
    }

    if (!this.board[toRow][toCol].equals("_")) {
      throw new IllegalArgumentException("Must move to an empty space.");
    }

    // four if/else if statements which check up, right, down, and left.
    // If you are moving a marble to an empty space two away in those directions,
    // then the marble will be placed there. Then the space inbetween(one away)
    // which was "skipped" becomes empty.
    if (this.board[fromRow][fromCol].equals("O") && this.board[toRow][toCol].equals("_")) {

      if ((fromRow + 2 == toRow) && (this.board[fromRow + 1][fromCol].equals("O"))
              && fromCol == toCol) {

        this.board[fromRow][fromCol] = "_";
        this.board[toRow][toCol] = "O";

        this.board[fromRow + 1][fromCol] = "_";
      } else if ((fromRow - 2 == toRow) && (this.board[fromRow - 1][fromCol].equals("O"))
                      && fromCol == toCol) {

        this.board[fromRow][fromCol] = "_";
        this.board[toRow][toCol] = "O";

        // the r/c the marble "skipped" over becomes empty.
        this.board[fromRow - 1][fromCol] = "_";
      } else if ((fromCol + 2 == toCol) && (this.board[fromRow][fromCol + 1].equals("O"))
                      && fromRow == toRow) {

        this.board[fromRow][fromCol] = "_";
        this.board[toRow][toCol] = "O";

        this.board[fromRow][fromCol + 1] = "_";
      } else if ((fromCol - 2 == toCol) && (this.board[fromRow][fromCol - 1].equals("O"))
                      && fromRow == toRow) {

        this.board[fromRow][fromCol] = "_";
        this.board[toRow][toCol] = "O";

        this.board[fromRow][fromCol - 1] = "_";
      } else {

        throw new IllegalArgumentException("more than one apart");
      }

    }
  }

  /**
   * This private function is not intended to be called by any outside classes. It is used by the
   * isGameOver function only. The logic is nearly identical to the isMove function but instead of
   * moving anything, the function returns false if any of the four conditions (up, down, right,
   * left) are met, meaning the game is not over. It tests every possible marble move. False is then
   * used by isGameOver. Note that the function returns true if none of the conditions are met but
   * "true" in that case only means that the current from--> to being evaluated would mean the game
   * is over IF NOT FOR the fact that there are also other from--> to positions to evaluate which
   * may trigger false.
   *
   * @returns boolean.
   */
  private boolean isGameOverHelper(int fromRow, int fromCol, int toRow, int toCol) {

    if (this.board[fromRow][fromCol].equals("O") && this.board[toRow][toCol].equals("_")) {

      if ((fromRow + 2 == toRow) && (this.board[fromRow + 1][fromCol].equals("O"))
              && fromCol == toCol) {
        return false;
      } else if ((fromRow - 2 == toRow) && (this.board[fromRow - 1][fromCol].equals("O"))
                      && fromCol == toCol) {
        return false;
      } else if ((fromCol + 2 == toCol) && (this.board[fromRow][fromCol + 1].equals("O"))
                      && fromRow == toRow) {

        return false;

      } else if ((fromCol - 2 == toCol) && (this.board[fromRow][fromCol - 1].equals("O"))
                      && fromRow == toRow) {
        return false;
      }
    }
    return true;
  }

  /**
   * This function looks at the current board and checks where each space can move if it has a
   * mable.
   *
   * @returns boolean.
   */
  public boolean isGameOver() {

    int ir = 0; // row iterator
    int ic = 0; // col iterator
    while (ir < r) {
      ic = 0; // sets ic back to 0 each time ir increases by one.
      while (ic < c) {
        for (int row = 0; row < r; row++) {
          for (int col = 0; col < c; col++) {
            boolean over = isGameOverHelper(row, col, ir, ic);
            if (!over) {
              return false; // game isnt over helper says a move was possible/remaining.
            }
          }
        }
        ic += 1;
      }
      ir += 1;
    }
    return true; // note true is only returned after every possibility is checked despite
    // the value of over ever being true.
  }


  /**
   * Determines score by iterating through board and counting marbles.
   *
   * @returns int the score (amount of marbles on board, lower better).
   */
  public int getScore() {
    int score = 0;

    for (int row = 0; row < r; row++) {
      for (int col = 0; col < c; col++) {
        if (board[row][col].equals("O")) {
          score += 1;
        }
      }

    }
    return score;
  }

  /**
   * Calling function will depict the board as a string. This function creates a string theString,
   * iterates through the board, and stuffs the current position into the string before returning
   * the stirng.
   *
   * @returns string, the board's current state as as string.
   */
  public String getGameState() {
    String theString = "";

    for (int row = 0; row < r; row++) {
      for (int col = 0; col < c; col++) {
        // empty left corners.
        if ((row < armThickness - 1 && col < armThickness - 1) ||

                (row > r - armThickness && col < armThickness - 1)
        ) {
          theString += " " + " "; // same as this.board[row][col] + " "

        }
        // empty right corners.
        else if ((row < armThickness - 1 && col > c - armThickness) ||

                (row > r - armThickness && col > c - armThickness)
        ) {
          theString += "";

        }
        // last column (but not corner)
        else if (col == c - 1) {
          theString += this.board[row][col] + "";
        }
        // column before start of right corners.
        else if (col == c - armThickness && (row < armThickness - 1 || row > r - armThickness)) {
          theString += this.board[row][col] + "";

        }

        // the plus sign minus the column before start of right corners.
        else {
          theString += this.board[row][col] + " ";
        }

        if (col == r - 1 && row < r - 1) {
          theString += "\n";
        }
      }
    }
    return theString;
  }
}

