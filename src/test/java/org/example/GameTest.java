package org.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GameTest {
    private Game game;
    private MessageDisplay messageDisplay;

    @Before
    public void setUp() {
        ResultGenerator resultGenerator = new FakeResultGenerator();
        AttemptReader attemptReader = new FakeAttemptReader();
        messageDisplay = Mockito.mock(MessageDisplay.class);
        game = new Game(resultGenerator, attemptReader, messageDisplay);
    }

    @Test
    public void test() {
        game.run();

        Mockito.verify(messageDisplay).display("GUESS THE NUMBER GAME");
        Mockito.verify(messageDisplay).display("Attempt 1 of 10\n");

        Mockito.verify(messageDisplay).display("You win!");
    }
}