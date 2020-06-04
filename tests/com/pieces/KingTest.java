package com.pieces;

import com.Board;
import com.Cell;
import com.Constants;
import com.GamePiece;
import junit.extensions.TestSetup;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

    GamePiece pieceW;
    GamePiece pieceB;
    Board board;

    @Before
    public void initialize() {
        board = new Board();
        pieceW = new King(Constants.Color.WHITE);
        pieceB = new King((Constants.Color.BLACK));
    }

    @Test
    // canMove1SquareFront tests movements in front by 1 square
    public void canMove1SquareFront() throws Exception {

        // a white king starts on row i = 0 and moves by 1
        Cell start = new Cell(0,0);
        Cell end = new Cell(1, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 7 and moves by 1
        end = new Cell(7, 0);
        start = new Cell(6,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }

    @Test
    // canMoveManySquaresFront tests movements in front by many square
    public void canMoveManySquaresFront() throws Exception {

        // a white king starts on row i = 0 and moves by 5
        Cell start = new Cell(0,0);
        Cell end = new Cell(5, 0);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 7 and moves by 5
        end = new Cell(7, 0);
        start = new Cell(2,0);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMove1SquareBack tests movements in back by 1 square
    public void canMove1SquareBack() throws Exception {

        // a white king starts on row i = 1 and moves by 1
        Cell start = new Cell(1,0);
        Cell end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 1
        end = new Cell(6, 0);
        start = new Cell(7,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveManySquaresBack tests movements in back by many square
    public void canMoveManySquaresBack() throws Exception {

        // a white king starts on row i = 5 and moves by 5
        Cell start = new Cell(5,0);
        Cell end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 4 and moves by 3
        end = new Cell(4, 0);
        start = new Cell(1,0);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveDiagBackRight tests movements in back diagonal right by 1 and many squares
    public void canMoveDiagBackRight() throws Exception {

        // a white king starts on row i = 1 and moves by 1
        Cell start = new Cell(1,0);
        Cell end = new Cell(0, 1);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white king starts on row i = 2 and moves by 2 (in diag)
        start = new Cell(2,0);
        end = new Cell(0, 2);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 1
        end = new Cell(6, 0);
        start = new Cell(7,1);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black king starts on row i = 4 and moves by 2 (in diag)
        end = new Cell(4, 0);
        start = new Cell(6,2);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveDiagBackLeft tests movements in back left diagonal by 1 and many squares
    public void canMoveDiagBackLeft() throws Exception {

        // a white king starts on row i = 1 and moves by 1
        Cell start = new Cell(1,4);
        Cell end = new Cell(0, 3);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white king starts on row i = 2 and moves by 2 (in diag)
        start = new Cell(2,2);
        end = new Cell(0, 0);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 1
        end = new Cell(6, 1);
        start = new Cell(7,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 2 (in diag)
        end = new Cell(4, 4);
        start = new Cell(6,2);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveDiagFrontRight tests movements in front diag right by 1 and many squares
    public void canMoveDiagFrontRight() throws Exception {

        // a white king starts on row i = 1 and moves by 1
        Cell start = new Cell(1,0);
        Cell end = new Cell(2, 1);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white king starts on row i = 0 and moves by 2 (in diag)
        start = new Cell(0,0);
        end = new Cell(2, 2);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 1
        end = new Cell(6, 0);
        start = new Cell(5,1);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 2 (in diag)
        end = new Cell(6, 0);
        start = new Cell(4,2);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }
    @Test
    // canMoveDiagFrontLeft tests movements in front left diagonal by 1 and many squares
    public void canMoveDiagFrontLeft() throws Exception {

        // a white king starts on row i = 1 and moves by 1
        Cell start = new Cell(1,4);
        Cell end = new Cell(2, 3);
        board.setPiece(start, pieceW);
        assertEquals(true, pieceW.canMoveToDest(board, start, end));

        // a white king starts on row i = 0 and moves by 2 (in diag)
        start = new Cell(0,2);
        end = new Cell(2, 0);
        board.setPiece(start, pieceW);
        assertEquals(false, pieceW.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 1
        end = new Cell(6, 1);
        start = new Cell(5,0);
        board.setPiece(start, pieceB);
        assertEquals(true, pieceB.canMoveToDest(board, start, end));

        // a black king starts on row i = 6 and moves by 2 (in diag)
        end = new Cell(6, 4);
        start = new Cell(4,2);
        board.setPiece(start, pieceB);
        assertEquals(false, pieceB.canMoveToDest(board, start, end));
    }

}
