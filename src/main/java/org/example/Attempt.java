package org.example;

public record Attempt(int value) {
    public boolean isCorrect(Result result) {
        return result.value() == value;
    }
}
