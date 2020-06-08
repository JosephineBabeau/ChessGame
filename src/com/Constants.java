package com;

public class Constants {

    public enum GamePieceName {
        KING,
        QUEEN,
        BISHOP,
        ROOK,
        KNIGHT,
        PAWN,
    }

    public enum Color {
        WHITE,
        BLACK,
    }

    public enum MakeMoveStatuses {
        OUT_OF_BOUND,
        NO_PIECE_SELECTED,
        CANT_MOVE_OPPONENT_PIECE,
        UNAUTHORIZED_MOVE,
        CANNOT_ATTACK_OWN_PIECES,
        YOU_ARE_IN_CHECK,
        MOVE_IS_VALID,
        NOT_YOUR_TURN_TO_PLAY,
    }
    public enum PlayerStatus {
        BLACK_PLAYER_IN_CHECK,
        WHITE_PLAYER_IN_CHECK,
        NO_STATUS,
        BLACK_PLAYER_WINS,
        WHITE_PLAYER_WINS,
        DRAW,
    }
    public enum GameStatuses {
        WAITING_FOR_PLAYERS,
        RUNNING,
        PAUSED,
    }
}

