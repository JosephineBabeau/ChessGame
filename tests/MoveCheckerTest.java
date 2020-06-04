import com.*;
import com.pieces.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCheckerTest {

    GamePiece queenW;
    GamePiece bishopB;
    GamePiece pawnW;
    GamePiece knightB;
    GamePiece kingW;
    GamePiece kingB;
    GamePiece rookW;
    GamePiece pawnB;
    Board board;

    MoveChecker moveChecker = new MoveChecker();

    @Before
    public void initialize() {
        board = new Board();
        queenW = new Queen(Constants.Color.WHITE);
        bishopB = new Bishop(Constants.Color.BLACK);
        pawnW = new Pawn((Constants.Color.WHITE));
        knightB = new Knight(Constants.Color.BLACK);
        kingW = new King(Constants.Color.WHITE);
        kingB = new King(Constants.Color.BLACK);
        rookW = new Rook(Constants.Color.WHITE);
        pawnB = new Pawn(Constants.Color.BLACK);
    }
    @Test
    // Is player in check
    public void testIsPlayerInCheck() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(5, 5);
        Cell cellKingW = new Cell(3,2);
        Cell cellKingB = new Cell(6,4);
        board.setPiece(start, bishopB);
        board.setPiece(cellKingW, kingW);
        board.setPiece(cellKingB, kingB);
        assertTrue(moveChecker.isPlayerInCheck(board, Constants.Color.BLACK, start, end));
    }

}
