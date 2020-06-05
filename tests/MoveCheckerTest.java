import com.*;
import com.pieces.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static com.Constants.MakeMoveStatuses.*;
import static com.Constants.PlayerStatus.*;
import static com.Constants.GamePieceName.*;

public class MoveCheckerTest {

    GamePiece queenW;
    GamePiece queenB;
    GamePiece bishopB;
    GamePiece bishopW;
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
        queenB = new Queen(Constants.Color.BLACK);
        bishopB = new Bishop(Constants.Color.BLACK);
        bishopW = new Bishop(Constants.Color.WHITE);
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
        Cell cellKingB = new Cell(3,2);
        Cell cellKingW = new Cell(6,4);
        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);

        assertEquals(Constants.PlayerStatus.NO_STATUS, moveChecker.isPlayerInCheck(board));
    }

    @Test
    // test isCheck: Bishop attacks the king
    public void attackOnTheKingByBishop() throws Exception {
        Cell cellKingB = new Cell(3,2);
        Cell cellKingW = new Cell(6,4);
        Cell cellAttackingPieceW = new Cell(4,3);
        Cell cellAttackingPieceB = new Cell(2,0);

        //QueenW attack
        board.setPiece(cellKingB, kingB);
        board.setPiece(cellKingW, kingW);
        board.setPiece(cellAttackingPieceW, queenW);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //QueenB attack
        board.setPiece(cellAttackingPieceW, null);
        board.setPiece(cellAttackingPieceB, queenB);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //BishopW attack
        board.setPiece(cellAttackingPieceB, null);
        board.setPiece(cellAttackingPieceW, bishopW);
        assertEquals(BLACK_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));

        //BishopB attack
        board.setPiece(cellAttackingPieceW, null);
        board.setPiece(cellAttackingPieceB, bishopB);
        assertEquals(WHITE_PLAYER_IN_CHECK, moveChecker.isPlayerInCheck(board));
    }

}