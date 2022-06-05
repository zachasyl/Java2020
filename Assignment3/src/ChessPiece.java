
/**
 * This interface contains all public operations that all chess pieces should support.
 */


public interface ChessPiece {
  // she board size, representing max rows and max columns.
  int boardSize = 7;

  /**
   * Computes and returns row this piece is on.
   *
   * @return int row 0-7.
   */
  int getRow();

  /**
   * Computes and returns column the piece is on.
   *
   * @returns byte row 0-7.
   */
  int getColumn();

  /**
   * Computes and returns color of the piece, black or white.
   *
   * @returns BlackOrWhite enum color either BlackOrWHite.BLACK or BlackOrWhite.WHITE.
   */
  Color getColor();


  /**
   * Determines if piece can move to given cell. This relies on moveDiagonal, moveHorizontal, and
   * moveVertical for certain pieces.
   *
   * @param row the row we determine if piece can move to.
   * @param col the column we determine if piece can move to.
   * @returns boolean. True if can move to cell.
   */
  boolean canMove(int row, int col);

  /**
   * Determines if piece can capture another piece. This relies on moveDiagonal, moveHorizontal, and
   * moveVertical for certain pieces. Param piece we determine if our piece can kill. The target
   * chess piece is an object with a row and column.
   *
   * @returns boolean. True if can move to cell and capture or capture(in the case of the pawn).
   */
  boolean canKill(ChessPiece piece);
  
  /**
   * Determines all diagonals available to a piece that can move diagonally.
   *
   * @returns Boolean, true if the square is diagonal from piece.
   */
  boolean moveDiagonal(int row, int column);

  /**
   * Determines all diagonals available to a piece that can move horizontally.
   *
   * @returns Boolean, true if the square is horizontal from piece.
   */
  boolean moveHorizontal(int row, int column);

  /**
   * Determines all diagonals available to a piece that can move vertically.
   *
   * @returns Boolean, true if the square is vertical from piece.
   */
  boolean moveVertical(int row, int column);


}