package com.chessgame;

import com.chessgame.Board;
import com.chessgame.Cell;
import com.chessgame.GamePiece;
import com.chessgame.Constants;

public class Rook extends GamePiece {

    public Rook(Constants.Color color, int id){
        super(color, Constants.GamePieceName.ROOK, id);
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
