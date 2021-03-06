package com.chessgame;

import com.chessgame.Constants;
import com.chessgame.MakeMoveResults;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.chessgame.Constants.MakeMoveStatuses.*;
import static com.chessgame.Constants.PlayerStatus.*;

public class MakeMoveResultsTest {

    MakeMoveResults makeMoveResults;
    @Before
    public void initialize() {
        makeMoveResults = new MakeMoveResults();
    }

    @Test
    public void getMakeMoveStatuses() {
        makeMoveResults.setMakeMoveStatuses(CANNOT_ATTACK_OWN_PIECES);
        assertEquals(CANNOT_ATTACK_OWN_PIECES, makeMoveResults.getMakeMoveStatuses());
    }

    @Test
    public void setMakeMoveStatuses() {
        makeMoveResults.setMakeMoveStatuses(CANNOT_ATTACK_OWN_PIECES);
        Constants.MakeMoveStatuses moveStatus = makeMoveResults.getMakeMoveStatuses();
        assertEquals(CANNOT_ATTACK_OWN_PIECES, moveStatus);
    }

    @Test
    public void getPlayerStatus() {
        makeMoveResults.setPlayerStatus(WHITE_PLAYER_IN_CHECK);
        assertEquals(WHITE_PLAYER_IN_CHECK, makeMoveResults.getPlayerStatus());
    }

    @Test
    public void setPlayerStatus() {
        makeMoveResults.setPlayerStatus(BLACK_PLAYER_IN_CHECK);
        Constants.PlayerStatus playerStatus = makeMoveResults.getPlayerStatus();
        assertEquals(BLACK_PLAYER_IN_CHECK, playerStatus);
    }
}