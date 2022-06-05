/**
 * This abstract class represents a hypothetical chess piece. It offers all operations of the
 * ChessPiece interface.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  /**
   * AbstractChessPiece / all chess pieces have a color, row and column.
   */
  protected Color color;
  protected int row;
  protected int column;

  /**
   * Construct a AbstractChessPiece with the provided parameters int row, int column and  enum
   * BlackOrWhite color. An IllegalArgumentException is thrown if a piece is created off the board.
   * Note that this is an abstract class and an object cannot be created from its constructor.
   *
   * @param row    row of piece, 0-7.
   * @param column column of piece, 0-7.
   * @param color  color of piece, black or white.
   */
  public AbstractChessPiece(int row, int column, Color color) {
    this.row = row;
    this.column = column;
    this.color = color;

    if (row < 0 || row > boardSize || column < 0 || column > boardSize) {
      throw new IllegalArgumentException("Piece must be created on the board");
    }
  }

  // NOTE THAT THE JAVADOCS FOR THE FOLLOWING ARE AVAILABLE IN INTERFACE.


  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  public Color getColor() {
    return this.color;
  }

  /**
   * Determines if piece can capture another piece. This relies on moveDiagonal, moveHorizontal, and
   * moveVertical for certain pieces. parameter is piece.
   *
   * @returns boolean. True if can move to cell and capture or capture(in the case of the pawn).
   */
  public boolean canKill(ChessPiece piece) {
    // If the piece can move to the row and column of the other piece, it
    // can kill it. This is overridden for the pawn.
    return ((this.canMove(piece.getRow(), piece.getColumn()))
            && (this.getColor() != piece.getColor()));
  }

  /**
   * Determines if square is diagonal from piece. Utilized by queen and bishop.
   *
   * @returns Boolean, true if the square is diagonal from bishop.
   */
  public boolean moveDiagonal(int row, int column) {

    for (int i = 1; i <= boardSize; i++) {
      if ((row == this.row - i) && (column == this.column - i)) {
        return true;
      } else if ((row == this.row + i) && (column == this.column + i)) {
        return true;
      } else if ((row == this.row - i) && (column == this.column + i)) {
        return true;
      } else if ((row == this.row + i) && (column == this.column - i)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines if square is horizontal from piece. used by rook and queen.
   *
   * @returns Boolean, true if the square is horitzontal.
   */
  public boolean moveHorizontal(int row, int column) {
    return ((row == this.row) && (row <= 7 && row >= 0));
  }

  /**
   * Determines if square is vertical from piece. Utilized by queen and rook.
   *
   * @returns Boolean, true if the square is vertical from piece.
   */
  public boolean moveVertical(int row, int column) {
    return ((column == this.column) && (column <= 7 && column >= 0));
  }
}





