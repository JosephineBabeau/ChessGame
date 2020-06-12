package com.chessgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.chessgame.Constants.PlayerStatus.*;

public class MoveCheckerTest {

    GamePiece queenW;
    GamePiece queenB;
    GamePiece bishopB;
    GamePiece bishopW;
    GamePiece pawnW;
    GamePiece knightB1;
    GamePiece knightB2;
    GamePiece knightW1;
    GamePiece knightW2;
    GamePiece kingW;
    GamePiece kingB;
    GamePiece rookW;
    GamePiece pawnB;
    Board board;

    final MoveChecker moveChecker = new MoveChecker();

    @Before
    public void initialize() {
        board = new Board();
        queenW = new Queen(Constants.Color.WHITE, 0);
        queenB = new Queen(Constants.Color.BLACK, 0);
        bishopB = new Bishop(Constants.Color.BLACK, 0);
        bishopW = new Bishop(Constants.Color.WHITE, 0);
        pawnW = new Pawn((Constants.Color.WHITE), 0);
        knightB1 = new Knight(Constants.Color.BLACK, 0);
        knightB2 = new Knight(Constants.Color.BLACK, 0);
        knightW1 = new Knight(Constants.Color.WHITE, 0);
        knightW2 = new Knight(Constants.Color.WHITE, 0);
        kingW = new King(Constants.Color.WHITE, 0);
        kingB = new King(Constants.Color.BLACK, 0);
        rookW = new Rook(Constants.Color.WHITE, 0);
        pawnB = new Pawn(Constants.Color.BLACK, 0);
    }
    @Test
    // Is player in check
    public void testIsPlayerInCheck() throws Exception {
        Cell cellKingB = new Cell(3,2);
        Cell cellKingW = new Cell(6,4);
        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);

