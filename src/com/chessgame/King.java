package com.chessgame;

import com.chessgame.Board;
import com.chessgame.Cell;
import com.chessgame.GamePiece;
import com.chessgame.Constants;

public class King extends GamePiece {
    // Initialize color() as well as its name

    public King(Constants.Color color, int id){
        super(color, Constants.GamePieceName.KING, id);
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
