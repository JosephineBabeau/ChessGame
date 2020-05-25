package com;

import java.util.LinkedList;

public class RuleEngine {

    /*makeMove
        - validates that a cell contains a piece
        - deal with pieces blocking the way
        - deal with "attack"
        - removes pieces and put in prison


     */

    public boolean makeMove(Board board, Cell start, Cell end, Constants.Color playerColor) {
        if(! board.isCellValid(start)) return false;
        if(! board.isCellValid(end)) return false;

        if(board.isEmpty(start)) return false;

        GamePiece pieceAtStart = board.getPiece(start);
        if(pieceAtStart.getColor() != playerColor) return false;

        // Piece at end should not be of the same color
        GamePiece pieceAtEnd = board.getPiece(end);
        if(pieceAtEnd.getColor() == playerColor) return false;

        if(!pieceAtStart.canMoveToDest(board, start, end)) return false;

        // verify blocking the way

        // verify is move sets flag 'Check' to true


        return true;
    }

    private LinkedList<Cell> isCheck(Board board, Cell pos, Constants.Color color) {
        // pos: position of a King on the board

        LinkedList<Cell> attackingPieces = new LinkedList<>();

        // check diagonals for enemy pieces

        int[][] moveDiag = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1}};
        int[][] moveLine = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        // run isCheckForLinesAndDiag to check for threats in line, then diagonal
        isCheckForLinesAndDiag(board, pos, color, attackingPieces, moveDiag, true);
        isCheckForLinesAndDiag(board, pos, color, attackingPieces, moveLine, false);

        // check for pawn
        int i = pos.getRow();
        int j = pos.getCol();

        GamePiece piece;

        if(color == Constants.Color.WHITE) {
            Cell diagLeft = new Cell(i + 1, j - 1);
            Cell diagRight = new Cell(i + 1, j + 1);
            if (board.isCellValid(diagLeft)) {
                piece = board.getPiece(diagLeft);
                if ((piece.getName() == Constants.GamePieceName.PAWN) && (piece.getColor() != color)) {
                    attackingPieces.addLast(diagLeft);
                }
            }
            if (board.isCellValid(diagRight)) {
                piece = board.getPiece(diagRight);
                if ((piece.getName() == Constants.GamePieceName.PAWN) && (piece.getColor() != color)) {
                    attackingPieces.addLast(diagRight);
                }
            }
        }
        // simplify code and do (color == Constants.Color.BLACK)

        return xx;
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