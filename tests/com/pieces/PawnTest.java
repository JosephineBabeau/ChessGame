package com.pieces;
import com.Board;
import com.Cell;
import com.Constants;
import com.GamePiece;
import junit.extensions.TestSetup;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    GamePiece pieceW;
    GamePiece pieceB;
    Board board;

    @Before
    public void initialize2SquareFromStart() {
        board = new Board();
        pieceW = new Pawn(Constants.Color.WHITE);
        pieceB = new Pawn((Constants.Color.BLACK));
    }

    @Test
    // test of rule #2 from "canMoveToDest".
    // "canMove2squareFromStartingPos" tests that a Pawn
    // can move by 2 squares from the start position
    public void canMove2squareFromStartingPos() throws Exception {

        // a white pawn starts on row i = 1 (2nd line of the board) and moves by 2
        Cell start = new Cell(1,0);
        Cell end = new Cell(3, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black pawn starts on row i = 6 (2nd line of the board from Black standpoint) and moves by 2
        end = new Cell(4, 0);
        start = new Cell(6,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // test of rule #2 from "canMoveToDest".
    // "canMove2squareFromOtherPos" tests that a Pawn
    // can ONLY move by 2 squares from the start position
    public void canMove2squareFromOtherPos() throws Exception {

        // a white pawn starts on row i = 2 (3nd line of the board) and tries to move by 2
        Cell start = new Cell(2,0);
        board.setPiece(start, pieceW);
        Cell end = new Cell(4, 0);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black pawn starts on row i = 5 (3nd line of the board from Black standpoint) and tries to move by 2
        start = new Cell(5,0);
        board.setPiece(start, pieceB);
        end = new Cell(3, 0);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // test of rule #1 from "canMoveToDest".
    // "canMoveForwardBy1Square" tests that a Pawn
    // can ONLY move by 1 square forward, not backward.
    public void canMoveForwardBy1Square() throws Exception {
        // white pawn starts on row 4 to move to row 5
        Cell start = new Cell(4,0);
        board.setPiece(start, pieceW);
        Cell end = new Cell(5,0);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // white pawn starts on row 4 to move to row 3 (backward)
        start = new Cell(4,0);
        board.setPiece(start, pieceW);
        end = new Cell(3,0);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // black pawn starts on row 5 to move to row 4
        start = new Cell(5,0);
        board.setPiece(start, pieceB);
        end = new Cell(4,0);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // black pawn starts on row 5 to move to row 6 (backward)
        start = new Cell(5,0);
        board.setPiece(start, pieceB);
        end = new Cell(6,0);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // test of rule #3 from "canMoveToDest".
    // "canMove1SquareInDiagToAttackWHITE" tests that a Pawn can ONLY
    // move by 1 square in diag (forward) if there is an enemy piece.

    public void canMove1SquareInDiagToAttackWHITE() throws Exception {

        // white pawn starts on row 3 to move forward 1 row in diagonal (col + 1), to take an enemy piece
        Cell start = new Cell(3,1);
        Cell end = new Cell(4,2);
        Cell enemyB = new Cell(4,2);
        board.setPiece(start, pieceW);
        board.setPiece(enemyB, pieceB);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // white pawn starts on row 3 to move forward 1 row in diagonal (col - 1), to take an enemy piece
        start = new Cell(3,1);
        end = new Cell(4,0);
        enemyB = new Cell(4,0);
        board.setPiece(start, pieceW);
        board.setPiece(enemyB, pieceB);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // white pawn starts on row 5 to move BACKWARD 1 row in diagonal (col + 1), to take an enemy piece
        start = new Cell(5,1);
        end = new Cell(4,2);
        enemyB = new Cell(4,2);
        board.setPiece(start, pieceW);
        board.setPiece(enemyB, pieceB);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // white pawn starts on row 5 to move BACKWARD 1 row in diagonal (col + 1), to take an enemy piece
        start = new Cell(5,1);
        end = new Cell(4,0);
        enemyB = new Cell(4,0);
        board.setPiece(start, pieceW);
        board.setPiece(enemyB, pieceB);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));
    }
    @Test
    // test of rule #3 from "canMoveToDest".
    // "canMove1SquareInDiagToAttackBLACK" tests that a Pawn can ONLY
    // move by 1 square in diag (forward) if there is an enemy piece.

    public void canMove1SquareInDiagToAttackBLACK() throws Exception {

        // Black pawn starts on row 4 to move forward 1 row in diagonal (col + 1), to take an enemy piece
        Cell start = new Cell(4,1);
        Cell end = new Cell(3,2);
        Cell enemyB = new Cell(3,2);
        board.setPiece(start, pieceB);
        board.setPiece(enemyB, pieceW);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // black pawn starts on row 4 to move forward 1 row in diagonal (col - 1), to take an enemy piece
        start = new Cell(4,1);
        end = new Cell(3,0);
        enemyB = new Cell(3,0);
        board.setPiece(start, pieceB);
        board.setPiece(enemyB, pieceW);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // black pawn starts on row 5 to move BACKWARD 1 row in diagonal (col + 1), to take an enemy piece
        start = new Cell(5,1);
        end = new Cell(6,2);
        enemyB = new Cell(6,2);
        board.setPiece(start, pieceB);
        board.setPiece(enemyB, pieceW);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));

        // black pawn starts on row 5 to move BACKWARD 1 row in diagonal (col + 1), to take an enemy piece
        start = new Cell(5,1);
        end = new Cell(6,0);
        enemyB = new Cell(6,0);
        board.setPiece(start, pieceB);
        board.setPiece(enemyB, pieceW);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // test of rule #3 from "canMoveToDest".
    // Similar to above, "canMove1SquareInDiagWhite" tests that a Pawn cannot
    // move by 1 square in diag (forward) if there is a friend piece.

    public void canMove1SquareInDiagWhite() throws Exception {

        // White pawn starts on row 4 to move forward 1 row in diagonal (col + 1)
        Cell start = new Cell(4, 1);
        Cell end = new Cell(5, 2);
        Cell friendW = new Cell(5, 2);
        board.setPiece(start, pieceW);
        board.setPiece(friendW, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // White pawn starts on row 4 to move forward 1 row in diagonal (col - 1), to take an enemy piece
        start = new Cell(4, 1);
        end = new Cell(5, 0);
        friendW = new Cell(5, 0);
        board.setPiece(start, pieceW);
        board.setPiece(friendW, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));
    }
    @Test
    // test of rule #3 from "canMoveToDest".
    // Similar to above, "canMove1SquareInDiagBlack" tests that a Pawn cannot
    // move by 1 square in diag (forward) if there is a friend piece.

    public void canMove1SquareInDiagBlack() throws Exception {

        // White pawn starts on row 4 to move forward 1 row in diagonal (col + 1)
        Cell start = new Cell(4, 1);
        Cell end = new Cell(3, 2);
        Cell friendB = new Cell(3, 2);
        board.setPiece(start, pieceB);
        board.setPiece(friendB, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));

        // black pawn starts on row 4 to move forward 1 row in diagonal (col - 1), to take an enemy piece
        start = new Cell(4, 1);
        end = new Cell(3, 0);
        friendB = new Cell(3, 0);
        board.setPiece(start, pieceB);
        board.setPiece(friendB, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // Random set of tests for diagonals

    public void randomDiag() throws Exception {

        // black pawn starts on row 3 to move forward in diagonal (col + 3)
        Cell start = new Cell(3, 0);
        Cell end = new Cell(2, 3);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));

        // white pawn starts on row 3 to move forward in diagonal (col - 3)
        start = new Cell(3, 5);
        end = new Cell(4, 2);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));
    }

}
