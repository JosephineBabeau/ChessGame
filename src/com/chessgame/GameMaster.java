package com.chessgame;

public class GameMaster {

    final RuleEngine ruleEngine;
    final Board board;

    Constants.GameStatuses gameStatuses;
    Constants.PlayerStatus playerStatus;

    // White play first - color is initialized on Black
    Constants.Color lastTurnColor = Constants.Color.BLACK;

    public Constants.GameStatuses getGameStatuses() {
        return gameStatuses;
    }

    public Constants.PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public GameMaster(Board board, RuleEngine ruleEngine) {
        this.board = board;
        this.ruleEngine = ruleEngine;
    }

    public void startNewGame() {
        ruleEngine.setUpBoard(board);

    }

    public Constants.MakeMoveStatuses makeMove(Cell start, Cell end, Constants.Color color) {
        // a player's turn ends when a piece moves.
        Constants.MakeMoveStatuses status;
        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start, end, color, lastTurnColor);
        status = result.getMakeMoveStatuses();

        if(status != Constants.MakeMoveStatuses.MOVE_IS_VALID) return status;

        playerStatus = result.getPlayerStatus();

        lastTurnColor = color;

        return status;
    }
}
