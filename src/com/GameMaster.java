package com;

import static com.Constants.PlayerStatus.*;

public class GameMaster {

    RuleEngine ruleEngine;
    Board board;

    Constants.GameStatuses gameStatuses;
    Constants.PlayerStatus playerStatus;

    public Constants.GameStatuses getGameStatuses() {
        return gameStatuses;
    }

    public Constants.PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    GameMaster(Board board, RuleEngine ruleEngine) {
        this.board = board;
        this.ruleEngine = ruleEngine;
    }

    public void startNewGame() {
        ruleEngine.setUpBoard(board);
    }

    public Constants.MakeMoveStatuses makeMove(Cell start, Cell end, Constants.Color color) {
        // a player's turn ends when a piece moves.
        Constants.MakeMoveStatuses status;
        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start, end, color);
        status = result.getMakeMoveStatuses();

        if(status != Constants.MakeMoveStatuses.MOVE_IS_VALID) return status;

        playerStatus = result.getPlayerStatus();
        return status;
    }


    // fin de partie?

    // unit test globaux (des situations de jeux)
    // move checker UT

}
