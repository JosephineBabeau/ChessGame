package com.chessgame;


import static com.chessgame.Constants.MakeMoveStatuses.*;
import static com.chessgame.Constants.PlayerStatus.*;

public class RuleEngine {
    public MoveChecker moveChecker;

    public RuleEngine(MoveChecker moveChecker) {
        this.moveChecker = moveChecker;
    }

    protected MakeMoveResults canPlayerMakeMove(Board board, Cell start, Cell end, Constants.Color playerColor,
                                             Constants.Color lastTurnColor) {

        MakeMoveResults results = new MakeMoveResults();

        // validate turn by turn
        if(lastTurnColor == playerColor) {
            results.setMakeMoveStatuses(NOT_YOUR_TURN_TO_PLAY);
            return results;
        }

        // validate if cells are within boundaries of the board
        if(! board.isCellValid(start)) {
            results.setMakeMoveStatuses(OUT_OF_BOUND);
            return results;
        }
        if(! board.isCellValid(end)) {
            results.setMakeMoveStatuses(OUT_OF_BOUND);
            return results;
        }

        // select a piece to initiate a move
        if(board.isEmpty(start)) {
            results.setMakeMoveStatuses(NO_PIECE_SELECTED);
            return results;
        }

        // verify that the player selects their own pieces
        GamePiece pieceAtStart = board.getPiece(start);
        if(pieceAtStart.getColor() != playerColor)  {
            results.setMakeMoveStatuses(CANT_MOVE_OPPONENT_PIECE);
            return results;
        }
        // a player can't attack its own pieces.
        // Piece at end destination should not be of the same color.
        // A player can however move a piece to an empty cell.
        GamePiece pieceAtEnd = board.getPiece(end);
        if(!board.isEmpty(end)) {
            if(pieceAtEnd.getColor() == playerColor)  {
                results.setMakeMoveStatuses(CANNOT_ATTACK_OWN_PIECES);
                return results;
            }
        }

        // check authorized move for the chess piece in the start cell
        if(!pieceAtStart.canMoveToDest(board, start, end)) {
            results.setMakeMoveStatuses(UNAUTHORIZED_MOVE);
            return results;
        }
        //Execute move
        board.movePiece(start, end, pieceAtStart);

        Constants.PlayerStatus playerStatus = moveChecker.isPlayerInCheck(board);
        results.setPlayerStatus(playerStatus);
        //Verify if the move is putting the player in check
        if(((playerStatus == BLACK_PLAYER_IN_CHECK)&&(playerColor == Constants.Color.BLACK))||
                ((playerStatus == WHITE_PLAYER_IN_CHECK)&&(playerColor == Constants.Color.WHITE)))
        {
            //if the move sets the player in check, perform a backtrack
            if(pieceAtEnd != null) board.setPiece(end, pieceAtEnd);
            board.setPiece(start, pieceAtStart);
            results.setMakeMoveStatuses(YOU_ARE_IN_CHECK);
            return results;
        }
        results.setMakeMoveStatuses(MOVE_IS_VALID);
        return results;
    }
    protected void setUpBoard(Board board) {

        Constants.Color[] piecesColor = new Constants.Color[2];
        piecesColor[0] = Constants.Color.WHITE;
        piecesColor[1] = Constants.Color.BLACK;
        int id = 0;

        for(Constants.Color color : piecesColor) {
            int row = color == Constants.Color.WHITE ? 0 : 7;
            board.setPiece(new Cell(row,0), new Rook(color, id++));
            board.setPiece(new Cell(row,1), new Knight(color, id++));
            board.setPiece(new Cell(row,2), new Bishop(color, id++));
            board.setPiece(new Cell(row,3), new Queen(color, id++));
            board.setPiece(new Cell(row,4), new King(color, id++));
            board.setPiece(new Cell(row,5), new Bishop(color, id++));
            board.setPiece(new Cell(row,6), new Knight(color, id++));
            board.setPiece(new Cell(row,7), new Rook(color, id++));

            row = color == Constants.Color.WHITE ? 1 : 6;
            for(int i = 0; i <= 7 ; i++){
                board.setPiece(new Cell(row,i), new Pawn(color, id++));
            }
        }
    }
}