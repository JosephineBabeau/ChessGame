package com.pieces;
import com.Board;
import com.Cell;
import com.GamePiece;
import com.PiecesName;

public class Pawn extends GamePiece {
    boolean hasMoved = false;

    public Pawn(boolean color){

        super(color, PiecesName.PAWN);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        if(Math.abs(j - c) > 1) return false;
        if(Math.abs(i - r) > 1) return false;

        return true;
    }


}


