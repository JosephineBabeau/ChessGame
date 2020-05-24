package com.pieces;

import com.Board;
import com.Cell;
import com.GamePiece;
import com.PiecesName;

public class Rook extends GamePiece {

    public Rook(boolean color){
        super(color, PiecesName.ROOK);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Rook can only move in straight line
        if(Math.abs(i - r) == 0) return true;
        if(Math.abs(j - c) == 0) return true;

        return false;
    }
}
