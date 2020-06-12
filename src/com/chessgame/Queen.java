package com.chessgame;

import com.chessgame.Board;
import com.chessgame.Cell;
import com.chessgame.GamePiece;
import com.chessgame.Constants;

public class Queen extends GamePiece {
    public Queen(Constants.Color color, int id){
        super(color, Constants.GamePieceName.QUEEN, id);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Queen can move diagonally
        if(Math.abs(j - c) == Math.abs(i - r)){
            return true;
        }

        // Queen can move in straight line
        if(Math.abs(i - r) == 0){
            return true;
        }

        return Math.abs(j - c) == 0;
    }
}
