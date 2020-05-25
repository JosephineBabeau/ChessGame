package com;
import com.Constants;

public abstract class GamePiece {
    protected Constants.GamePieceName name;
    protected Constants.Color color;

    public GamePiece(Constants.Color color, Constants.GamePieceName name){
        this.color = color;
        this.name = name;
    }

    public Constants.GamePieceName getName(){

        return name;
    }
    public abstract boolean canMoveToDest(Board board, Cell start, Cell end);

    public Constants.Color getColor() {

        return color;
    }

}
