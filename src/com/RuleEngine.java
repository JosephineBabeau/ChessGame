package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RuleEngine {

    /*makeMove
        - validates that a cell contains a piece
        - verifies if the king is in check

        - removes pieces and put it in prison

     */

    public boolean makeMove(Board board, Cell start, Cell end, Constants.Color playerColor) {
        // validate if cells are within boundaries of the board
        if(! board.isCellValid(start)) return false;
        if(! board.isCellValid(end)) return false;

        // a piece must be selected to initiate a move
        if(board.isEmpty(start)) return false;

        // a player must select their own pieces
        GamePiece pieceAtStart = board.getPiece(start);
        if(pieceAtStart.getColor() != playerColor) return false;

        // a player can't attack its own pieces.
        // Piece at end destination should not be of the same color
        GamePiece pieceAtEnd = board.getPiece(end);
        if(pieceAtEnd.getColor() == playerColor) return false;

        // check authorized move for the chess piece in the start cell
        if(!pieceAtStart.canMoveToDest(board, start, end)) return false;

        //Execute move
        board.setPiece(end, pieceAtStart);
        board.setPiece(start, null);
        //is move putting player in check
        if(isPlayerInCheck(board, playerColor, start, end))
        {
            //backtrack
            board.setPiece(end, pieceAtEnd);
            board.setPiece(start, pieceAtStart);
            return false;
        }

        //Is opposite king in check

        return true;
    }

    private boolean isPlayerInCheck(Board board, Constants.Color playerColor, Cell start, Cell end)
    {
        GamePiece pieceAtStart = board.getPiece(start);
        GamePiece pieceAtEnd = board.getPiece(end);

        // get the kings, to verify if a player is in 'check' state
        Cell kingWhite = new Cell();
        Cell kingBlack = new Cell();
        getKings(board, kingWhite, kingBlack);

        LinkedList<Cell> attackingBlackKing;
        LinkedList<Cell> attackingWhiteKing;
        attackingBlackKing = isCheck(board, kingBlack);
        attackingWhiteKing = isCheck(board, kingWhite);

        // backtrack if, after the move, the player is still in 'check' status
        if((playerColor == Constants.Color.BLACK) && (!attackingBlackKing.isEmpty())) {
            board.setPiece(end, pieceAtEnd);
            board.setPiece(start, pieceAtStart);
            return false;
        } else if((playerColor == Constants.Color.WHITE) && (!attackingWhiteKing.isEmpty())) {
            board.setPiece(end, pieceAtEnd);
            board.setPiece(start, pieceAtStart);
            return false;
        }

        return true;
    }

    // helper function to get position of both kings (to populate "pos")
    private void getKings(Board board, Cell kingWhite, Cell kingBlack) {
        LinkedList<Cell> kingList;
        kingList = board.getPiecesByType(Constants.GamePieceName.KING);

        Cell tmpkingWhite = kingList.removeFirst();
        Cell tmpkingBlack = kingList.removeFirst();

        if(board.getPiece(tmpkingBlack).getColor() == Constants.Color.WHITE){
            Cell temp = tmpkingWhite;
            tmpkingWhite = tmpkingBlack;
            tmpkingBlack = temp;
        }

        kingWhite.copy(tmpkingWhite);
        kingBlack.copy(tmpkingBlack);
    }


    private LinkedList<Cell> isCheck(Board board, Cell pos) {
        // This function verifies if the King is in check.
        // pos: position of a King on the board

        LinkedList<Cell> attackingPieces = new LinkedList<>();
        Constants.Color color = board.getPiece(pos).getColor();

        // Verify diagonals for enemy pieces
        int[][] moveDiag = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1}};
        int[][] moveLine = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        // 'isCheckForLinesAndDiag' verifies is there are any threats on lines and/or diagonals,
        // that could attack the king (i.e. is the king in check).
        isCheckForLinesAndDiag(board, pos, color, attackingPieces, moveDiag, true);
        isCheckForLinesAndDiag(board, pos, color, attackingPieces, moveLine, false);

        // Verify diagonals for pawn
        int i = pos.getRow();
        int j = pos.getCol();

        GamePiece piece;

        // Verify if diag move is permitted for a pawn
        Cell diagLeft;
        Cell diagRight;
        if(color == Constants.Color.WHITE) {
            diagLeft = new Cell(i + 1, j - 1);
            diagRight = new Cell(i + 1, j + 1);
        } else{ // same checks as above, but for black (color == Constants.Color.BLACK)
            diagLeft = new Cell(i - 1, j - 1);
            diagRight = new Cell(i - 1, j + 1);
        }
        isCheckPawn(board, diagLeft,color, attackingPieces);
        isCheckPawn(board, diagRight, color, attackingPieces);

        // Is there an enemy knight that could take the king (8 possible cells)
        int [][] moveKnight = new int[][]{{2, -1},{2, 1},{1, -2},{1, 2},{-1, 2},{-2, 1},{-2, -1},{-1, -2}};
        for(int[] move: moveKnight) {
            Cell knight = new Cell(i + move[0], j + move[1]);

            if(board.isCellValid(knight)) {
                piece = board.getPiece(knight);
                if ((piece.getName() == Constants.GamePieceName.KNIGHT) && (piece.getColor() != color)) {
                    attackingPieces.addLast(knight);
                }
            }
        }
        return attackingPieces;
    }

    private void isCheckPawn(Board board, Cell diag, Constants.Color color, LinkedList<Cell> attackingPieces)
    {
        GamePiece piece;

        if (board.isCellValid(diag)) {
            piece = board.getPiece(diag);
            if ((piece.getName() == Constants.GamePieceName.PAWN) && (piece.getColor() != color)) {
                attackingPieces.addLast(diag);
            }
        }
    }

    private void isCheckForLinesAndDiag(Board board, Cell pos, Constants.Color color, LinkedList<Cell> attackingPieces,
                              int[][] moves, boolean isDiag){

        Constants.GamePieceName threat;
        // Bishop for diagonal, Rook to check for lines
        threat = (isDiag) ? Constants.GamePieceName.BISHOP : Constants.GamePieceName.ROOK;

        for(int k = 0; k < moves.length; k++){
            int i = pos.getRow() + moves[k][0];
            int j = pos.getCol() + moves[k][1];

            while((Math.max(i,j) < board.getColSize()) && (Math.min(i,j) >= 0)){
                Cell cell = new Cell(i,j);
                GamePiece piece = board.getPiece(cell);

                if(piece != null) {
                    if(((piece.getName() == threat) ||
                            (piece.getName() == Constants.GamePieceName.QUEEN)) &&
                            (color != piece.getColor())) {
                        attackingPieces.addLast(cell);
                        break;
                    } else break;
                }
                i = i + moves[k][0];
                j = j + moves[k][1];
            }
        }
    }

    //getEvent (check, checkmate...)
}