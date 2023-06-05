package org.example;

public class Game {
    private final static String TITLE = "GUESS THE NUMBER GAME";
    private final static int MAX_ATTEMPTS = 10;

    private final ResultGenerator resultGenerator;
    private final AttemptReader attemptReader;
    private final MessageDisplay messageDisplay;

    private int attemptCount = 0;
    private Result result;
    private Attempt attempt;

    public Game(ResultGenerator resultGenerator, AttemptReader attemptReader, MessageDisplay messageDisplay) {
        this.resultGenerator = resultGenerator;
        this.attemptReader = attemptReader;
        this.messageDisplay = messageDisplay;
    }

    public void run() {
        messageDisplay.display(TITLE);
        result = resultGenerator.generate();
        do {
            attempt = getNextAttempt();
        } while (isGameContinuing());
        if (attempt.isCorrect(result)) {
            messageDisplay.display("You win!");
        } else {
            messageDisplay.display("You lose!");
        }
    }

    private Attempt getNextAttempt() {
        messageDisplay.display(String.format("Attempt %d of %d\n", attemptCount + 1, MAX_ATTEMPTS));
        Attempt attempt = attemptReader.read();
        attemptCount++;
        return attempt;
    }

    private boolean isGameContinuing() {
        return attemptCount < MAX_ATTEMPTS && !attempt.isCorrect(result);
    }
}
