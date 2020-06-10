package com.chessgame;

import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class GamePieceTest {
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
    // "testGetColor": test true for 2 black pieces
    public void testGetColorBlackTrue() throws Exception {

        assertEquals(Constants.Color.BLACK, pieceB.getColor());
    }
    @Test
    // "testGetColor": test false for 1 black and 1 white pieces
    public void testGetColorBlackFalse() throws Exception {

        assertNotEquals(Constants.Color.WHITE, pieceB.getColor());
    }
    @Test
    // "testGetColor": test true for 2 white pieces
    public void testGetColorWHITETrue() throws Exception {

        assertEquals(Constants.Color.WHITE, pieceW.getColor());
    }
    @Test
    // "testGetColor": test false for 1 white and 1 black pieces
    public void testGetColorWhiteFalse() throws Exception {

        assertNotEquals(Constants.Color.BLACK, pieceW.getColor());
    }

}
