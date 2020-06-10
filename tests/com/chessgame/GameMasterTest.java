package com.chessgame;

import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static com.chessgame.Constants.PlayerStatus.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GameMasterTest {
    @Mock
    GamePiece mockPiece = mock(GamePiece.class);
    @Mock
    MoveChecker mockMoveCheck = mock(MoveChecker.class);
    @Mock
    MakeMoveResults result = mock(MakeMoveResults.class);
    @Mock
    RuleEngine ruleEngine = mock(RuleEngine.class);
    MoveChecker moveChecker = new MoveChecker();

    Board board = new Board();
    GameMaster gameMaster = new GameMaster(board, ruleEngine);

    @Test
    // test game set up
    public void testStartNewGame() throws Exception {
        gameMaster.startNewGame();
        verify(ruleEngine, times(1)).setUpBoard(board);
    }

    @Test
    public void getPlayerStatus() {

    }

    @Test
    public void makeMove() {
        GamePiece queenW = new Queen(Constants.Color.WHITE, 0);
        GamePiece kingW = new Queen(Constants.Color.WHITE, 0);
        GamePiece kingB = new Queen(Constants.Color.BLACK, 0);
        Cell start = new Cell (0,0);
        Cell end = new Cell (5,5);
        board.setPiece(start, queenW);
        board.setPiece(new Cell(1,2), kingW);
        board.setPiece(new Cell(7,2), kingB);


        //Constants.PlayerStatus playerStatus = moveChecker.isPlayerInCheck(board);
        //        results.setPlayerStatus(playerStatus);

        when(ruleEngine.canPlayerMakeMove(any(), any(), any(), any(), any()))
                .thenReturn(result);

        when(result.getMakeMoveStatuses()).thenReturn(Constants.MakeMoveStatuses.MOVE_IS_VALID);
        when(result.getPlayerStatus()).thenReturn(NO_STATUS);
        gameMaster.makeMove(start, end, Constants.Color.WHITE);
        assertEquals(Constants.MakeMoveStatuses.MOVE_IS_VALID, gameMaster.makeMove(start, end, Constants.Color.WHITE));
    }
}