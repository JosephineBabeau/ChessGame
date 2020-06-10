package com.chessgame;
import com.chessgame.Board;
import com.chessgame.Cell;
import com.chessgame.GamePiece;
import com.chessgame.Constants;

public class Pawn extends GamePiece {
    boolean hasMoved = false;

    public Pawn(Constants.Color color, int id){

        super(color, Constants.GamePieceName.PAWN, id);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Player color defines the position of the chess pieces on the board.
        // below describes the rules for a Pawn:
        // 1) it can only move forward by 1 row;
        // 2) a pawn can move by 2 rows only if it is on his starting row;
        // 3) a pawn can move in diagonal (moving forward) only
        if(super.getColor() == Constants.Color.WHITE) {
            if((c == j) && (r == i + 1)) return true;
            if((c == j) && (r == i + 2) && (start.getRow() == 1)) return true;
            if((c == j + 1) && (r == i + 1) && (board.getPiece(end).getColor() != super.getColor())) return true;
            if((c == j - 1) && (r == i + 1) && (board.getPiece(end).getColor() != super.getColor())) return true;

        } else {
            if((c == j) && (r == i - 1)) return true;
            if((c == j) && (r == i - 2) && (start.getRow() == 6)) return true;
            if((c == j + 1) && (r == i - 1) && (board.getPiece(end).getColor() != super.getColor())) return true;
            if((c == j - 1) && (r == i - 1) && (board.getPiece(end).getColor() != super.getColor())) return true;
        }

        return false;
    }


}


