package com.chessgame;

import com.chessgame.Board;
import com.chessgame.Cell;
import com.chessgame.GamePiece;
import com.chessgame.Constants;

public class Knight extends GamePiece {
    public Knight(Constants.Color color, int id){
        super(color, Constants.GamePieceName.KNIGHT, id);
    }

    @Override
    public boolean canMoveToDest(Board board, Cell start, Cell end) {

        int j = start.getCol();
        int i = start.getRow();

        int r = end.getRow();
        int c = end.getCol();

        // Knight has a max of 8 possible moves
        if((Math.abs(j - c)) + (Math.abs(i - r)) == 3){
            return (Math.abs(j - c) <= 2)
                    && (Math.abs(i - r)) <= 2;
        }
        return false;
    }
}
