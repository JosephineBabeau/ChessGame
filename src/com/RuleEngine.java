package com;

public class RuleEngine {

    /*makeMove
        - validates that a cell contains a piece
        - deal with pieces blocking the way
        - deal with "attack"
        - removes pieces and put in prison


     */

    public boolean makeMove(Board board, Cell start, Cell end, boolean playerColor) {
        if(! board.isCellValid(start)) return false;
        if(! board.isCellValid(end)) return false;

        if(board.isEmpty(start)) return false;

        GamePiece pieceAtStart = board.getPiece(start);
        if(pieceAtStart.color() != playerColor) return false;

        // Piece at end should not be of the same color
        GamePiece pieceAtEnd = board.getPiece(end);
        if(pieceAtEnd.color() == playerColor) return false;

        if(!pieceAtStart.canMoveToDest(board, start, end)) return false;

        // verify blocking the way

        // verify is move sets flag 'Check' to true


        return true;
    }

    //getEvent (check, checkmate...)
}
