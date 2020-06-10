package com.chessgame;
import com.chessgame.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {

    GamePiece pieceW;
    GamePiece pieceB;
    Board board;

    @Before
    public void initialize() {
        board = new Board();
        pieceW = new Rook(Constants.Color.WHITE, 0);
        pieceB = new Rook(Constants.Color.BLACK, 0);
    }

    @Test
    // canMoveFrontVertical tests movements in front by 1 and several squares
    public void canMoveFrontVertical() throws Exception {

        // a white rook starts on row i = 0 and moves by 1
        Cell start = new Cell(0,0);
        Cell end = new Cell(1, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white rook starts on row i = 0 and moves through the full line
        start = new Cell(0,0);
        end = new Cell(7, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black rook starts on row i = 7 and moves by 1
        end = new Cell(7, 0);
        start = new Cell(6,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black rook starts on row i = 7  and moves through the full line
        end = new Cell(7, 0);
        start = new Cell(0,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveBackVertical tests movements moving backwards by 1 and several squares
    public void canMoveBackVertical() throws Exception {

        // a white rook starts on row i = 7 and moves by 1
        Cell start = new Cell(7,0);
        Cell end = new Cell(6, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white rook starts on row i = 7 and moves through the full line
        start = new Cell(7,0);
        end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black rook starts on row i = 5 and moves by 1
        end = new Cell(5, 0);
        start = new Cell(6,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black rook starts on row i = 0  and moves through the full line
        end = new Cell(0, 0);
        start = new Cell(7,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // canMoveLeftHorizontal tests movements going left by 1 and several squares
    public void canMoveLeftHorizontal() throws Exception {

        // a white rook starts on row i = 0 and moves by 1
        Cell start = new Cell(0,7);
        Cell end = new Cell(0, 6);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white rook starts on row i = 0 and moves through the full line
        start = new Cell(0,7);
        end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black rook starts on row i = 7 and moves by 1
        end = new Cell(7, 7);
        start = new Cell(7,6);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black rook starts on row i = 7  and moves through the full line
        end = new Cell(7, 7);
        start = new Cell(7,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveRightHorizontal tests horizontal movements, going right, by 1 and several squares
    public void canMoveRightHorizontal() throws Exception {

        // a white rook starts on row i = 0 and moves by 1
        Cell start = new Cell(0,0);
        Cell end = new Cell(0, 1);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white rook starts on row i = 0 and moves through the full line
        start = new Cell(0,0);
        end = new Cell(0, 7);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black rook starts on row i = 5 and moves by 1
        end = new Cell(5, 0);
        start = new Cell(5,1);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black rook starts on row i = 5 and moves through the full line
        end = new Cell(5, 0);
        start = new Cell(5,7);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveDiagonalRandom tests that rooks cannot go in diagonal
    public void canMoveDiagonalRandom() throws Exception {

        // a white rook starts on row i = 0 and moves by 1, in diagonal
        Cell start = new Cell(0,0);
        Cell end = new Cell(1, 1);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a white rook starts on row i = 4 and moves by several squares (columns & rows)
        start = new Cell(4,4);
        end = new Cell(0, 7);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black rook starts on row i = 5 and moves by 1
        end = new Cell(5, 0);
        start = new Cell(6,1);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));

        // a black rook starts on row i = 5 and moves by several squares (columns & rows)
        end = new Cell(5, 0);
        start = new Cell(0,1);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }

}
