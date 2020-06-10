package com.chessgame;

import com.chessgame.Cell;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    // "testIsEqualTrue" tests method isEqual for true statement
    public void testIsEqualTrue() throws Exception {
        // Board setup
        // set up 2 cells (identical)
        Cell cellPiece = new Cell(1, 2);
        Cell cellResult = new Cell(1, 2);

        assertTrue(cellPiece.isEqual(cellResult));
    }

    @Test
    //"testIsEqualFalseRow" tests method isEqual on correct col, wrong row
    public void testIsEqualFalseRow() throws Exception {
        // set up 2 cells (identical)
        Cell cellPiece = new Cell(5, 7);
        Cell cellResult = new Cell(4, 7);

        assertFalse(cellPiece.isEqual(cellResult));
    }

    @Test
    //"testIsEqualFalseRow" tests method isEqual on correct col, wrong row
    public void testIsEqualFalseCol() throws Exception {
        // set up 2 cells (identical)
        Cell cellPiece = new Cell(5, 7);
        Cell cellResult = new Cell(5, 4);

        assertFalse(cellPiece.isEqual(cellResult));
    }

    @Test
    // test method " cellCopy"
    public void testCellCopy() throws Exception {
        Cell cellPiece1 = new Cell(3,6);
        Cell copyCell = new Cell();
        copyCell.copy(cellPiece1);

        assertEquals(cellPiece1.getRow(), copyCell.getRow());
        assertEquals(cellPiece1.getCol(), copyCell.getCol());
    }

    @Test
    // test set
    public void TestSetRowAndCol() throws Exception {
        Cell start = new Cell(3,6);
        Cell end = new Cell(4,7);
        start.set(4,7);

        assertEquals(start.getRow(),end.getRow());
        assertEquals(start.getCol(),end.getCol());
    }

}
