

/**
 * This class represents a bishop. It offers all operations of the ChessPiece interface.
 */
public class Knight extends AbstractChessPiece {


  /**
   * Construct a Bishop object.
   *
   * @param row    the row of bishop, 0-7, byte.
   * @param column the column of bishop, 0-7, byte.
   * @param color  the color, BlackOrWhite.
   */

  public Knight(int row, int column, Color color) {
    super(row, column, color);

  }

  /**
   * Determines if square is one of the 8 squares available to knight.
   *
   * @returns Boolean, true if the square is available to knight.
   */
  public boolean canMove(int row, int column) {
    // the knight can move to 8 locations from its starting point.
    if ((row == this.row + 2)
            && (column == this.column + 1)
            // prevents knight from moving out of bounds. will return false if out of bounds.
            && (this.row + 2 <= 7)
            && (this.column + 1 <= 7)) {
      {
        return true;
      }
    } else if ((column == this.column + 2)
            && (row == this.row + 1)
            && (this.column + 2 <= 7)
            && (this.column + 1 <= 7)) {

      return true;
    } else if ((row == this.row - 2)
            && (column == this.column - 1)
            && (this.row - 2 >= 0)
            && (this.column - 1 >= 0)) {
      return true;
    } else if ((column == this.column - 2)
            && (row == this.row - 1)
            && (this.column - 2 >= 0)
            && (this.row - 1 >= 0)) {
      return true;
    } else if ((column == this.column + 1)
            && (row == this.row - 2)
            && (this.column + 1 >= 0)
            && (this.row - 2 >= 0)) {
      return true;
    } else if ((column == this.column + 2)
            && (row == this.row - 1)
            && (this.column + 2 >= 0)
            && (this.row - 1 >= 0)) {
      return true;
    } else if ((column == this.column - 2)
            && (row == this.row + 1)
            && (this.column - 2 >= 0)
            && (this.row + 1 >= 0)) {
      return true;
    } else {
      return ((column == this.column - 1)
              && (row == this.row + 2)
              && (this.column - 1 >= 0)
              && (this.row + 2 >= 0));
    }
  }
}









