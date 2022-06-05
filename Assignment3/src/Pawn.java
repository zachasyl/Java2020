

/**
 * This class represents a bishop. It offers all operations of the ChessPiece interface.
 */
public class Pawn extends AbstractChessPiece {


  /**
   * Construct a Bishop object.
   *
   * @param row    the row of bishop, 0-7, byte.
   * @param column the column of bishop, 0-7, byte.
   * @param color  the color, BlackOrWhite.
   */

  public Pawn(int row, int column, Color color) {
    super(row, column, color);

  }

  /**
   * Determines if pawn can move to square.
   *
   * @return boolean, true if can move to square.
   */
  public boolean canMove(int row, int col) {
    if (this.color == Color.WHITE) {
      return ((row == this.row + 1) && (this.row + 1 <= 7) && (col == this.column));
    }
    // if black.
    else {
      return ((row == this.row - 1) && (this.row - 1 >= 0) && (col == this.column));

    }
  }

  /**
   * Determines if pawn can capture. This overrides the canKill method in the abstract class because
   * the pawn is the only piece that doesnt capture on squares it can move to, so its signature is
   * the same but the calculation in the method is unique.
   *
   * @return boolean, true if can capture.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.getColor() == color.WHITE) {
      return
              ((piece.getRow() == this.row + 1) && (this.color != piece.getColor())
                      && ((piece.getColumn() == this.column + 1)
                              || (piece.getColumn() == this.column - 1)));

    } else {
      return
              ((piece.getRow() == this.row - 1) && (this.color != piece.getColor())
                      && ((piece.getColumn() == this.column - 1)
                              || (piece.getColumn() == this.column + 1)));
    }
  }
}



