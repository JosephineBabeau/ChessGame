package com.chessgame;

public class FactoryGameMaster {

    public static GameMaster getGameMaster() {
        Board board = new Board();
        MoveChecker moveChecker = new MoveChecker();
        return new GameMaster(board, new RuleEngine(moveChecker));
    }
}
