package com.pieces;

import com.Board;
import com.Cell;
import com.GamePiece;
import com.Constants;

public class King extends GamePiece {
    // Initialize color() as well as its name

    public King(Constants.Color color){
        super(color, Constants.GamePieceName.KING);
    }

    @Override

    // King can move in all directions, by a single square
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        if(Math.abs(j - c) > 1) return false;
        return Math.abs(i - r) <= 1;
    }

}
