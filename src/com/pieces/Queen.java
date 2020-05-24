package com.pieces;

import com.Board;
import com.Cell;
import com.GamePiece;
import com.PiecesName;

public class Queen extends GamePiece {
    public Queen(boolean color){
        super(color, PiecesName.QUEEN);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Queen can move diagonally
        if(Math.abs(j - c) == Math.abs(i - r)) return true;

        // Queen can move in straight line
        if(Math.abs(i - r) == 0) return true;
        if(Math.abs(j - c) == 0) return true;

        return false;
    }
}
