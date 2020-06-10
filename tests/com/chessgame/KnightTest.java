package com.chessgame;

import com.chessgame.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    GamePiece pieceW;
    GamePiece pieceB;
    Board board;

    @Before
    public void initialize() {
        board = new Board();
        pieceW = new Knight(Constants.Color.WHITE, 0);
        pieceB = new Knight(Constants.Color.BLACK, 0);
    }

    @Test
    // I.  The first part ensures that a Knight can move in his designated 8

    // canMoveIn8Positions tests that a knight can go to all 8 positions
    public void canMoveIn8Positions() throws Exception {

        // move 1: i+1, j+2
        Cell start = new Cell(4, 4);
        Cell end = new Cell(5, 6);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // move 2: i-1, j+2
        start = new Cell(4, 4);
        end = new Cell(3, 6);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // move 3: i-2, j+1
        start = new Cell(4, 4);
        end = new Cell(2, 5);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // move 4: i-2, j-1
        start = new Cell(4, 4);
        end = new Cell(2, 3);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // move 5: i-1, j-2
        start = new Cell(4, 4);
        end = new Cell(3, 2);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // move 6: i+1, j-2
        start = new Cell(4, 4);
        end = new Cell(5, 2);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // move 7: i+2, j-1
        start = new Cell(4, 4);
        end = new Cell(6, 3);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // move 8: i+2, j+1
        start = new Cell(4, 4);
        end = new Cell(6, 5);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // II.  The second part ensures that a Knight cannot move in other positions

    // canMoveIn8Positions tests that a knight can go to all 8 positions
    public void canMoveInRandomPosition() throws Exception {

        // move 1: i+3, j
        Cell start = new Cell(4, 4);
        Cell end = new Cell(7, 4);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // move 2: i-3, j+1
        start = new Cell(4, 4);
        end = new Cell(1, 5);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // move 3: i, j+3
        start = new Cell(4, 4);
        end = new Cell(4, 7);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }
}
