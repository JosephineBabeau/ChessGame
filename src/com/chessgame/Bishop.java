package com.chessgame;

import com.chessgame.Board;
import com.chessgame.Cell;
import com.chessgame.GamePiece;
import com.chessgame.Constants;

public class Bishop extends GamePiece{
    public Bishop(Constants.Color color, int id){
        super(color, Constants.GamePieceName.BISHOP, id);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Bishop can move diagonally
        return Math.abs(j - c) == Math.abs(i - r);
    }
}
