
import com.Board;
import com.Cell;
import com.Constants;
import com.GamePiece;
import com.pieces.*;
import junit.extensions.TestSetup;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    GamePiece pieceW;
    GamePiece pieceB;
    Board board;

    @Before
    public void initialize() {
        board = new Board();
        pieceW = new Rook(Constants.Color.WHITE);
        pieceB = new Queen(Constants.Color.BLACK);
    }

    @Test
    // "testGetPiecesByType" tests method getPieces
    public void testGetPiecesByType() throws Exception {
        // Board setup
        // 1st piece (Queen B)
        Cell cellPiece1 = new Cell(0,0);
        board.setPiece(cellPiece1,pieceB);

        // 2nd piece (rook W)
        Cell cellPiece2 = new Cell(3,5);
        board.setPiece(cellPiece2,pieceW);

        // 3rd piece (king B)
        Cell cellPiece3 = new Cell(1,2);
        GamePiece piece3 = new King(Constants.Color.BLACK);
        board.setPiece(cellPiece3,piece3);

        // 4th piece (King W)
        Cell cellPiece4 = new Cell(7,7);
        GamePiece piece4 = new King(Constants.Color.WHITE);
        board.setPiece(cellPiece4,piece4);

        // 5th piece (Pawn W)
        Cell cellPiece5 = new Cell(4,6);
        GamePiece piece5 = new Pawn(Constants.Color.WHITE);
        board.setPiece(cellPiece5,piece5);

        LinkedList<Cell> resultKing = new LinkedList<>();
        resultKing.add(cellPiece3);
        resultKing.add(cellPiece4);
        LinkedList<Cell> result = new LinkedList<>();
        result = board.getPiecesByType(Constants.GamePieceName.KING);
        Cell result1 = result.pollFirst();
        Cell result2 = result.pollFirst();


        assertTrue(cellPiece3.isEqual(result1)||cellPiece3.isEqual(result2));
        assertTrue(cellPiece4.isEqual(result1)||cellPiece4.isEqual(result2));
    }


    @Test
    // "testBoundariesOfCell" tests method: "isCellValid"
    public void testBoundariesOfCell() throws Exception {

        // cell is out of bound (col)
        Cell start = new Cell(0,-2);
        assertEquals(false,board.isCellValid(start));

        // cell is out of bound (col)
        start = new Cell(0,8);
        assertEquals(false,board.isCellValid(start));

        // cell is out of bound (row)
        start = new Cell(-1,5);
        assertEquals(false,board.isCellValid(start));

        // cell is out of bound (row)
        start = new Cell(9,5);
        assertEquals(false,board.isCellValid(start));

        // cell is in bound
        start = new Cell(4,5);
        assertEquals(true,board.isCellValid(start));
        // cell is in bound
        start = new Cell(0,0);
        assertEquals(true,board.isCellValid(start));
        // cell is in bound
        start = new Cell(7,7);
        assertEquals(true,board.isCellValid(start));
    }

    @Test
    // "testIsCellEmpty" tests isEmpty method
    public void testIsCellEmpty() throws Exception {
        // place a piece on a given cell
        Cell start = new Cell(2,4);
        board.setPiece(start,pieceB);
        assertEquals(false,board.isEmpty(start));

        // no piece on a given cell
        start = new Cell(3,4);
        assertEquals(true,board.isEmpty(start));
    }

    @Test
    // "testGetPiece" tests getPiece method, which returns a gamePiece
    public void testGetPiece() throws Exception {
        // pieceW is a rook.
        Cell start = new Cell(7,3);
        board.setPiece(start,pieceW);
        assertEquals(pieceW,board.getPiece(start));

        // pieceB is a queen.
        start = new Cell(2,4);
        board.setPiece(start,pieceB);
        assertEquals(pieceB,board.getPiece(start));
    }

    @Test
    // Tests method getRowSize
    public void testGetRowSize() throws Exception {
        assertEquals(8,board.getRowSize());
    }

    @Test
    // Tests method getColSize
    public void testGetColSize() throws Exception {
        assertEquals(8,board.getColSize());
    }
}
