package com;

public class MakeMoveResults {

    private Constants.MakeMoveStatuses makeMoveStatuses = null;
    private Constants.PlayerStatus playerStatus = null;

    public Constants.MakeMoveStatuses getMakeMoveStatuses() {
        return makeMoveStatuses;
    }

    public void setMakeMoveStatuses(Constants.MakeMoveStatuses makeMoveStatuses) {
        this.makeMoveStatuses = makeMoveStatuses;
    }

    public Constants.PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(Constants.PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }



}
