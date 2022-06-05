

/**
 * This class represents a bishop. It offers all operations of the ChessPiece interface.
 */
public class Rook extends AbstractChessPiece {


  /**
   * Construct a Bishop object.
   *
   * @param row    the row of bishop, 0-7, byte.
   * @param column the column of bishop, 0-7, byte.
   * @param color  the color, BlackOrWhite.
   */

  public Rook(int row, int column, Color color) {
    super(row, column, color);

  }


  @Override
  public boolean canMove(int row, int col) {
    return (moveHorizontal(row, col) || moveVertical(row, col));
  }
}






