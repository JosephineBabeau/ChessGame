package com.chessgame;

public abstract class GamePiece {
    final private Constants.GamePieceName name;
    final private Constants.Color color;
    final private int id;

    public int getId() {
        return id;
    }

    protected GamePiece(Constants.Color color, Constants.GamePieceName name, int id){
        this.color = color;
        this.name = name;
        this.id = id;
    }

    public Constants.GamePieceName getName(){

        return name;
    }
    protected abstract boolean canMoveToDest(Board board, Cell start, Cell end);

    public Constants.Color getColor() {

        return color;
    }


}
