package com.pieces;

import com.Board;
import com.Cell;
import com.GamePiece;
import com.PiecesName;

public class King extends GamePiece {
    // Initialize color() as well as its name

    public King(boolean color){
        super(color, PiecesName.KING);
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