        assertEquals(Constants.PlayerStatus.NO_STATUS, moveChecker.isPlayerInCheck(board));
    }

    @Test
    // test isCheck: multiple scenarios
    public void attackOnTheKing() throws Exception {
        //Bishop attacks the king
        Cell cellKingB = new Cell(3,2);
        Cell cellKingW = new Cell(6,4);
        Cell cellAttackingPieceW = new Cell(4,3);
        Cell cellAttackingPieceB = new Cell(2,0);

        //QueenW attacks
        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);
        board.setPiece(cellAttackingPieceW, queenW);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //QueenB attacks
        board.setPiece(cellAttackingPieceW, null);
        board.setPiece(cellAttackingPieceB, queenB);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //BishopW attacks
        board.setPiece(cellAttackingPieceB, null);
        board.setPiece(cellAttackingPieceW, bishopW);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //BishopB attacks
        board.setPiece(cellAttackingPieceW, null);
        board.setPiece(cellAttackingPieceB, bishopB);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

    }
    @Test
    // test isCheck: test for pawns: testing the 2 diagonals (possible attacks, forward)
    public void attackOnTheKingByPawns() throws Exception {
        Cell cellKingB = new Cell(2, 1);
        Cell cellAttackingPieceB = new Cell(1, 0);

        Cell cellKingW = new Cell(3, 4);
        Cell cellAttackingPieceW = new Cell(4, 3);

        //PawnB attacks
        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);
        board.setPiece(cellAttackingPieceW, pawnB);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //PawnW attacks
        board.setPiece(cellAttackingPieceW, null);
        board.setPiece(cellAttackingPieceB, pawnW);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // board cleared
        board.setPiece(cellAttackingPieceB, null);

        //PawnW attacks (other diag)
        cellAttackingPieceB = new Cell(1, 2);
        board.setPiece(cellAttackingPieceB, pawnW);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //PawnB attacks (other diag)
        board.setPiece(cellAttackingPieceB, null);
        cellAttackingPieceW = new Cell(4, 5);
        board.setPiece(cellAttackingPieceW, pawnB);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));
    }
    @Test
    // test isCheck: test for pawns: testing the 2 diagonals from which a pawn cannot attack (backward)
    public void noAttackOnKingPawn() throws Exception {
        Cell cellKingB = new Cell(2, 1);
        Cell cellAttackingPieceB = new Cell(3, 0);

        Cell cellKingW = new Cell(3, 4);
        Cell cellAttackingPieceW = new Cell(2, 3);

        //can pawnB attack?
        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);
        board.setPiece(cellAttackingPieceW, pawnB);
        assertEquals(NO_STATUS, moveChecker.isPlayerInCheck(board));

        //can pawnW attack?
        board.setPiece(cellAttackingPieceW, null);
        board.setPiece(cellAttackingPieceB, pawnW);
        assertEquals(NO_STATUS, moveChecker.isPlayerInCheck(board));

        // board clean up
        board.setPiece(cellAttackingPieceB, null);

        //can pawnW attack?
        cellAttackingPieceB = new Cell(3, 2);
        board.setPiece(cellAttackingPieceB, pawnW);
        assertEquals(NO_STATUS, moveChecker.isPlayerInCheck(board));

        //can pawnB attack?
        cellAttackingPieceW = new Cell(2, 5);
        board.setPiece(cellAttackingPieceB, null);
        board.setPiece(cellAttackingPieceW, pawnB);
        assertEquals(NO_STATUS, moveChecker.isPlayerInCheck(board));
    }
    @Test
    // test isCheck: test for knights: testing the 8 correct combinations and 2 wrong combinations
    public void attackOnKingWhiteByKnight() throws Exception {
        Cell cellKingB = new Cell(5, 2);
        Cell cellKingW = new Cell(2, 5);
        Cell cellAttackingKingWhite1 = new Cell(0, 4);
        Cell cellAttackingKingWhite2 = new Cell(0, 6);

        // 2 knights are attacking
        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);
        board.setPiece(cellAttackingKingWhite1, knightB1);
        board.setPiece(cellAttackingKingWhite2, knightB2);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingWhite1, null);
        board.setPiece(cellAttackingKingWhite2, null);
        // 2 knights are attacking
        cellAttackingKingWhite1 = new Cell(1, 3);
        cellAttackingKingWhite2 = new Cell(1, 7);
        board.setPiece(cellAttackingKingWhite1, knightB1);
        board.setPiece(cellAttackingKingWhite2, knightB2);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingWhite1, null);
        board.setPiece(cellAttackingKingWhite2, null);
        // 2 knights are attacking
        cellAttackingKingWhite1 = new Cell(3, 3);
        cellAttackingKingWhite2 = new Cell(3, 7);
        board.setPiece(cellAttackingKingWhite1, knightB1);
        board.setPiece(cellAttackingKingWhite2, knightB2);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingWhite1, null);
        board.setPiece(cellAttackingKingWhite2, null);
        // 2 knights are attacking
        cellAttackingKingWhite1 = new Cell(4, 4);
        cellAttackingKingWhite2 = new Cell(4, 6);
        board.setPiece(cellAttackingKingWhite1, knightB1);
        board.setPiece(cellAttackingKingWhite2, knightB2);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingWhite1, null);
        board.setPiece(cellAttackingKingWhite2, null);
        // only 1 knight in an attacking position (knight 2)
        cellAttackingKingWhite1 = new Cell(7, 4);
        cellAttackingKingWhite2 = new Cell(4, 6);
        board.setPiece(cellAttackingKingWhite1, knightB1);
        board.setPiece(cellAttackingKingWhite2, knightB2);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingWhite1, null);
        board.setPiece(cellAttackingKingWhite2, null);
        // both knights are not in an attacking position
        cellAttackingKingWhite1 = new Cell(2, 0);
        cellAttackingKingWhite2 = new Cell(2, 7);
        board.setPiece(cellAttackingKingWhite1, knightB1);
        board.setPiece(cellAttackingKingWhite2, knightB2);
        assertEquals(NO_STATUS, moveChecker.isPlayerInCheck(board));
    }

    @Test
    // test isCheck: test for knights: testing the 8 correct combinations
    public void attackOnKingBlackByKnight() throws Exception {
        Cell cellKingB = new Cell(5, 2);
        Cell cellKingW = new Cell(2, 5);
        Cell cellAttackingKingBlack1 = new Cell(4, 0);
        Cell cellAttackingKingBlack2 = new Cell(6, 0);

        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);

        // 2 knights are attacking
        board.setPiece(cellAttackingKingBlack1, knightW1);
        board.setPiece(cellAttackingKingBlack2, knightW2);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingBlack1, null);
        board.setPiece(cellAttackingKingBlack2, null);
        // 2 knights are attacking
        cellAttackingKingBlack1 = new Cell(7, 1);
        cellAttackingKingBlack2 = new Cell(3, 1);
        board.setPiece(cellAttackingKingBlack1, knightW1);
        board.setPiece(cellAttackingKingBlack2, knightW2);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingBlack1, null);
        board.setPiece(cellAttackingKingBlack2, null);
        // 2 knights are attacking
        cellAttackingKingBlack1 = new Cell(7, 3);
        cellAttackingKingBlack2 = new Cell(3, 3);
        board.setPiece(cellAttackingKingBlack1, knightW1);
        board.setPiece(cellAttackingKingBlack2, knightW2);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingBlack1, null);
        board.setPiece(cellAttackingKingBlack2, null);
        // 2 knights are attacking
        cellAttackingKingBlack1 = new Cell(6, 4);
        cellAttackingKingBlack2 = new Cell(4, 4);
        board.setPiece(cellAttackingKingBlack1, knightW1);
        board.setPiece(cellAttackingKingBlack2, knightW2);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingBlack1, null);
        board.setPiece(cellAttackingKingBlack2, null);
        // only 1 knight in an attacking position (knight 2)
        cellAttackingKingBlack1 = new Cell(5, 0);
        cellAttackingKingBlack2 = new Cell(4, 4);
        board.setPiece(cellAttackingKingBlack1, knightW1);
        board.setPiece(cellAttackingKingBlack2, knightW2);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        // clear board
        board.setPiece(cellAttackingKingBlack1, null);
        board.setPiece(cellAttackingKingBlack2, null);
        // both knights are not in an attacking position
        cellAttackingKingBlack1 = new Cell(3, 0);
        cellAttackingKingBlack2 = new Cell(3, 2);
        board.setPiece(cellAttackingKingBlack1, knightW1);
        board.setPiece(cellAttackingKingBlack2, knightW2);
        assertEquals(NO_STATUS, moveChecker.isPlayerInCheck(board));
    }
}