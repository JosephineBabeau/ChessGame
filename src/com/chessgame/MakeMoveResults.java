package com.chessgame;

public class MakeMoveResults {

    private Constants.MakeMoveStatuses makeMoveStatuses = null;
    private Constants.PlayerStatus playerStatus = null;

    protected Constants.MakeMoveStatuses getMakeMoveStatuses() {
        return makeMoveStatuses;
    }

    protected void setMakeMoveStatuses(Constants.MakeMoveStatuses makeMoveStatuses) {
        this.makeMoveStatuses = makeMoveStatuses;
    }

    protected Constants.PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    protected void setPlayerStatus(Constants.PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }



}
