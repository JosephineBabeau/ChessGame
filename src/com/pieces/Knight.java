package com.pieces;

import com.Board;
import com.Cell;
import com.GamePiece;
import com.Constants;

public class Knight extends GamePiece {
    public Knight(Constants.Color color){
        super(color, Constants.GamePieceName.KNIGHT);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Knight has a max of 8 possible moves
        if((Math.abs(j - c)) + (Math.abs(i - r)) != 3) return false;

        return true;
    }
}
