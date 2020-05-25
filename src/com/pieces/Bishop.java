package com.pieces;

import com.Board;
import com.Cell;
import com.GamePiece;
import com.Constants;

public class Bishop extends GamePiece{
    public Bishop(Constants.Color color){
        super(color, Constants.GamePieceName.BISHOP);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Bishop can move diagonally
        if(Math.abs(j - c) != Math.abs(i - r)) return false;

        return true;
    }
}
