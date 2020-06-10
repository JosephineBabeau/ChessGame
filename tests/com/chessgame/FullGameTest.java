package com.chessgame;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.mockito.Mock;


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
        queenW = new Queen(Constants.Color.WHITE, 0);
        queenB = new Queen(Constants.Color.BLACK, 0);
        kingW = new King(Constants.Color.BLACK, 0);
        kingB = new King(Constants.Color.BLACK, 0);
        bishopB1 = new Bishop(Constants.Color.BLACK, 0);
        bishopB2 = new Bishop(Constants.Color.BLACK, 0);
        knightB1 = new Knight(Constants.Color.BLACK, 0);
        knightB2 = new Knight(Constants.Color.BLACK, 0);
        knightW1 = new Knight(Constants.Color.WHITE, 0);
        knightW2 = new Knight(Constants.Color.WHITE, 0);
        rookB1 = new Rook(Constants.Color.BLACK, 0);
        rookB2 = new Rook(Constants.Color.BLACK, 0);
        rookW1 = new Rook(Constants.Color.WHITE, 0);
        rookW2 = new Rook(Constants.Color.WHITE, 0);
        pawnW1 = new Pawn(Constants.Color.WHITE, 0);
        pawnW2 = new Pawn(Constants.Color.WHITE,0);
        pawnW3 = new Pawn(Constants.Color.WHITE, 0);
        pawnW4 = new Pawn(Constants.Color.WHITE, 0);
        pawnW5 = new Pawn(Constants.Color.WHITE, 0);
        pawnW6 = new Pawn(Constants.Color.WHITE, 0);
        pawnW7 = new Pawn(Constants.Color.WHITE, 0);
        pawnW8 = new Pawn(Constants.Color.WHITE, 0);
        pawnB1 = new Pawn(Constants.Color.BLACK, 0);
        pawnB2 = new Pawn(Constants.Color.BLACK, 0);
        pawnB3 = new Pawn(Constants.Color.BLACK, 0);
        pawnB4 = new Pawn(Constants.Color.BLACK, 0);
        pawnB5 = new Pawn(Constants.Color.BLACK, 0);
        pawnB6 = new Pawn(Constants.Color.BLACK, 0);
        pawnB7 = new Pawn(Constants.Color.BLACK, 0);
        pawnB8 = new Pawn(Constants.Color.BLACK, 0);

    }



}
