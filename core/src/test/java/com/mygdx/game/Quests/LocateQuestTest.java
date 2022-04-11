package com.mygdx.game.Quests;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entitys.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocateQuestTest {

    Quest questT;

    @Mock
    Player player;

    @BeforeEach
    void setUp() {
        Vector2 qPos = new Vector2(40, -40);
        questT = new LocateQuest(qPos, 10);
    }

    @Test
    public void LocateQuestCompletionTest () {
        Vector2 playerPos1 = new Vector2(30, -40);
        when(player.getPosition()).thenReturn(playerPos1);
        assertFalse(questT.checkCompleted(player));

        Vector2 playerPos2 = new Vector2(31, -40);
        when(player.getPosition()).thenReturn(playerPos2);
        assertTrue(questT.checkCompleted(player));
    }

}