
import com.*;
import com.pieces.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static com.Constants.MakeMoveStatuses.*;
import static com.Constants.PlayerStatus.*;


public class RuleEngineTest {

    GamePiece queenW;
    GamePiece bishopB;
    GamePiece pawnW;
    GamePiece knightB;
    GamePiece kingW;
    GamePiece kingB;
    GamePiece rookW;
    GamePiece pawnB;
    Board board;

    @Mock
    GamePiece mockPiece = mock(GamePiece.class);
    @Mock
    MoveChecker mockMoveCheck = mock(MoveChecker.class);

    RuleEngine ruleEngine =  new RuleEngine(mockMoveCheck);

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
    // Is start cell valid
    public void isStartCellValid() throws Exception {
        Cell start = new Cell(8, 4);
        Cell end = new Cell(5, 6);

        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.WHITE);
        assertEquals(OUT_OF_BOUND, result.getMakeMoveStatuses());
    }

    @Test
    // Is end cell valid
    public void isEndCellValid() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(5, -1);
        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.BLACK);
        assertEquals(OUT_OF_BOUND, result.getMakeMoveStatuses());
    }

    @Test
    // Test board is empty (i.e. no piece selected)
    // it also validates the first 2 booleans of the canPlayerMakeMove function, as start and end are valid.
    public void boardIsEmpty() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(5, 4);
        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.BLACK);
        assertEquals(NO_PIECE_SELECTED, result.getMakeMoveStatuses());
    }

    @Test
    // Test that the player cannot select enemy pieces to make a move.
    // test also validates that the board is not empty, and that start and end are valid.
    public void playerSelectsOwnPieces() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(7, 4);
        board.setPiece(start, queenW);

        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.BLACK);
        assertEquals(CANT_MOVE_OPPONENT_PIECE, result.getMakeMoveStatuses());
    }

    @Test
    // Test that the player cannot attack their own pieces.
    // test also validates that the player can select their own pieces.
    public void playerAttacksTheirOwnPieces() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(6, 4);
        board.setPiece(start, queenW);
        board.setPiece(end,pawnW);

        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.WHITE);
        assertEquals(CANNOT_ATTACK_OWN_PIECES, result.getMakeMoveStatuses());
    }

    @Test
    // test that the piece can be placed in the square selected by the player.
    public void CanPieceAtStartMoveToDest() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(6, 4);

        when(mockPiece.getColor()).thenReturn(Constants.Color.WHITE);
        when(mockPiece.canMoveToDest(any(),any(),any())).thenReturn(false);

        board.setPiece(start, mockPiece);
        board.setPiece(end,pawnB);

        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.WHITE);
        assertEquals(UNAUTHORIZED_MOVE, result.getMakeMoveStatuses());
    }

    @Test
    // verifies that the destination cell isn't empty.
    public void testExecuteMoveWhenEndIsFilled() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(6, 4);
        board.setPiece(end,rookW);
        assertEquals(rookW, board.getPiece(end));
    }
    @Test
    // verifies if the move is putting the player in check.
    // The player is NOT in check.
    public void testIsPlayerInCheckFalse() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(6, 4);

        when(mockPiece.getColor()).thenReturn(Constants.Color.BLACK);
        when(mockPiece.canMoveToDest(any(),any(),any())).thenReturn(true);
        board.setPiece(start, mockPiece);
        board.setPiece(end,rookW);

        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.BLACK);
        assertEquals(MOVE_IS_VALID, result.getMakeMoveStatuses());
    }

    @Test
    // verifies if the move is putting the player in check.
    // The player IS in check.
    public void testIsPlayerInCheckTrue() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(6, 4);

        when(mockPiece.getColor()).thenReturn(Constants.Color.BLACK);
        when(mockPiece.canMoveToDest(any(),any(),any())).thenReturn(true);
        board.setPiece(start, mockPiece);
        board.setPiece(end,rookW);

        when(mockMoveCheck.isPlayerInCheck(board)).thenReturn(BLACK_PLAYER_IN_CHECK);

        MakeMoveResults result = ruleEngine.canPlayerMakeMove(board,start,end,Constants.Color.BLACK);
        assertEquals(YOU_ARE_IN_CHECK, result.getMakeMoveStatuses());
    }
    @Test
    // verifies if the move is putting the player in check.
    // The player IS in check, this test verifies the backtracking.
    public void testBacktracking() throws Exception {
        Cell start = new Cell(4, 4);
        Cell end = new Cell(6, 4);

        when(mockPiece.getColor()).thenReturn(Constants.Color.BLACK);
        when(mockPiece.canMoveToDest(any(),any(),any())).thenReturn(true);
        board.setPiece(start, mockPiece);
        board.setPiece(end,rookW);

        when(mockMoveCheck.isPlayerInCheck(board)).thenReturn(BLACK_PLAYER_IN_CHECK);
        assertEquals(mockPiece, board.getPiece(start));

    }
    // setup tests for setPiece
}
