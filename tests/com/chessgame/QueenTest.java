package com.chessgame;

import com.chessgame.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
    GamePiece pieceW;
    GamePiece pieceB;
    Board board;

    @Before
    public void initialize() {
        board = new Board();
        pieceW = new Queen(Constants.Color.WHITE, 0);
        pieceB = new Queen(Constants.Color.BLACK, 0);
    }
    @Test
    // I.  The first part ensures that a queen can move in straight line (same tests as for the rook)

    // canMoveFrontVertical tests movements in front by 1 and several squares
    public void canMoveFrontVertical() throws Exception {

        // a white queen starts on row i = 0 and moves by 1
        Cell start = new Cell(0,0);
        Cell end = new Cell(1, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 0 and moves through the full line
        start = new Cell(0,0);
        end = new Cell(7, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black queen starts on row i = 7 and moves by 1
        end = new Cell(7, 0);
        start = new Cell(6,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 7  and moves through the full line
        end = new Cell(7, 0);
        start = new Cell(0,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveBackVertical tests movements moving backwards by 1 and several squares
    public void canMoveBackVertical() throws Exception {

        // a white queen starts on row i = 7 and moves by 1
        Cell start = new Cell(7,0);
        Cell end = new Cell(6, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 7 and moves through the full line
        start = new Cell(7,0);
        end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black queen starts on row i = 5 and moves by 1
        end = new Cell(5, 0);
        start = new Cell(6,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 0  and moves through the full line
        end = new Cell(0, 0);
        start = new Cell(7,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // canMoveLeftHorizontal tests movements going left by 1 and several squares
    public void canMoveLeftHorizontal() throws Exception {

        // a white queen starts on row i = 0 and moves by 1
        Cell start = new Cell(0,7);
        Cell end = new Cell(0, 6);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 0 and moves through the full line
        start = new Cell(0,7);
        end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black queen starts on row i = 7 and moves by 1
        end = new Cell(7, 7);
        start = new Cell(7,6);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 7  and moves through the full line
        end = new Cell(7, 7);
        start = new Cell(7,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveRightHorizontal tests horizontal movements, going right, by 1 and several squares
    public void canMoveRightHorizontal() throws Exception {

        // a white queen starts on row i = 0 and moves by 1
        Cell start = new Cell(0,0);
        Cell end = new Cell(0, 1);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 0 and moves through the full line
        start = new Cell(0,0);
        end = new Cell(0, 7);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black queen starts on row i = 5 and moves by 1
        end = new Cell(5, 0);
        start = new Cell(5,1);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 5 and moves through the full line
        end = new Cell(5, 0);
        start = new Cell(5,7);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // II.  The second part ensures that a queen can move in diagonal line (same tests as for the bishop)

    // canMoveInDiagFrontLeft tests that a queen can move forward, in diag (left)
    public void canMoveInDiagFrontLeft() throws Exception {

        // a white queen starts on row i = 0 and moves by 1
        Cell start = new Cell(0, 3);
        Cell end = new Cell(1, 2);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 0 and moves by many squares
        start = new Cell(0, 7);
        end = new Cell(7, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black queen
        // a black queen starts on row i = 7 and moves by 1
        start = new Cell(7, 3);
        end = new Cell(6, 2);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 7 and moves by many squares
        start = new Cell(7, 7);
        end = new Cell(0, 0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveInDiagFrontRight tests that a queen can move forward, in diag (right)
    public void canMoveInDiagFrontRight() throws Exception {

        // a white queen starts on row i = 0 and moves by 1
        Cell start = new Cell(0, 3);
        Cell end = new Cell(1, 4);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 0 and moves by many squares
        start = new Cell(0, 0);
        end = new Cell(7, 7);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black queen
        // a black queen starts on row i = 7 and moves by 1
        start = new Cell(7, 3);
        end = new Cell(6, 4);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 7 and moves by many squares
        start = new Cell(7, 0);
        end = new Cell(0, 7);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // canMoveInDiagBackLeft verifies that the queen can move in diagonal, backward (left)
    public void canMoveInDiagBackLeft() throws Exception {

        // a white queen starts on row i = 5 and moves by 1
        Cell start = new Cell(5, 3);
        Cell end = new Cell(4, 2);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 7 and moves by many squares
        start = new Cell(7, 7);
        end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black queen
        // a black queen starts on row i = 4 and moves by 1
        start = new Cell(4, 3);
        end = new Cell(5, 2);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 0 and moves by many squares
        start = new Cell(0, 7);
        end = new Cell(7, 0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // canMoveInDiagBackRight verifies that the queen can move in diagonal, backward (right)
    public void canMoveInDiagBackRight() throws Exception {

        // a white queen starts on row i = 4 and moves by 1
        Cell start = new Cell(4, 4);
        Cell end = new Cell(3, 5);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 7 and moves by many squares
        start = new Cell(7, 0);
        end = new Cell(7, 7);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black queen
        // a black queen starts on row i = 3 and moves by 1
        start = new Cell(3, 1);
        end = new Cell(4, 2);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 0 and moves by many squares
        start = new Cell(0, 0);
        end = new Cell(7, 7);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    // III. The last part ensures that movements other than straight line and diagonals are not permitted
    @Test
    // canMoveInRandomPos verifies that the queen cannot move other than straight lines and diagonals
    public void canMoveInRandomPos() throws Exception {

        // a white queen starts on row i = 4 and attempts a knight movement
        Cell start = new Cell(4, 4);
        Cell end = new Cell(3, 2);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a white queen starts on row i = 4 and moves randomly
        start = new Cell(4, 4);
        end = new Cell(3, 7);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // repeat tests for the black queen
        // a black queen starts on row i = 3 and attempts a knight movement
        start = new Cell(3, 3);
        end = new Cell(5, 4);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));

        // a black queen starts on row i = 7 and moves randomly
        start = new Cell(7, 3);
        end = new Cell(1, 5);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }
}
