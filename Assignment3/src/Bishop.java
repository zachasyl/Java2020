

/**
 * This class represents a bishop. It offers all operations of the ChessPiece interface.
 */
public class Bishop extends AbstractChessPiece {
  /**
   * Construct a Bishop object.
   *
   * @param row    the row of bishop, 0-7, byte.
   * @param column the column of bishop, 0-7, byte.
   * @param color  the color, BlackOrWhite.
   */
  public Bishop(int row, int column, Color color) {
    super(row, column, color);

  }

  /**
   * Determines if square is diagonal from bishop by utilizing moveDiagonal.
   *
   * @returns Boolean, true if the square is diagonal from bishop.
   */
  public boolean canMove(int row, int column) {
    return (moveDiagonal(row, column));
  }
}




