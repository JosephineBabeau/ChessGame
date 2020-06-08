package com;

import com.*;
import com.pieces.*;

import static com.Constants.GamePieceName.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static com.Constants.MakeMoveStatuses.*;
import static com.Constants.PlayerStatus.*;



public class FullGameTest {
    //all game pieces
    GamePiece queenW;
    GamePiece queenB;
    GamePiece kingW;
    GamePiece kingB;
    GamePiece bishopB1;
    GamePiece bishopB2;
    GamePiece knightB1;
    GamePiece knightB2;
    GamePiece knightW1;
    GamePiece knightW2;
    GamePiece rookB1;
    GamePiece rookB2;
    GamePiece rookW1;
    GamePiece rookW2;
    GamePiece pawnW1;
    GamePiece pawnW2;
    GamePiece pawnW3;
    GamePiece pawnW4;
    GamePiece pawnW5;
    GamePiece pawnW6;
    GamePiece pawnW7;
    GamePiece pawnW8;
    GamePiece pawnB1;
    GamePiece pawnB2;
    GamePiece pawnB3;
    GamePiece pawnB4;
    GamePiece pawnB5;
    GamePiece pawnB6;
    GamePiece pawnB7;
    GamePiece pawnB8;

    Board board;

    @Mock
    GamePiece mockPiece = mock(GamePiece.class);
    @Mock
    MoveChecker mockMoveCheck = mock(MoveChecker.class);

    RuleEngine ruleEngine =  new RuleEngine(mockMoveCheck);

    @Before
    public void initialize() {
        board = new Board();
        queenW = new Queen(Constants.Color.WHITE);
        queenB = new Queen(Constants.Color.BLACK);
        kingW = new King(Constants.Color.BLACK);
        kingB = new King(Constants.Color.BLACK);
        bishopB1 = new Bishop(Constants.Color.BLACK);
        bishopB2 = new Bishop(Constants.Color.BLACK);
        knightB1 = new Knight(Constants.Color.BLACK);
        knightB2 = new Knight(Constants.Color.BLACK);
        knightW1 = new Knight(Constants.Color.WHITE);
        knightW2 = new Knight(Constants.Color.WHITE);
        rookB1 = new Rook(Constants.Color.BLACK);
        rookB2 = new Rook(Constants.Color.BLACK);
        rookW1 = new Rook(Constants.Color.WHITE);
        rookW2 = new Rook(Constants.Color.WHITE);
        pawnW1 = new Pawn(Constants.Color.WHITE);
        pawnW2 = new Pawn(Constants.Color.WHITE);
        pawnW3 = new Pawn(Constants.Color.WHITE);
        pawnW4 = new Pawn(Constants.Color.WHITE);
        pawnW5 = new Pawn(Constants.Color.WHITE);
        pawnW6 = new Pawn(Constants.Color.WHITE);
        pawnW7 = new Pawn(Constants.Color.WHITE);
        pawnW8 = new Pawn(Constants.Color.WHITE);
        pawnB1 = new Pawn(Constants.Color.BLACK);
        pawnB2 = new Pawn(Constants.Color.BLACK);
        pawnB3 = new Pawn(Constants.Color.BLACK);
        pawnB4 = new Pawn(Constants.Color.BLACK);
        pawnB5 = new Pawn(Constants.Color.BLACK);
        pawnB6 = new Pawn(Constants.Color.BLACK);
        pawnB7 = new Pawn(Constants.Color.BLACK);
        pawnB8 = new Pawn(Constants.Color.BLACK);

    }
    @Test
    public void boardSetUpWhite() throws Exception {
        Constants.GamePieceName pieces[] =
                new Constants.GamePieceName[]{ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
        ruleEngine.setUpBoard(board);

        for(int i = 0; i < pieces.length; i++) {
            assertEquals(pieces[i], board.getPiece(new Cell(0, i)).getName());
            assertEquals(PAWN, board.getPiece(new Cell(1, i)).getName());
        }
    }

    @Test
    public void boardSetUpBlack() throws Exception {
        Constants.GamePieceName pieces[] =
                new Constants.GamePieceName[]{ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
        ruleEngine.setUpBoard(board);

        for(int i = 0; i < pieces.length; i++) {
            assertEquals(pieces[i], board.getPiece(new Cell(7, i)).getName());
            assertEquals(PAWN, board.getPiece(new Cell(6, i)).getName());
        }
    }


}
