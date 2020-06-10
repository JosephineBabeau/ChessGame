package com.chessgame;

import com.chessgame.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {

    GamePiece pieceW;
    GamePiece pieceB;
    Board board;

    @Before
    public void initialize() {
        board = new Board();
        pieceW = new Bishop(Constants.Color.WHITE, 0);
        pieceB = new Bishop(Constants.Color.BLACK, 0);
    }

    @Test
    // I.  The first part ensures that a bishop can move in diagonal line (same tests as for the queen)

    // canMoveInDiagFrontLeft tests that a bishop can move forward, in diag (left)
    public void canMoveInDiagFrontLeft() throws Exception {

        // a white bishop starts on row i = 0 and moves by 1
        Cell start = new Cell(0, 2);
        Cell end = new Cell(1, 1);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white bishop starts on row i = 0 and moves by many squares
        start = new Cell(0, 5);
        end = new Cell(5, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black bishop
        // a black bishop starts on row i = 7 and moves by 1
        start = new Cell(7, 2);
        end = new Cell(6, 1);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black bishop starts on row i = 7 and moves by many squares
        start = new Cell(7, 5);
        end = new Cell(2, 0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveInDiagFrontRight tests that a bishop can move forward, in diag (right)
    public void canMoveInDiagFrontRight() throws Exception {

        // a white bishop starts on row i = 0 and moves by 1
        Cell start = new Cell(0, 2);
        Cell end = new Cell(1, 3);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white bishop starts on row i = 0 and moves by many squares
        start = new Cell(0, 5);
        end = new Cell(2, 7);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black bishop
        // a black bishop starts on row i = 7 and moves by 1
        start = new Cell(7, 2);
        end = new Cell(6, 3);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black bishop starts on row i = 7 and moves by many squares
        start = new Cell(7, 5);
        end = new Cell(5, 7);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // canMoveInDiagBackLeft verifies that the bishop can move in diagonal, backward (left)
    public void canMoveInDiagBackLeft() throws Exception {

        // a white bishop starts on row i = 2 and moves by 1
        Cell start = new Cell(2, 3);
        Cell end = new Cell(1, 2);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white bishop starts on row i = 2 and moves by many squares
        start = new Cell(2, 3);
        end = new Cell(0, 1);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black bishop
        // a black bishop starts on row i = 5 and moves by 1
        start = new Cell(5, 3);
        end = new Cell(6, 2);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black bishop starts on row i = 5 and moves by many squares
        start = new Cell(5, 4);
        end = new Cell(7, 2);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // canMoveInDiagBackRight verifies that the bishop can move in diagonal, backward (right)
    public void canMoveInDiagBackRight() throws Exception {

        // a white bishop starts on row i = 2 and moves by 1
        Cell start = new Cell(2, 3);
        Cell end = new Cell(1, 4);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white bishop starts on row i = 2 and moves by many squares
        start = new Cell(2, 4);
        end = new Cell(0, 6);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black bishop
        // a black bishop starts on row i = 5 and moves by 1
        start = new Cell(5, 4);
        end = new Cell(6, 5);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black bishop starts on row i = 3 and moves by many squares
        start = new Cell(3, 1);
        end = new Cell(7, 5);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    // II. the second part ensures that bishops can't perform moves other than diagonal.
    @Test
    // canMoveInDiagBackRight verifies that the bishop can move in diagonal, backward (right)
    public void canMoveRandom() throws Exception {

        // a white bishop tries to move horizontally
        Cell start = new Cell(2, 3);
        Cell end = new Cell(2, 6);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a white bishop tries to move vertically
        start = new Cell(2, 4);
        end = new Cell(7, 4);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black bishop does a knight move
        start = new Cell(5, 4);
        end = new Cell(3, 5);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));

        // a black bishop tries to move randomly on the board
        start = new Cell(5, 3);
        end = new Cell(1, 2);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }

}
