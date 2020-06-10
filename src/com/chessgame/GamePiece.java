package com.chessgame;

public abstract class GamePiece {
    private Constants.GamePieceName name;
    private Constants.Color color;
    private int id;

    protected GamePiece(Constants.Color color, Constants.GamePieceName name, int id){
        this.color = color;
        this.name = name;
    }

    protected Constants.GamePieceName getName(){

        return name;
    }
    protected abstract boolean canMoveToDest(Board board, Cell start, Cell end);

    protected Constants.Color getColor() {

        return color;
    }

}
