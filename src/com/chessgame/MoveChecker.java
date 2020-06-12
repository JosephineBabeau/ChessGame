package com.chessgame;
import java.util.LinkedList;

import static com.chessgame.Constants.PlayerStatus.*;

public class MoveChecker {

    public Constants.PlayerStatus isPlayerInCheck(final Board board)
    {
        Constants.PlayerStatus status = NO_STATUS;

        // get the kings, to verify if a player is in 'check' state
        Cell kingWhite = new Cell();
        Cell kingBlack = new Cell();
        getKings(board, kingWhite, kingBlack);

        LinkedList<Cell> attackingBlackKing;
        LinkedList<Cell> attackingWhiteKing;
        attackingBlackKing = isCheck(board, kingBlack);
        attackingWhiteKing = isCheck(board, kingWhite);

        if(!attackingBlackKing.isEmpty()) status = BLACK_PLAYER_IN_CHECK;
        if(!attackingWhiteKing.isEmpty()) status = WHITE_PLAYER_IN_CHECK;

        return status;
    }

    // helper function to get position of both kings (to populate cell "pos"). 
    // This will be used to verify if a player is in check.
    private void getKings(final Board board, final Cell kingWhite, final Cell kingBlack) {
        LinkedList<Cell> kingList;
        kingList = board.getPiecesByType(Constants.GamePieceName.KING);

        Cell tmpKingWhite = kingList.removeFirst();
        Cell tmpKingBlack = kingList.removeFirst();

        if(board.getPiece(tmpKingBlack).getColor() == Constants.Color.WHITE){
            Cell temp = tmpKingWhite;
            tmpKingWhite = tmpKingBlack;
            tmpKingBlack = temp;
        }

        kingWhite.copy(tmpKingWhite);
        kingBlack.copy(tmpKingBlack);
    }

    // This function verifies if the player's King is in check. 
    // The linkedList contains all enemy pieces that can attack the king.
    private LinkedList<Cell> isCheck(final Board board, final Cell pos) {
        // pos: position of a King on the board

        LinkedList<Cell> attackingPieces = new LinkedList<>();
        Constants.Color color = board.getPiece(pos).getColor();

        // Verify diagonals for enemy pieces
        int[][] moveDiagonal = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1}};
        int[][] moveLine = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        // 'isCheckForLinesAndDiagonals' verifies is there are any threats on lines and/or diagonals,
        // that could attack the king (i.e. is the king in check).
        isCheckForLinesAndDiagonal(board, pos, color, attackingPieces, moveDiagonal, true);
        isCheckForLinesAndDiagonal(board, pos, color, attackingPieces, moveLine, false);

        // Verify diagonals for pawn
        int i = pos.getRow();
        int j = pos.getCol();

        GamePiece piece;

        // Verify if diagonal move is permitted for a pawn
        Cell diagonalLeft;
        Cell diagonalRight;
        if(color == Constants.Color.WHITE) {
            diagonalLeft = new Cell(i + 1, j - 1);
            diagonalRight = new Cell(i + 1, j + 1);
        } else{ // same checks as above, but for black (color == Constants.Color.BLACK)
            diagonalLeft = new Cell(i - 1, j - 1);
            diagonalRight = new Cell(i - 1, j + 1);
        }
        isCheckPawn(board, diagonalLeft,color, attackingPieces);
        isCheckPawn(board, diagonalRight, color, attackingPieces);

        // Is there an enemy knight that could take the king (8 possible cells)
        int [][] moveKnight = new int[][]{{2, -1},{2, 1},{1, -2},{1, 2},{-1, 2},{-2, 1},{-2, -1},{-1, -2}};
        for(int[] move: moveKnight) {
            Cell knight = new Cell(i + move[0], j + move[1]);

            if(board.isCellValid(knight)) {
                piece = board.getPiece(knight);
                if ((piece != null) &&
                        (piece.getName() == Constants.GamePieceName.KNIGHT) &&
                        (piece.getColor() != color)) {
                    attackingPieces.addLast(knight);
                }
            }
        }
        return attackingPieces;
    }
    
    // helper function supporting isCheck. Verifies if a pawn could attack the player's King.
    private void isCheckPawn(final Board board,
                             final Cell diagonal,
                             final Constants.Color color,
                             LinkedList<Cell> attackingPieces)
    {
        GamePiece piece;

        if (board.isCellValid(diagonal)) {
            piece = board.getPiece(diagonal);
            if ((piece != null) &&
                    (piece.getName() == Constants.GamePieceName.PAWN) &&
                    (piece.getColor() != color)) {
                attackingPieces.addLast(diagonal);
            }
        }
    }
    // helper function supporting isCheck. Verifies if an enemy piece moving in diagonal,
    // (like Bishops or Queen) could attack the player's King.
    private void isCheckForLinesAndDiagonal(final Board board,
                                            final Cell pos,
                                            final Constants.Color color,
                                            LinkedList<Cell> attackingPieces,
                                            final int[][] moves,
                                            final boolean isDiagonal){

        Constants.GamePieceName threat;
        // Bishop for diagonal, Rook to check for lines
        threat = (isDiagonal) ? Constants.GamePieceName.BISHOP : Constants.GamePieceName.ROOK;

        for (int[] move : moves) {
            int i = pos.getRow() + move[0];
            int j = pos.getCol() + move[1];

            while ((Math.max(i, j) < board.getColSize()) && (Math.min(i, j) >= 0)) {
                Cell cell = new Cell(i, j);
                GamePiece piece = board.getPiece(cell);

                if (piece != null) {
                    if (((piece.getName() == threat) ||
                            (piece.getName() == Constants.GamePieceName.QUEEN)) &&
                            (color != piece.getColor())) {
                        attackingPieces.addLast(cell);
                    }
                    break;
                }
                i = i + move[0];
                j = j + move[1];
            }
        }
    }
}
