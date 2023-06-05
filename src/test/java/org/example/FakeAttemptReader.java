package org.example;

public class FakeAttemptReader implements AttemptReader {
    @Override
    public Attempt read() {
        return new Attempt(50);
    }
}
